package com.hz.yk.reactor.demo;

import org.junit.Test;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

/**
 * @author wuzheng.yk
 * @date 2020/6/19
 */
public class FluxTest {

    private static final Logger log = LoggerFactory.getLogger(FluxTest.class);

    @Test
    public void testDefer() {
        AtomicInteger subscribeTime = new AtomicInteger(1);
        Supplier<? extends Publisher<Integer>> supplier = () -> {
            Integer[] array = { 1, 2, 3, 4, 5 };
            int currentTime = subscribeTime.getAndIncrement();
            for (int i = 0; i < array.length; i++) {
                array[i] *= currentTime;
            }
            return Flux.fromArray(array);
        };
        //defer构造出的Flux流，每次调用subscribe方法时，都会调用Supplier获取Publisher实例作为输入
        Flux<Integer> deferedFlux = Flux.defer(supplier);

        subscribe(deferedFlux, subscribeTime);
        subscribe(deferedFlux, subscribeTime);
        subscribe(deferedFlux, subscribeTime);
    }

    @Test
    public void testConcat() {
        Flux<Integer> source1 = Flux.just(1, 2, 3, 4, 5);
        Flux<Integer> source2 = Flux.just(6, 7, 8, 9, 10);
        //concat 及其重载方法接收 多个Publisher拼接为一个Flux返回，返回元素时首先返回接收到的第一个Publisher流中的元素，直到第一个Publisher流结束之后，才开始返回第二个Publisher流中的元素，依次类推... 如果发生异常，Flux流会立刻异常终止
        Flux<Integer> concat = Flux.concat(source1, source2);
        concat.subscribe(System.out::println);
    }

    @Test
    public void testConcatDelayError() {
        Flux<Integer> sourceWithErrorNumFormat = Flux.just("1", "2", "3", "4", "Five")
                .map(str -> Integer.parseInt(str));
        Flux<Integer> source = Flux.just("5", "6", "7", "8", "9").map(str -> Integer.parseInt(str));
        //concatDelayError会等待所有的流处理完成之后，再将异常传播下去
        Flux<Integer> concated = Flux.concatDelayError(sourceWithErrorNumFormat, source);
        concated.subscribe(mySubscriber());
    }

    @Test
    public void testMerge() throws InterruptedException {
        Flux<Long> flux1 = Flux.interval(Duration.ofSeconds(1), Duration.ofSeconds(1));
        Flux<Long> flux2 = Flux.interval(Duration.ofSeconds(2), Duration.ofSeconds(1));
        //merge和concat方法类似，只是不会依次返回每个Publisher流中数据，而是哪个Publisher中先有数据生成，就立刻返回。如果发生异常，会立刻抛出异常并终止
        // 即要尽快返回数据，又要考虑流的顺序，即同时有数据生成时，优先输出排在前面的流，此时可以使用mergeSequential方法
        Flux<Long> mergedFlux = Flux.merge(flux1, flux2);
        mergedFlux.subscribe(System.out::println);
        Thread.sleep(5000);
    }

    @Test
    public void testCreate() throws InterruptedException {
        MyEventProcessor myEventProcessor = new ScheduledSingleListenerEventProcessor();
        //create方法，将已有的异步事件流，包装为Flux流。
        Flux.create(sink -> {
            myEventProcessor.register(new MyEventListener<String>() {

                @Override
                public void onEvents(List<String> chunk) {
                    for (String s : chunk) {
                        if ("end".equalsIgnoreCase(s)) {
                            sink.complete();
                            myEventProcessor.shutdown();
                        } else {
                            sink.next(s);
                        }

                    }
                }

                @Override
                public void processComplete() {
                    sink.complete();
                }
            });
        }).log().subscribe(System.out::println);
        myEventProcessor.fireEvents("abc", "efg", "123", "456", "end");
        System.out.println("main thread exit");
        Thread.sleep(5000);
    }

    private static Subscriber mySubscriber() {
        return new Subscriber() {

            Subscription subscription;

            @Override
            public void onSubscribe(Subscription s) {
                this.subscription = s;
                System.out.println("on Subscriber");
                subscription.request(1);
            }

            @Override
            public void onNext(Object o) {
                System.out.println("on next is :" + o);
                subscription.request(1);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("sout [FluxTest-onError]error");
                log.error("[FluxTest-onError]error", t);
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };
    }

    private static void subscribe(Flux<Integer> deferedFlux, AtomicInteger subscribeTime) {
        System.out.println("Subscribe time is " + subscribeTime.get());
        deferedFlux.subscribe(System.out::println);
    }

}
