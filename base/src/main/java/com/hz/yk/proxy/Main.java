package com.hz.yk.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * Created by wuzheng.yk on 2017/8/10.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        CookImpl cookManager = new CookImpl();
        //jdk 生成的代理类class文件
        byte[] proxyClassFile =  ProxyGenerator.generateProxyClass(ICook.class.getName(), cookManager.getClass().getInterfaces());
        saveToFile("ICook.class",proxyClassFile);


        DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler(cookManager);
        ICook iCook = (ICook) Proxy.newProxyInstance(dynamicProxyHandler.getClass().getClassLoader(),
                                                     cookManager.getClass().getInterfaces(), dynamicProxyHandler);
        //打印一下代理类的类名
        System.out.println(iCook.getClass().getName());
        iCook.dealWithFood();
        iCook.cook();
    }

    static void saveToFile(String path, byte[] proxyClassFile) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        fos.write(proxyClassFile);
        fos.close();
    }

}
