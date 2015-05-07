package com.hz.yk.module.modules;

import com.hz.yk.module.ItemDO;

/**
 * 模块是一个比较大的完整的操作实现，模块会调用plugin和其他service去完成操作
 * @author wuzheng.yk
 *         Date: 15/5/7
 *         Time: 14:42
 */
public interface ArrangeModule {

    void publish(ItemDO itemDO);
}
