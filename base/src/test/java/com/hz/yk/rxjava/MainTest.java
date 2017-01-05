package com.hz.yk.rxjava;

import org.junit.Test;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by wuzheng.yk on 16/12/17.
 */
public class MainTest {

    @Test
    public void action() {
        // 处理onNext()中的内容
        Action1<String> onNextAction = new Action1<String>() {

            @Override
            public void call(String s) {
                System.out.println(s);
            }
        };
        // 处理onError()中的内容
        Action1<Throwable> onErrorAction = new Action1<Throwable>() {

            @Override
            public void call(Throwable throwable) {

            }
        };
        // 处理onCompleted()中的内容
        Action0 onCompletedAction = new Action0() {

            @Override
            public void call() {
                System.out.println("Completed");

            }
        };
        // 使用 onNextAction 来定义 onNext()
        Observable.just("Hello", "World").subscribe(onNextAction);
        // 使用 onNextAction 和 onErrorAction 来定义 onNext() 和 onError()
        Observable.just("Hello", "World").subscribe(onNextAction, onErrorAction);
        // 使用 onNextAction、 onErrorAction 和 onCompletedAction 来定义 onNext()、 onError() 和 onCompleted()
        Observable.just("Hello", "World").subscribe(onNextAction, onErrorAction, onCompletedAction);
    }

    @Test
    public void testScheduler() throws InterruptedException {
        Observable.just("Hello", "Word")
                .subscribeOn(Schedulers.newThread())//指定 subscribe() 发生在新的线程
                .observeOn(Schedulers.io())// 指定 Subscriber 的回调发生在io线程
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println(s+",currentThread="+Thread.currentThread().getName());
                    }
                });

        Thread.sleep(800);
        System.out.println("currentThread=" + Thread.currentThread().getName());

    }

    @Test
    public void testScheduler2() throws InterruptedException {
        Observable.just("Hello", "Wrold")
                .subscribeOn(Schedulers.newThread())//指定：在新的线程中发起
                .observeOn(Schedulers.io())         //指定：在io线程中处理
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        System.out.println("map "+s+",currentThread="+Thread.currentThread().getName());
                        return s;       //处理数据
                    }

                })
                .observeOn(Schedulers.computation())//指定：在新线程中处理
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println("subscribe "+s+",currentThread="+Thread.currentThread().getName());
                                              //消费事件
                    }
                });
        Thread.sleep(800);
        System.out.println("currentThread=" + Thread.currentThread().getName());
    }
}
