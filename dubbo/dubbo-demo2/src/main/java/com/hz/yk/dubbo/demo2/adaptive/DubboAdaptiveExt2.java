package com.hz.yk.dubbo.demo2.adaptive;

import com.alibaba.dubbo.common.URL;

/**
 * @author wuzheng.yk
 * @date 2018/9/5
 */
public class DubboAdaptiveExt2 implements AdaptiveExt2 {

    @Override
    public String echo(String msg, URL url) {
        return "dubbo";
    }
}
