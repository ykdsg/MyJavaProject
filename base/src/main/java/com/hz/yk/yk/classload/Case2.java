package com.hz.yk.yk.classload;

/**
 * app classloader无法获取loader1中的Animal类，因为命名空间是隔离的
 * @author wuzheng.yk
 *         Date: 15/1/29
 *         Time: 11:01
 */
public class Case2 {
    public static void main(String[] args) {
        MyClassLoader loader1 = new MyClassLoader(null, "loader1");//使用根类加载器做父类，将命名空间隔离
        try {
            System.out.println("loader1 parent="+loader1.getParent());
            Class<?> clazz = loader1.loadClass("Animal");
            System.out.println("class loader = "+clazz.getClassLoader());
            Object object = clazz.newInstance();
            Animal animal = (Animal) object;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
