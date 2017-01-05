package com.hz.yk.zest.m2;

import org.qi4j.api.mixin.Mixins;

/**
 * 通过 @Mixins 绑定实现
 * Created by wuzheng.yk on 16/12/1.
 */
@Mixins( SpeakerMixin.class )
public interface Speaker
{
    String sayHello();
}
