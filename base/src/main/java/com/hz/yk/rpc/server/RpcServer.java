package com.hz.yk.rpc.server;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.hz.yk.rpc.common.MethodInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.List;

/**
 * @author wuzheng.yk
 * @date 2020/9/21
 */
public class RpcServer {

    private static final int BUF_SIZE = 32;
    private static ApplicationContext context;

    public static void main(String[] args)
            throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
                   InvocationTargetException {
        context = new ClassPathXmlApplicationContext("rpc/server-context.xml");

        int serverPort = 8909;
        ServerSocket servSock = new ServerSocket(serverPort);

        while (true) {
            Socket clnSock = servSock.accept();
            //查看连接上来的client相应的地址和端口号
            SocketAddress clientAddress = clnSock.getRemoteSocketAddress();
            System.out.println("handling client at " + clientAddress);

            InputStream inFromClient = clnSock.getInputStream();
            OutputStream outToClient = clnSock.getOutputStream();
            DataInputStream in = new DataInputStream(inFromClient);
            DataOutputStream out = new DataOutputStream(outToClient);
            String str = in.readUTF();
            out.writeUTF(process(str));
            clnSock.close();
        }
    }

    /**
     * 反射调研相应bean 的方法，并返回序列化的json
     *
     * @param msg
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private static String process(String msg) {
        try {
            MethodInfo methodInfo = JSON.parseObject(msg, MethodInfo.class);
            String className = methodInfo.getClassName();
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            Class<?> apiInterface = classLoader.loadClass(className);
            Object apiTarget = context.getBean(apiInterface);

            String methodName = methodInfo.getMethodName();
            String[] parameterTypes = methodInfo.getParameterTypes();
            List<Class<?>> paraClassList = Lists.newArrayList();
            for (String parameterType : parameterTypes) {
                Class<?> paraClass = classLoader.loadClass(parameterType);
                paraClassList.add(paraClass);
            }
            Method method = apiInterface.getMethod(methodName, paraClassList.toArray(new Class[0]));

            Object result = method.invoke(apiTarget, methodInfo.getParameters());

            System.out.println("server process result=" + result);
            return JSON.toJSONString(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }
}
