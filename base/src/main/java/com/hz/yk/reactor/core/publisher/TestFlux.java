package com.hz.yk.reactor.core.publisher;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * @author wuzheng.yk
 * @date 2019-04-23
 */
public class TestFlux {

    @Test
    public void fluxArrayTest() {
        Flux.just(1, 2, 3, 4, 5).map(i -> i * i).subscribe(new Subscriber<Integer>() { // 1

            @Override
            public void onSubscribe(Subscription s) {
                System.out.println("onSubscribe");
                s.request(6);   // 2
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext:" + integer);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }

    @Test
    public void lambdaSubscriberTest() {
        Flux.just(1, 2, 3, 4, 5).map(i -> i * 2)
            .subscribe(System.out::println, System.err::println, () -> System.out.println("Completed.")
//                        subscription -> subscription.request(3)
            );
    }
}
