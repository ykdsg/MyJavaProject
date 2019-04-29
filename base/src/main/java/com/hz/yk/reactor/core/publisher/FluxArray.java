package com.hz.yk.reactor.core.publisher;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * @author wuzheng.yk
 * @date 2019-04-23
 */
public class FluxArray<T> extends Flux<T> {

    private T[] array;  // 1

    public FluxArray(T[] data) {
        this.array = data;
    }

    @Override
    public void subscribe(Subscriber<? super T> actual) {
        actual.onSubscribe(new ArraySubscription<>(actual, array)); // 2
    }

    /**
     * 是发布者和订阅者的中间人，向发布者请求n个元素，然后通过回调订阅者的onNext方法发送数据，发送完成就调用onComplete，如果有错误发送onError
     *
     * @param <T>
     */
    static class ArraySubscription<T> implements Subscription { // 1

        final Subscriber<? super T> actual;
        final T[]                   array;    // 2
        int     index;
        boolean canceled;

        public ArraySubscription(Subscriber<? super T> actual, T[] array) {
            this.actual = actual;
            this.array = array;
        }

        @Override
        public void request(long n) {
            if (canceled) {
                return;
            }
            long length = array.length;
            for (int i = 0; i < n && index < length; i++) {
                actual.onNext(array[index++]);  // 3
            }
            if (index == length) {
                actual.onComplete();    // 4
            }
        }

        @Override
        public void cancel() {  // 5
            this.canceled = true;
        }
    }
}
