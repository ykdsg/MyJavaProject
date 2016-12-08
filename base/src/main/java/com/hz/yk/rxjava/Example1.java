package com.hz.yk.rxjava;

import rx.Single;
import rx.SingleSubscriber;

/**
 * Created by wuzheng.yk on 16/11/30.
 */
public class Example1 {
    public static void main(String[] args) {
        Single.just(addValue(1, 2)).subscribe(new SingleSubscriber<Integer>() {
            @Override
            public void onSuccess(Integer value) {
                System.out.println(value);
            }
            @Override
            public void onError(Throwable error) {}
        });
    }

    static int addValue(int a, int b) {
        return a + b;
    }

}
