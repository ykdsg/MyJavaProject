package com.hz.yk.yk.doclet;

import com.hz.yk.yk.doclet.annotation.DocAPIResource;
import com.hz.yk.yk.doclet.support.ClassInfo;
import com.hz.yk.yk.doclet.support.FieldInfo;
import com.hz.yk.yk.doclet.support.MethodInfo;
import com.hz.yk.yk.doclet.support.ParameterInfo;
import com.sun.javadoc.AnnotationDesc;
import com.sun.javadoc.AnnotationTypeDoc;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.DocErrorReporter;
import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.ParamTag;
import com.sun.javadoc.Parameter;
import com.sun.javadoc.ParameterizedType;
import com.sun.javadoc.RootDoc;
import com.sun.javadoc.Type;
import com.sun.tools.doclets.standard.Standard;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

/**
 * @author wuzheng.yk
 *         Date: 13-3-19
 *         Time: 下午7:56
 */
public class APIDoclet {
    static final String APIS_INFO = "apis.info";

    public static boolean start(RootDoc root) {
        try {
            ClassDoc[] classes = root.classes();
            Map<String, ClassInfo> classDescs = new HashMap<String, ClassInfo>();
            for (ClassDoc classDoc : classes) {
                if (!isDocAPIClass(root, classDoc)) {
                    continue;
                }
                processClassInfo(root, classDoc, classDescs);
            }
            root.printNotice("class metainfos : " + classDescs.keySet().toString());
            // 持久
            MyAPIDocletUtil.storeAPIInfoAsBean(MyAPIDocletUtil.getOutputDirectory(root.options()), classDescs);
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            root.printError("RPCAPIDoclet error : " + stringWriter.toString());
            return false;
        }
        return true;
    }


    private static void processClassInfo(RootDoc root, ClassDoc classDoc, Map<String, ClassInfo> classDescs) {
        if (classDoc == null || classDescs.containsKey(classDoc.qualifiedName()) ||
                !MyAPIDocletUtil.isCustomPOJO(classDoc.qualifiedTypeName()) ||
                StringUtils.isBlank(classDoc.commentText())) {
            return;
        }
        ClassInfo classInfo = ClassInfo.create(classDoc.qualifiedTypeName(), classDoc.commentText(), classDoc.typeName());
        // 保存当前扫描的元信息
        classDescs.put(classDoc.qualifiedTypeName(), classInfo);

        // 处理成员属性
        FieldDoc[] fields = classDoc.fields();
        processFields(root, classDescs, classInfo, fields);

        // 处理成员方法
        MethodDoc[] methods = classDoc.methods();
        processMethods(root, classDescs, classInfo, methods);

        // =====================================================================================================================
        // 处理父类中的属性与方法
        // =====================================================================================================================
        ClassDoc superclass = classDoc.superclass();
        while (superclass != null && !superclass.qualifiedTypeName().equals("java.lang.Object")) {

            processFields(root, classDescs, classInfo, superclass.fields());
            processMethods(root, classDescs, classInfo, superclass.methods());

            superclass = superclass.superclass();
        }

    }

    private static void processMethods(RootDoc root, Map<String, ClassInfo> classDescs, ClassInfo classInfo,
                                       MethodDoc[] methods) {
        for (MethodDoc method : methods) {
            MethodInfo methodInfo = MethodInfo.create(method.name(), method.commentText(), method.returnType().qualifiedTypeName());

            // 处理方法的参数
            Parameter[] parameters = method.parameters();
            Map<String, Parameter> parameterMap = new HashMap<String, Parameter>();
            for (Parameter parameter : parameters) {
                parameterMap.put(parameter.name(), parameter);
                String paramTypeName = parameter.type().qualifiedTypeName();
                if (MyAPIDocletUtil.isCustomPOJO(paramTypeName)) {
                    processClassInfo(root, root.classNamed(paramTypeName), classDescs);
                }
            }
            for (ParamTag tag : method.paramTags()) {
                Parameter parameter = parameterMap.get(tag.parameterName());
                methodInfo.addParameterInfo(ParameterInfo.create(tag.parameterName(), tag.parameterComment(), parameter != null ? parameter.type().qualifiedTypeName() : "unknow"));
            }

            classInfo.addMethodInfo(methodInfo);
            // 处理方法的返回值
            processParameterizedType(root, classDescs, method.returnType().asParameterizedType());
            if (MyAPIDocletUtil.isCustomPOJO(methodInfo.getType().toString())) {
                processClassInfo(root, root.classNamed(methodInfo.getType().toString()), classDescs);
            }
        }
    }

    private static void processFields(RootDoc root, Map<String, ClassInfo> classDescs, ClassInfo classInfo, FieldDoc[] fields) {
        for (FieldDoc field : fields) {
            String fieldType = field.type().qualifiedTypeName();
            ParameterizedType parameterizedType = field.type().asParameterizedType();
            processParameterizedType(root, classDescs, parameterizedType);
            classInfo.addFieldInfo(FieldInfo.create(field.name(), field.commentText(), fieldType));
            if (MyAPIDocletUtil.isCustomPOJO(fieldType)) {
                processClassInfo(root, root.classNamed(fieldType), classDescs);
            }
        }
    }

    private static void processParameterizedType(RootDoc root, Map<String, ClassInfo> classDescs,
                                                 ParameterizedType parameterizedType) {
        if (parameterizedType != null) {
            Type[] typeArguments = parameterizedType.typeArguments();
            if (typeArguments != null) {
                for (Type type : typeArguments) {
                    processClassInfo(root, root.classNamed(type.qualifiedTypeName()), classDescs);
                }
            }
        }
    }

    /**
     * 检查是否需要生成doc的类
     *
     * @param root
     * @param doc
     * @return
     */
    private static boolean isDocAPIClass(RootDoc root, ClassDoc doc) {
        AnnotationDesc[] annotations = doc.annotations();
        if (annotations == null) {
            return false;
        }
        boolean result = false;
        for (AnnotationDesc annotation : annotations) {
            AnnotationTypeDoc annotationType = annotation.annotationType();
            if (annotationType == null) {
                continue;
            }
            if (annotationType.qualifiedTypeName().equals(DocAPIResource.class.getName())) {
                result = true;
                break;
            }
        }
        return result;
    }


    /**
     * 这两个方法必须有，否则标准  doclet 参数将不能使用，比如: -d
     * Check that options have the correct arguments here.
     * <p/>
     * This method is not required and will default gracefully
     * (to true) if absent.
     * <p/>
     * Printing option related error messages (using the provided
     * DocErrorReporter) is the responsibility of this method.
     *
     * @return true if the options are valid.
     */
    public static boolean validOptions(String options[][], DocErrorReporter reporter) {
        return Standard.validOptions(options, reporter);
    }

    public static int optionLength(String option) {
        return Standard.optionLength(option);
    }

    public static void main(String[] args) {
        String[] docArgs = new String[]{"-doclet", APIDoclet.class.getName(), System.getProperty("user.dir") + "/src/main/java/" + "com/hz/yk/concurrent/aqs/BooleanMutex.java"};
        com.sun.tools.javadoc.Main.execute(docArgs);
    }

}
