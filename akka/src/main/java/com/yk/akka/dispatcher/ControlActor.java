package com.yk.akka.dispatcher;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuzheng.yk on 2017/8/1.
 */
public class ControlActor extends UntypedAbstractActor {

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof StartCommand) {

            List<ActorRef> actors = createActors(((StartCommand) message).getActorCount());

            /*这里使用了JDK1.8中的StreamAPI*/
            actors.stream().parallel().forEach(actorRef -> actorRef.tell("Insert", ActorRef.noSender()));
        }
    }

    private List<ActorRef> createActors(int actorCount) {
        //使用配置的Dispatcher需要在创建Actor实例的时候,使用withDispatcher(String)方法来指定
        Props props = Props.create(WriterActor.class).withDispatcher("writer-dispatcher");

        List<ActorRef> actors = new ArrayList<>(actorCount);
        for (int i = 0; i < actorCount; i++) {
            actors.add(getContext().actorOf(props,"writer_"+ i));
        }
        return actors;
    }

}
