package com.hz.yk.rxjava;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import static java.lang.System.out;

/**
 * Created by wuzheng.yk on 2017/8/24.
 */
public class RxFlowableDemo {

    @Test
    public void test1() throws InterruptedException {
        Flowable<Integer> upstream = Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
                out.println("emit 1");;
                emitter.onNext(1);
                out.println("emit 2");;
                emitter.onNext(2);
                out.println("emit 3");;
                emitter.onNext(3);
                out.println("emit complete");;
                emitter.onComplete();
            }
        }, BackpressureStrategy.ERROR); //增加了一个参数

        Subscriber<Integer> downstream = new Subscriber<Integer>() {

            @Override
            public void onSubscribe(Subscription s) {
                out.println("onSubscribe");;
                s.request(Long.MAX_VALUE);  //注意这句代码
            }

            @Override
            public void onNext(Integer integer) {
                out.println("onNext: " + integer);;

            }

            @Override
            public void onError(Throwable t) {
                out.println( "onError: "+t);
            }

            @Override
            public void onComplete() {
                out.println("onComplete");;
            }
        };

        upstream.subscribe(downstream);
        Thread.sleep(1000);
    }

    public void test2() {

        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
                out.println("emit 1");;
                emitter.onNext(1);
                out.println("emit 2");;
                emitter.onNext(2);
                out.println("emit 3");;
                emitter.onNext(3);
                out.println("emit complete");;
                emitter.onComplete();
            }
        }, BackpressureStrategy.ERROR).subscribeOn(Schedulers.io())
                //.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {

                    //Flowable里默认有一个大小为128的水缸, 当上下游工作在不同的线程中时, 上游就会先把事件发送到这个水缸中,
                    // 因此, 下游虽然没有调用request, 但是上游在水缸中保存着这些事件, 只有当下游调用request时, 才从水缸里取出事件发给下游.
                    @Override
                    public void onSubscribe(Subscription s) {
                        out.println("onSubscribe");;
                    }

                    @Override
                    public void onNext(Integer integer) {
                        out.println("onNext: " + integer);;
                    }

                    @Override
                    public void onError(Throwable t) {
                        out.println("onError: " + t);
                    }

                    @Override
                    public void onComplete() {
                        out.println("onComplete");;
                    }
                });

    }

}
