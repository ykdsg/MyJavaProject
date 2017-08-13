package com.yk.akka.dispatcher;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;

/**
 * Created by wuzheng.yk on 2017/8/1.
 */
public class DispatcherMain {
    public static void main(String[] args) throws Exception {
        final ActorSystem system = ActorSystem.create("dispatcher", ConfigFactory.load("dispatcherDemo")
                                                                            .getConfig("demo5"));

        // 创建一个到greeter Actor的管道
        final ActorRef controlActor = system.actorOf(Props.create(ControlActor.class), "control");

        controlActor.tell(new StartCommand(100),ActorRef.noSender());

        //system.shutdown();
    }
}
