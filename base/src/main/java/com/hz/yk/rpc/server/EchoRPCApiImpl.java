package com.hz.yk.rpc.server;

import com.hz.yk.rpc.api.EchoApi;

/**
 * @author wuzheng.yk
 * @date 2020/9/21
 */
public class EchoRPCApiImpl implements EchoApi {

    @Override
    public String echo(String msg) {
        return msg;
    }
}
