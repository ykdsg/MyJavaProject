package com.hz.yk.rxjava;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * Created by wuzheng.yk on 16/12/17.
 */
public class Example2 {
    public static void main(String[] args) {
        //创建一个观察者
        Observer<String> observer = new Observer<String>() {

            @Override
            public void onCompleted() {
                System.out.println("Completed");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Error");
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };
        //使用Observable.create()创建被观察者
        Observable observable1 = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello");
                subscriber.onNext("Wrold");
                subscriber.onCompleted();
            }
        });
        //订阅
        observable1.subscribe(observer);
    }
}
