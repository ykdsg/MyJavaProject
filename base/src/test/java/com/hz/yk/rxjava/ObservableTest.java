package com.hz.yk.rxjava;

import org.junit.Test;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by wuzheng.yk on 16/11/30.
 */
public class ObservableTest {

    @Test
    public void demo() {
        Observable<Subscriber> integerObservable = Observable.create(new Observable.OnSubscribe<Subscriber>() {
            @Override
            public void call(Subscriber subscriber) {
                subscriber.onNext(1);
                subscriber.onNext(2);
                subscriber.onNext(3);
                subscriber.onCompleted();
            }
        });

        Subscriber integerSubscriber = new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("Complete!");
            }
            @Override
            public void onError(Throwable e) {
            }
            @Override
            public void onNext(Integer value) {
                System.out.println("onNext: " + value);
            }
        };

        integerObservable.subscribe(integerSubscriber);
    }

    public static void main(String[] args) {
        String test = "{userID=111111,LOGIN_ROLE=ssdd}";
        System.out.println(test.contains("LOGIN_ROLE"));
    }
}
