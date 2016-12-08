package com.hz.yk.zest.m2;

import org.qi4j.api.mixin.Mixins;

/**
 * Created by wuzheng.yk on 16/12/1.
 */
@Mixins( SpeakerMixin.class )
public interface Speaker
{
    String sayHello();
}
