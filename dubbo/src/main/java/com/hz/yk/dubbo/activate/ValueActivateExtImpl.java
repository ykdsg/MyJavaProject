package com.hz.yk.dubbo.activate;

import com.alibaba.dubbo.common.extension.Activate;

/**
 * @author wuzheng.yk
 * @date 2018/9/5
 */
@Activate(value = { "value1" }, group = { "value" })
public class ValueActivateExtImpl implements ActivateExt1 {

    @Override
    public String echo(String msg) {
        return msg;
    }
}
