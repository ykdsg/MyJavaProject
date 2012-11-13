package com.hz.yk.dynamic;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yangke
 *         Date: 12-8-3
 *         Time: 下午4:33
 */
public class Main {

    private static Class<TestService> TARGET_CLASS = TestService.class;


    public static void main(String[] args) {
        InterfaceGenerator generator = new InterfaceGenerator(TARGET_CLASS.getName() + "Proxy");
        Set<Method> targetMethods = new HashSet<Method>();
        targetMethods.addAll(Arrays.asList(TARGET_CLASS.getMethods()));
        //每个方法增加一个参数
        for (Method method : targetMethods) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?>[] targetParameterTypes = new Class<?>[parameterTypes.length + 1];
            System.arraycopy(parameterTypes, 0, targetParameterTypes, 0, parameterTypes.length);
            targetParameterTypes[parameterTypes.length] = AddParm.class;
            generator.addMethod(method.getName(), targetParameterTypes, method.getReturnType());
        }
        generator.getInterfaceClass(Main.class.getClassLoader());

    }
}
