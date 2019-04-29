package com.hz.yk.reactor.core.publisher;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.function.Function;

/**
 * @author wuzheng.yk
 * @date 2019-04-25
 */
public class FluxMap<T, R> extends Flux<R> {

    private final Flux<? extends T>                source;
    private final Function<? super T, ? extends R> mapper;

    public FluxMap(Flux<? extends T> source, Function<? super T, ? extends R> mapper) {
        this.source = source;
        this.mapper = mapper;
    }

    @Override
    public void subscribe(Subscriber<? super R> actual) {
        source.subscribe(new MapSubscriber<>(actual, mapper));
    }

    static final class MapSubscriber<T, R> implements Subscriber<T>, Subscription {

        private final Subscriber<? super R>            actual;
        private final Function<? super T, ? extends R> mapper;

        boolean done;

        Subscription subscriptionOfUpstream;

        MapSubscriber(Subscriber<? super R> actual, Function<? super T, ? extends R> mapper) {
            this.actual = actual;
            this.mapper = mapper;
        }

        @Override
        public void onSubscribe(Subscription s) {
            this.subscriptionOfUpstream = s;
            //回调下游的onSubscribe，将自身作为Subscription传递过去
            actual.onSubscribe(this);
        }

        @Override
        public void onNext(T t) {
            if (done) {
                return;
            }
            actual.onNext(mapper.apply(t));
        }

        @Override
        public void onError(Throwable t) {
            if (done) {
                return;
            }
            done = true;
            actual.onError(t);
        }

        @Override
        public void onComplete() {
            if (done) {
                return;
            }
            done = true;
            actual.onComplete();
        }

        @Override
        public void request(long n) {
            this.subscriptionOfUpstream.request(n);
        }

        @Override
        public void cancel() {
            this.subscriptionOfUpstream.cancel();
        }
    }
}
