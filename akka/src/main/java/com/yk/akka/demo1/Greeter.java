package com.yk.akka.demo1;

import akka.actor.UntypedAbstractActor;

/**
 * 打招呼的Actor
 * Created by wuzheng.yk on 2017/8/1.
 */
public class Greeter extends UntypedAbstractActor {

    String greeting = "";

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof WhoToGreet) {
            System.out.println("on receive WhoToGreet");
            greeting = "hello, " + ((WhoToGreet) message).who;
        } else if (message instanceof Greet) {
            System.out.println("on receive Greet");
            // 发送招呼消息给发送消息给这个Actor的Actor
            getSender().tell(new Greeting(greeting), getSelf());
        } else {
            unhandled(message);
        }
    }

}
