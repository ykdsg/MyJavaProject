package com.hz.yk.type;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * Created by wuzheng.yk on 16/1/18.
 */
public class Main {


    public static void main(String[] args) throws Exception {
        classGeneric();
        fieldGeneric();
        methodGeneric();

        methodGeneric2();

    }

    /**
     * 针对class的泛型接口使用
     * GenericClass 在类定义时，声明了继承父接口的泛型为List，所以再通过接口和父类获取泛型信息时，是能正确的获取。通过javap -v可以获取对应的class信息
     */
    private static void classGeneric() {
        System.out.println("\n--------------------- classGeneric ---------------------");
        GenericClass gc = new GenericClass();
        Type[] gis = gc.getClass().getGenericInterfaces(); // 接口的泛型信息
        Type gps = gc.getClass().getGenericSuperclass(); // 父类的泛型信息
        TypeVariable[] gtr = gc.getClass().getTypeParameters(); // 当前接口的参数信息
        System.out.println("============== getGenericInterfaces");
        for (Type t : gis) {
            System.out.println(t + " : " + getClass(t, 0));
        }
        System.out.println("============== getGenericSuperclass");
        System.out.println(getClass(gps, 0));
        System.out.println("============== getTypeParameters");
        for (TypeVariable t : gtr) {
            StringBuilder stb = new StringBuilder();
            for (Type tp : t.getBounds()) {
                stb.append(tp + " : ");
            }

            System.out.println(t + " : " + t.getName() + " : " + stb);
        }

    }

    /**
     * 针对method的泛型接口使用
     * @throws Exception
     */
    private static void methodGeneric() throws Exception {
        System.out.println("\n--------------------- methodGeneric2 ---------------------");
        GenericClass gc = new GenericClass();
        Method method3 = gc.getClass().getDeclaredMethod("method3", new Class[] { Object.class });

        Type[] gpt3 = method3.getGenericParameterTypes();
        Type[] get3 = method3.getGenericExceptionTypes();
        Type gt3 = method3.getGenericReturnType();
        System.out.println("============== getGenericParameterTypes");
        for (Type t : gpt3) {
            System.out.println(t + " : " + getClass(t, 0));
        }
        System.out.println("============== getGenericExceptionTypes");
        for (Type t : get3) {
            System.out.println(t + " : " + getClass(t, 0));
        }
        System.out.println("============== getType");
        System.out.println(gt3 + " : " + getClass(gt3, 0));
    }


    /**
     * 针对method的泛型接口使用
     * @throws Exception
     */
    private static void methodGeneric2() throws Exception {
        System.out.println("\n--------------------- methodGeneric ---------------------");
        GenericClass gc = new GenericClass();
        Method method3 = gc.getClass().getDeclaredMethod("method3", new Class[] { Object.class });

        Type[] gpt3 = method3.getGenericParameterTypes();
        Type[] get3 = method3.getGenericExceptionTypes();
        Type gt3 = method3.getGenericReturnType();

        Parameter[] parameters = method3.getParameters();
        System.out.println("============== getParameterizedType:");
        for (Parameter parameter : parameters) {
            Type type = parameter.getParameterizedType();
            System.out.println(type + " : " + getClass(type, 0));
        }

        System.out.println("============== getGenericParameterTypes");
        for (Type t : gpt3) {
            System.out.println(t + " : " + getClass(t, 0));
        }
        System.out.println("============== getGenericExceptionTypes");
        for (Type t : get3) {
            System.out.println(t + " : " + getClass(t, 0));
        }
        System.out.println("============== getType");
        System.out.println(gt3 + " : " + getClass(gt3, 0));
    }

    /**
     * 针对field的泛型接口使用
     * 因为泛型的擦拭，对应的GeneircInteface和BaseGeneircInteface，在源码信息已被擦除对应的类型，进行了upper转型，所以取到的是Object。可以使用extends
     * @throws Exception
     */
    private static void fieldGeneric() throws Exception {
        System.out.println("\n--------------------- fieldGeneric ---------------------");
        GenericClass gc = new GenericClass();
        Field field = gc.getClass().getSuperclass().getDeclaredField("result");

        Type gt = field.getGenericType();
        Type ft = field.getType();
        System.out.println("============== getGenericType");
        System.out.println(gt + " : " + getClass(gt, 0));
        System.out.println("============== getType");
        System.out.println(ft + " : " + getClass(ft, 0));
    }

    /**
     * type -> class的转换过程，同理也包括处理Generic Type。支持多级泛型处理。
     * @param type
     * @param i
     * @return
     */
    private static Class getClass(Type type, int i) {
        if (type instanceof ParameterizedType) { // 处理泛型类型
            return getGenericClass((ParameterizedType) type, i);
        } else if (type instanceof TypeVariable) {
            return (Class) getClass(((TypeVariable) type).getBounds()[0], 0); // 处理泛型擦拭对象
        } else {// class本身也是type，强制转型
            return (Class) type;
        }
    }

    private static Class getGenericClass(ParameterizedType parameterizedType, int i) {
        Object genericClass = parameterizedType.getActualTypeArguments()[i];
        if (genericClass instanceof ParameterizedType) { // 处理多级泛型
            return (Class) ((ParameterizedType) genericClass).getRawType();
        } else if (genericClass instanceof GenericArrayType) { // 处理数组泛型
            return (Class) ((GenericArrayType) genericClass).getGenericComponentType();
        } else if (genericClass instanceof TypeVariable) { // 处理泛型擦拭对象
            return (Class) getClass(((TypeVariable) genericClass).getBounds()[0], 0);
        } else {
            return (Class) genericClass;
        }
    }
}
