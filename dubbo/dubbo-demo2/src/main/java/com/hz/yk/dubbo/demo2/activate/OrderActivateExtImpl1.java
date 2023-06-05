package com.hz.yk.dubbo.demo2.activate;

import com.alibaba.dubbo.common.extension.Activate;

/**
 * @author wuzheng.yk
 * @date 2018/9/5
 */
@Activate(order = 2, group = { "order" })
public class OrderActivateExtImpl1 implements ActivateExt1 {

    @Override
    public String echo(String msg) {
        return msg;
    }
}
