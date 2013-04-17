package com.hz.yk.doclet;

import com.hz.yk.doclet.annotation.DocAPIResource;
import com.sun.javadoc.AnnotationDesc;
import com.sun.javadoc.AnnotationTypeDoc;
import com.sun.javadoc.ClassDoc;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wuzheng.yk
 *         Date: 13-3-20
 *         Time: 上午9:25
 */
public class MyAPIDocletUtil {
    private static final Set<String> primitiveTypeNames = new HashSet<String>(16);

    static {
        primitiveTypeNames.add(Boolean.class.getName());
        primitiveTypeNames.add(Byte.class.getName());
        primitiveTypeNames.add(Character.class.getName());
        primitiveTypeNames.add(Double.class.getName());
        primitiveTypeNames.add(Float.class.getName());
        primitiveTypeNames.add(Integer.class.getName());
        primitiveTypeNames.add(Long.class.getName());
        primitiveTypeNames.add(Short.class.getName());
        primitiveTypeNames.addAll(Arrays.asList(boolean[].class.getName(), byte[].class.getName(), char[].class.getName(),
                double[].class.getName(), float[].class.getName(), int[].class.getName(), long[].class.getName(),
                short[].class.getName()));
        primitiveTypeNames.addAll(Arrays.asList("boolean", "byte", "char", "double", "float", "int", "long", "short"));
    }

    /**
     * 是否用户自定义的类
     * @param name
     * @return
     */
    static boolean isCustomPOJO(String name) {
        return !(primitiveTypeNames.contains(name) || name.startsWith("java.") || name.startsWith("javax.") || "void"
                .equals(name));
    }

    public static void main(String[] args) {
        String encoding = System.getProperty("file.encoding");
        System.out.println("Default System Encoding: " + encoding);
    }

    static void storeAPIInfoAsBean(File outputDirectory, Object classDescs) throws UnsupportedEncodingException, FileNotFoundException, IOException {
        ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream(new File(outputDirectory,
                APIDoclet.APIS_INFO)));
        objout.writeObject(classDescs);
        objout.flush();
        objout.close();
    }


    static File getOutputDirectory(String[][] options) {
        for (String[] o : options) {
            if (o[0].equals("-d")) {
                return new File(o[1]);
            }
        }
        return new File(System.getProperty("user.dir", "."));
    }

    /**
     * 检查是否需要生成doc的类
     *
     * @param doc
     * @return
     */
    public static boolean isDocAPIClass(ClassDoc doc) {
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
}
