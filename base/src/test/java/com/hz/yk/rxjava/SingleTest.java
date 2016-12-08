package com.hz.yk.rxjava;

import org.junit.Test;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static com.hz.yk.rxjava.Example1.addValue;

/**
 * Created by wuzheng.yk on 16/11/30.
 */
public class SingleTest {

    @Test
    public void testCreate() {

// 常见的示例，这是一个异步操作
        Single.create(new Single.OnSubscribe<Integer>() {
            @Override
            public void call(SingleSubscriber<? super Integer> singleSubscriber) {
                // 这里被指定在IO线程
                singleSubscriber.onSuccess(addValue(1, 2));
            }
        }).subscribeOn(Schedulers.io())// 指定运行在IO线程
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(Integer o) {
                        System.out.println(o);
                        // o = 3
                    }

                });
    }

    @Test
    public void testFlatMap() {
        Single.just(1).flatMap(new Func1<Integer, Single<String>>() {
            @Override
            public Single<String> call(Integer x) {
                return Single.just(x + "");
            }}).subscribe(new Action1<String>() {// 注意这里返回值的区别
            @Override
            public void call(String s) {
                System.out.println("_flatMap:" + s);
            }});

        Single.just(1).map(new Func1<Integer, Single<String>>() {
            @Override
            public Single<String> call(Integer x) {
                return Single.just(x + "");
            }}).subscribe(new Action1<Single<String>>() {
            @Override
            public void call(Single<String> s) {// 注意这里返回值的区别
                System.out.println("_flatMap:"+s);
            }});
    }

    @Test
    public void testDemo() {
        Single.just(1)
                .map(new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        return integer + "";
                    }
                })
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.immediate())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                        // result
                    }
                });
    }

}
