package com.yk.akka.dispatcher;

import akka.actor.UntypedAbstractActor;

/**
 * Created by wuzheng.yk on 2017/8/1.
 */
public class WriterActor extends UntypedAbstractActor {

    @Override
    public void onReceive(Object message) throws Exception {
        System.out.println(Thread.currentThread().getName());
    }

}
