package com.yk.akka.typedactor;

import akka.actor.ActorSystem;
import akka.actor.TypedActor;
import akka.actor.TypedProps;
import akka.japi.Creator;
import akka.japi.Option;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

/**
 * Created by wuzheng.yk on 2017/8/1.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        final ActorSystem system = ActorSystem.create("helloakka");

       /*默认构造方法的Actor*/
        Squarer mySquarer =
                TypedActor.get(system).typedActorOf(
                        new TypedProps<SquarerImpl>(Squarer.class, SquarerImpl.class));

       /*传参构造的Actor*/
        Squarer otherSquarer =
                TypedActor.get(system).typedActorOf(
                        new TypedProps<SquarerImpl>(Squarer.class,
                                                    new Creator<SquarerImpl>() {
                                                        public SquarerImpl create() { return new SquarerImpl("foo"); }
                                                    }),
                        "name");



        Option<Integer> oSquare = mySquarer.squareNowPlease(10); //Option[Int]
        System.out.println("阻塞异步调用执行外面");
        //获取结果
        System.out.println(oSquare.get());

        Future<Integer> fSquare = mySquarer.square(10); //A Future[Int]
        System.out.println("非阻塞异步执行外面");
        //等待5秒内返回结果
        System.out.println(Await.result(fSquare, Duration.apply(5, TimeUnit.SECONDS)));

    }

}
