package com.hz.yk.ddd.demo3;

import com.sun.istack.internal.NotNull;

/**
 * https://juejin.cn/post/6845166890554228744
 *
 * @author wuzheng.yk
 * @date 2021/1/20
 */
public interface Repository<T extends Aggregate<ID>, ID extends Identifier> {

    /**
     * 将一个Aggregate附属到一个Repository，让它变为可追踪。
     * Change-Tracking在下文会讲，非必须
     */
    void attach(@NotNull T aggregate);

    /**
     * 解除一个Aggregate的追踪
     * Change-Tracking在下文会讲，非必须
     */
    void detach(@NotNull T aggregate);

    /**
     * 通过ID寻找Aggregate。
     * 找到的Aggregate自动是可追踪的
     */
    T find(@NotNull ID id);

    /**
     * 将一个Aggregate从Repository移除
     * 操作后的aggregate对象自动取消追踪
     */
    void remove(@NotNull T aggregate);

    /**
     * 保存一个Aggregate
     * 保存后自动重置追踪条件
     */
    void save(@NotNull T aggregate);

}