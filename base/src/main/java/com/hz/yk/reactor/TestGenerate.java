package com.hz.yk.reactor;

import com.hz.yk.reactor.core.publisher.MyEventListener;
import com.hz.yk.reactor.core.publisher.MyEventSource;
import org.junit.Test;
import reactor.core.publisher.Flux;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://blog.csdn.net/get_set/article/details/79549401
 *
 * @author wuzheng.yk
 * @date 2019-04-26
 */
public class TestGenerate {

    /**
     * generate是一种同步地，逐个地发出数据的方法。因为它提供的sink是一个SynchronousSink， 而且其next()方法在每次回调的时候最多只能被调用一次
     */
    @Test
    public void testGenerate1() {
        final AtomicInteger count = new AtomicInteger(1);
        Flux.generate(sink -> {
            sink.next(count.get() + " : " + new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count.getAndIncrement() >= 5) {
                sink.complete();
            }
        }).subscribe(System.out::println);
    }

    @Test
    public void testGenerate2() {
        Flux.generate(() -> 1,    // 1 初始化状态值
                      (count, sink) -> {      // 2 第二个参数是BiFunction，输入为状态和sink；
                          sink.next(count + " : " + new Date());
                          try {
                              TimeUnit.SECONDS.sleep(1);
                          } catch (InterruptedException e) {
                              e.printStackTrace();
                          }
                          if (count >= 5) {
                              sink.complete();
                          }
                          return count + 1;   // 3 每次循环都要返回新的状态值给下次使用
                      }).subscribe(System.out::println);
    }

    /**
     * 第三个方法签名除了状态、sink外，还有一个Consumer，这个Consumer在数据流发完后执行
     */
    @Test
    public void testGenerate3() {
        Flux.generate(() -> 1, (count, sink) -> {
            sink.next(count + " : " + new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count >= 5) {
                sink.complete();
            }
            return count + 1;
        }, System.out::println).subscribe(System.out::println);
    }

    /**
     * create是一个更高级的创建Flux的方法，其生成数据流的方式既可以是同步的，也可以是异步的，并且还可以每次发出多个元素
     *
     * @throws InterruptedException
     */
    @Test
    public void testCreate() throws InterruptedException {
        MyEventSource eventSource = new MyEventSource();
        Flux.create(sink -> {
            //向事件源注册用匿名内部类创建的监听器
            eventSource.register(new MyEventListener() {

                @Override
                public void onNewEvent(MyEventSource.MyEvent event) {
                    //监听器在收到事件回调的时候通过sink将事件再发出
                    sink.next(event);
                }

                @Override
                public void onEventStopped() {
                    //监听器再收到事件源停止的回调的时候通过sink发出完成信号
                    sink.complete();
                }
            });
            //    触发订阅
        }).subscribe(System.out::println);

        //循环产生20个事件，每个间隔不超过1秒的随机时间
        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
            eventSource.newEvent(new MyEventSource.MyEvent(new Date(), "Event-" + i));
        }
        //最后停止事件源
        eventSource.eventStopped();
    }
}
