package com.hz.yk.instrument;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 * Created by wuzheng.yk on 15/11/4.
 */
public class MonitorTransformer implements ClassFileTransformer {

    final static String       prefix     = "\n long startTime = System.currentTimeMillis();\n";
    final static String       postfix    = "\n long endTime = System.currentTimeMillis();\nSystem.out.println(\"cost:\" +(endTime - startTime) +\"ms.\");";

    /*
     * (non-Javadoc)
     * @see java.lang.instrument.ClassFileTransformer#transform(java.lang.ClassLoader, java.lang.String,
     * java.lang.Class, java.security.ProtectionDomain, byte[])
     */
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer)
                                                                                      throws IllegalClassFormatException {
        // 先判断下现在加载的class的包路径是不是需要监控的类，通过instrumentation进来的class路径用‘/’分割
        // 将‘/’替换为‘.’m比如monitor/agent/Mytest替换为monitor.agent.Mytest
        className = className.replace("/", ".");
        CtClass ctclass = null;
        try {
            System.out.println("current class:"+className);
            // 用于取得字节码类，必须在当前的classpath中，使用全称 ,这部分是关于javassist的知识
            ctclass = ClassPool.getDefault().get(className);
            CtMethod[] ctmethods = ctclass.getMethods();
            // 循环一下，看看哪些方法需要加时间监测
            for (CtMethod method : ctmethods) {
                // 获取方法名
                String methodName = method.getName();
                if (methodName.equals("test")) {
                    //构建新的方法体
                    String testOut = "System.out.println(\"hello ,world\");";
                    method.insertBefore(testOut);
                    //method.insertBefore(prefix);
                    //method.insertAfter(postfix);
                }

            }
            return ctclass.toBytecode();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (CannotCompileException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
