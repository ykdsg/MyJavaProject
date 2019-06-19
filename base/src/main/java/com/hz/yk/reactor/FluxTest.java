package com.hz.yk.reactor;

import org.junit.Test;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author wuzheng.yk
 * @date 2019-03-10
 */
public class FluxTest {

    /**
     * generate(Callable<S> stateSupplier, BiFunction<S,SynchronousSink<T>,S> generator)，其中 stateSupplier 用来提供初始的状态对象。在进行序列生成时，状态对象会作为 generator 使用的第一个参数传入，可以在对应的逻辑中对该状态对象进行修改以供下一次生成时使用。
     */
    @Test
    public void generate() {
        Flux.generate(sink -> {
            sink.next("Hello");
            sink.complete();
        }).subscribe(System.out::println);

        final Random random = new Random();
        Flux.generate(ArrayList::new, (list, sink) -> {
            int value = random.nextInt(100);
            list.add(value);
            sink.next(value);
            if (list.size() == 10) {
                sink.complete();
            }
            return list;
        }).subscribe(System.out::println);
    }

    @Test
    public void testBuffer() {
        //5 个包含 20 个元素的数组
        Flux.range(1, 100).buffer(20).subscribe(System.out::println);

    }

    private Flux<Integer> generateFluxFrom1To6() {
        return Flux.just(1, 2, 3, 4, 5, 6);
    }

    private Mono<Integer> generateMonoWithError() {
        return Mono.error(new Exception("some error"));
    }

    @Test
    public void testViaStepVerifier() {
        StepVerifier.create(generateFluxFrom1To6()).expectNext(1, 2, 3, 4, 5, 6).expectComplete().verify();
        StepVerifier.create(generateMonoWithError()).expectErrorMessage("some error").verify();
    }

    @Test
    public void testBackpressure() {
        Flux.range(1, 6)    // 1
            .doOnRequest(n -> System.out.println("Request " + n + " values..."))    // 2
            .subscribe(new BaseSubscriber<Integer>() {  // 3

                @Override
                protected void hookOnSubscribe(Subscription subscription) { // 4
                    System.out.println("Subscribed and make a request...");
                    request(1); // 5
                }

                @Override
                protected void hookOnNext(Integer value) {  // 6
                    try {
                        TimeUnit.SECONDS.sleep(1);  // 7
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Get value [" + value + "]");    // 8
                    request(1); // 9
                }
            });
    }
}
