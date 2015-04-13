package com.hz.yk.yk.rpc;

/**
 * @author wuzheng.yk
 *         Date: 13-4-3
 *         Time: ионГ10:09
 */
public class RpcProvider {
    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFramework.export(service, 1234);
    }
}
