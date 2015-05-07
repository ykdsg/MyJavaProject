package com.hz.yk.module.router;

/**
 * @author wuzheng.yk
 *         Date: 15/5/7
 *         Time: 15:32
 */
public class RouterInfo {
    public static final String PLUGIN_PACKAGE = "com.hz.yk.module.extension.";

    public static final String DEFAULT_CLASS_POSTFIX = "Impl";
    /**
     * package Ç°×º
     */
    String packagePrefix;
    /**
     * classºó×º
     */
    String classPostfix;


    public String getPackagePrefix() {
        return packagePrefix;
    }

    public void setPackagePrefix(String packagePrefix) {
        this.packagePrefix = packagePrefix;
    }

    public String getClassPostfix() {
        return classPostfix;
    }

    public void setClassPostfix(String classPostfix) {
        this.classPostfix = classPostfix;
    }
}
