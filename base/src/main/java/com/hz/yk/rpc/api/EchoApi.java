package com.hz.yk.rpc.api;

/**
 * @author wuzheng.yk
 * @date 2020/9/21
 */
public interface EchoApi {

    /**
     * 输入什么返回什么
     *
     * @param msg
     * @return
     */
    String echo(String msg);

}
