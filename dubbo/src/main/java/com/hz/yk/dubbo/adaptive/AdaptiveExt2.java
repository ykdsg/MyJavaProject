package com.hz.yk.dubbo.adaptive;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author wuzheng.yk
 * @date 2018/9/5
 */
@SPI("dubbo")
public interface AdaptiveExt2 {

    @Adaptive({ "t" })
    String echo(String msg, URL url);
}
