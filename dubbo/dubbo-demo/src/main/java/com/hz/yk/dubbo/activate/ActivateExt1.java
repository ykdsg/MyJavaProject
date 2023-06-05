package com.hz.yk.dubbo.activate;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author wuzheng.yk
 * @date 2018/9/5
 */
@SPI
public interface ActivateExt1 {

    String echo(String msg);
}
