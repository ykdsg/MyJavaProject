package com.yk.akka.demo1;

import akka.actor.UntypedAbstractActor;

/**
 * 打印招呼
 * Created by wuzheng.yk on 2017/8/1.
 */
public class GreetPrinter extends UntypedAbstractActor {

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Greeting)
            System.out.println(((Greeting) message).message);
    }

}
