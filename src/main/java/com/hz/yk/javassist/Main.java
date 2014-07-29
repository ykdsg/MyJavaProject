package com.hz.yk.javassist;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 * @author wuzheng.yk
 *         Date: 14-7-11
 *         Time: ÏÂÎç7:44
 */
public class Main {

    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.hz.yk.javassist.TestClass");
        CtMethod ctMethod = CtMethod.make("public void print(){ System.out.println(\"print test2\");  }",cc);
        cc.addMethod(ctMethod);
        Class c = cc.toClass();
        Object dymicObj = c.newInstance();
        Method print = c.getMethod("print2");
        print.invoke(dymicObj);
    }
}
