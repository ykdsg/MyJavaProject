package com.yk.akka.tostring;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import com.typesafe.config.ConfigFactory;

import java.util.UUID;

/**
 * Created by wuzheng.yk on 2017/8/2.
 */
public class ToStringActor extends UntypedAbstractActor {
    @Override
    public void onReceive(Object message) {
        System.out.println(message.toString());
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("dispatcher", ConfigFactory.load("toStringDemo")
                                                                                 .getConfig("demo5"));
        //.withDispatcher("writer-dispatcher")
        for(int i=0;i<10000000;i++) {
            final ActorRef toString = system.actorOf(
                    Props.create(ToStringActor.class),
                    "toString" + UUID.randomUUID().toString());
            toString.tell("test"+i,toString);
        }
        System.out.println("[结束]=======================");
    }

}
