package com.hz.yk.doclet.support;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wuzheng.yk
 *         Date: 13-3-20
 *         Time: ÉÏÎç9:38
 */
public class ClassInfo extends BaseInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<FieldInfo> fieldInfos;

    private List<MethodInfo> methodInfos;

    public static ClassInfo create(String name, String comment, Object type) {
        ClassInfo info = new ClassInfo();
        info.setName(name);
        info.setComment(comment);
        info.setType(type);

        info.setFieldInfos(new ArrayList<FieldInfo>());
        info.setMethodInfos(new ArrayList<MethodInfo>());

        return info;
    }

    public ClassInfo addFieldInfo(FieldInfo fieldInfo) {

        this.fieldInfos.add(fieldInfo);
        return this;
    }

    public ClassInfo addMethodInfo(MethodInfo methodInfo) {

        this.methodInfos.add(methodInfo);
        return this;
    }


    public FieldInfo getFieldInfo(String name) {

        FieldInfo result = null;

        for (FieldInfo info : this.fieldInfos) {
            if (info.getName().equals(name)) {

                result = info;
                break;
            }
        }

        return result;
    }

    public MethodInfo getMethodInfo(String name) {

        MethodInfo result = null;

        for (MethodInfo info : this.methodInfos) {
            if (info.getName().equals(name)) {

                result = info;
                break;
            }
        }

        return result;
    }


    public List<FieldInfo> getFieldInfos() {
        return fieldInfos;
    }

    public void setFieldInfos(List<FieldInfo> fieldInfos) {
        this.fieldInfos = fieldInfos;
    }

    public List<MethodInfo> getMethodInfos() {
        return methodInfos;
    }

    public void setMethodInfos(List<MethodInfo> methodInfos) {
        this.methodInfos = methodInfos;
    }
}
