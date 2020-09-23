package com.hz.yk.rpc.client;

import com.alibaba.fastjson.JSON;
import com.hz.yk.rpc.common.MethodInfo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Arrays;

/**
 * @author wuzheng.yk
 * @date 2020/9/21
 */
public class RPCInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MethodInfo methodInfo = new MethodInfo();
        Class<?>[] parameterTypes = method.getParameterTypes();
        String[] paramterTypeNames = Arrays.stream(parameterTypes).map(Class::getName).toArray(String[]::new);

        methodInfo.setParameterTypes(paramterTypeNames);
        methodInfo.setMethodName(method.getName());
        methodInfo.setClassName(method.getDeclaringClass().getName());
        methodInfo.setParameters(args);

        String rpcMethodInfoStr = JSON.toJSONString(methodInfo);

        String server = "127.0.0.1";
        int serverPort = 8909;
        Socket socket = new Socket(server, serverPort);
        //在debug 的时候有点奇怪，如果断点在下面这行就会卡住，现在发现有可能跟这个类是代理的有关系，直接调用的时候是可以打断点的。
        OutputStream outToServer = socket.getOutputStream();
        DataOutputStream out = new DataOutputStream(outToServer);

        out.writeUTF(rpcMethodInfoStr);
        out.flush();

        InputStream inFromServer = socket.getInputStream();
        DataInputStream in = new DataInputStream(inFromServer);
        String resultJson = in.readUTF();

        Class<?> returnType = method.getReturnType();
        Object resultObj = JSON.parseObject(resultJson, returnType);
        socket.close();
        return resultObj;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method testM = MethodInfo.class.getMethod("getMethodName");
        Class<?> declaringClass = testM.getDeclaringClass();
        System.out.println(testM.getName());
        System.out.println(declaringClass.getName());
    }
}
