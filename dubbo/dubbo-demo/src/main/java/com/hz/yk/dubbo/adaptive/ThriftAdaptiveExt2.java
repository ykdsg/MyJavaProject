package com.hz.yk.dubbo.adaptive;

import com.alibaba.dubbo.common.URL;

/**
 * @author wuzheng.yk
 * @date 2018/9/5
 */
//@Adaptive
public class ThriftAdaptiveExt2 implements AdaptiveExt2 {

    @Override
    public String echo(String msg, URL url) {
        return "thrift";
    }

}
