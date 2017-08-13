package com.hz.yk.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by wuzheng.yk on 16/12/17.
 */
public class Example2 {

    public static void main(String[] args) {
        //创建一个观察者
        Observer<String> observer = new Observer<String>() {

            @Override
            public void onError(Throwable e) {
                System.out.println("Error");
            }

            @Override
            public void onComplete() {
                System.out.println("Completed");
            }

            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };
        //使用Observable.create()创建被观察者
        Observable observable1 = Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                observableEmitter.onNext("Hello");
                observableEmitter.onNext("Wrold");
                observableEmitter.onComplete();
            }

        });
        //订阅
        observable1.subscribe(observer);
    }
}
