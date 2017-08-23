package com.hz.yk.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  在子线程中做耗时的操作, 然后回到主线程中来操作UI
 * http://www.jianshu.com/p/8818b98c44e2
 * Created by wuzheng.yk on 2017/8/10.
 */
public class RxDemo2 {

    private static final Logger log = LoggerFactory.getLogger(RxDemo2.class);

    public static void main(String[] args) throws InterruptedException {
//创建一个上游 Observable：
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {

            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                System.out.println("Observable thread is : " + Thread.currentThread().getName());
                emitter.onNext(1);
            }
        });
        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("Observer thread is :" + Thread.currentThread().getName());
                System.out.println("onNext: " + integer);
            }
        };
        //建立连接
        observable.subscribeOn(Schedulers.newThread()).observeOn(Schedulers.newThread()).subscribe(consumer);

        Thread.sleep(3000L);
    }

}
