package com.yk.akka.demo1;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Inbox;
import akka.actor.Props;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

/**
 * Created by wuzheng.yk on 2017/8/1.
 */
public class DemoMain {
    public static void main(String[] args) throws Exception {
        final ActorSystem system = ActorSystem.create("helloakka");

        // 创建一个到greeter Actor的管道
        final ActorRef greeter = system.actorOf(Props.create(Greeter.class), "greeter");

        // 创建邮箱
        final Inbox inbox = Inbox.create(system);

        // 先发第一个消息,消息内容是WhoToGreet，发送者为空，这就意味着在greeter这个Actor内部,调用sender是不能获取到发送者的.通过这个动作,就把消息限定为了单向的
        greeter.tell(new WhoToGreet("akka"), ActorRef.noSender());

        // 使用邮箱显示的发送一个Greet消息给greeter.这是给Actor发送消息的另外一种方法,这种方法通常会有更高的自主性,
        // 能完成更多更复杂的操作.但是调用起来比直接使用ActorRef来的复杂
        inbox.send(greeter, new Greet());

        // 等待5秒尝试接收Greeter返回的消息，.如果5秒内没有获取到,那么就抛出TimeoutException异常.
        // 由于我们在greeter这个Actor中有处理,接收到Greet消息后,就构造一个Greeting消息给sender,因此这个地方是能够正确的获取到消息的反馈的
        Greeting greeting1 = (Greeting) inbox.receive(Duration.create(5, TimeUnit.SECONDS));
        System.out.println("Greeting: " + greeting1.message);

        // 发送第三个消息,修改名字
        greeter.tell(new WhoToGreet("typesafe"), ActorRef.noSender());
        // 发送第四个消息
        inbox.send(greeter, new Greet());

        // 等待5秒尝试接收Greeter返回的消息
        Greeting greeting2 = (Greeting) inbox.receive(Duration.create(5, TimeUnit.SECONDS));
        System.out.println("Greeting: " + greeting2.message);

        // 新创建一个Actor的管道
        ActorRef greetPrinter = system.actorOf(Props.create(GreetPrinter.class));

        //使用schedule 每一秒发送一个Greet消息给 greeterActor,然后把greeterActor的消息返回给greetPrinterActor
        system.scheduler().schedule(Duration.Zero(), Duration.create(1, TimeUnit.SECONDS), greeter, new Greet(), system.dispatcher(), greetPrinter);
        //system.shutdown();
    }
}
