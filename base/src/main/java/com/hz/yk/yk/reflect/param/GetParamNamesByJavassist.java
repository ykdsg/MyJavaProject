package com.hz.yk.yk.reflect.param;

import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 这种和sping的方式一样都需要javac 开启generate debug info,
 * 通过maven 的话默认是debug=true 的,所以不会有问题
 *
 * 通过javassit获取方法参数的名称
 * Created by wuzheng.yk on 16/1/29.
 */
public class GetParamNamesByJavassist {
    public static void main(String[] args) throws NotFoundException {
        Method[] methods = Demo.class.getDeclaredMethods();
        Class clazz = methods[0].getDeclaringClass();
        String methodName = methods[0].getName();
        ClassPool pool = ClassPool.getDefault();
        pool.insertClassPath(new ClassClassPath(clazz));
        CtClass cc = pool.get(clazz.getName());
        CtMethod cm = cc.getDeclaredMethod(methodName);
        MethodInfo methodInfo = cm.getMethodInfo();
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
        LocalVariableAttribute attr =
                (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
        if (attr == null) {
            System.out.println("params is null");
            return;
        }
        String[] paramNames = new String[cm.getParameterTypes().length];
        int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
        for (int i = 0; i < paramNames.length; i++)
            paramNames[i] = attr.variableName(i + pos);
        for (int i = 0; i < paramNames.length; i++) {
            System.out.println(paramNames[i]);
        }
    }
}
