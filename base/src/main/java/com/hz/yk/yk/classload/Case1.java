package com.hz.yk.yk.classload;

/**
 * 使用自己的类加载器
 * @author wuzheng.yk
 *         Date: 15/1/29
 *         Time: 11:00
 */
public class Case1 {

    public static void main(String[] args) {
        MyClassLoader loader1 = new MyClassLoader(null,"loader1");//如果设置为null，将不在使用应用类加载器，如果不设置默认使用应用类加载器
        try {
            Class clazz = loader1.loadClass("Animal");
            clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
