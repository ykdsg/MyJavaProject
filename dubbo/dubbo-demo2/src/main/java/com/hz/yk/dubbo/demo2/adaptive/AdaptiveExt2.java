package com.hz.yk.dubbo.demo2.adaptive;

import com.alibaba.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * @author wuzheng.yk
 * @date 2018/9/5
 */
@SPI("dubbo")
public interface AdaptiveExt2 {

    // 测试1，测试2，测试3的时候使用
    @Adaptive
    // 测试4的时候使用
    //@Adaptive({ "t" })
    String echo(String msg, URL url);
}
