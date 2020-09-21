package com.hz.yk.rpc.client;

import com.hz.yk.rpc.api.EchoApi;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wuzheng.yk
 * @date 2020/9/21
 */
public class RpcClient {

    public static void main(String[] args) {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("rpc/client-context.xml");
        final EchoApi bean = context.getBean(EchoApi.class);
        final String result = bean.echo("hello");
        System.out.println("echo result=" + result);
    }

}
