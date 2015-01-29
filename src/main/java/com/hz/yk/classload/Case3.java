package com.hz.yk.classload;

import java.lang.reflect.Method;

/**
 * 命名空间的传递性,同一个类中应用的另一个类的加载器是相同的
 * @author wuzheng.yk
 *         Date: 15/1/29
 *         Time: 11:07
 */
public class Case3 {
    public static void main(String[] args) {
        MyClassLoader loader1 = new MyClassLoader(null, "loader1");// 使用根类加载器做父类，将命名空间隔离
        try {
            System.out.println(loader1.getParent());
            Class<?> clazz = loader1.loadClass("com.hz.yk.classload.Cat");
            System.out.println(clazz.getClassLoader());
            Object object = clazz.newInstance();
            Method method = clazz.getMethod("getDog");
            Dog dog = (Dog) method.invoke(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
