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
        //subscribeOn() 指定的是上游发送事件的线程, observeOn() 指定的是下游接收事件的线程.
        //多次指定上游的线程只有第一次指定的有效, 也就是说多次调用subscribeOn() 只有第一次的有效, 其余的会被忽略.
        //多次指定下游的线程是可以的, 也就是说每调用一次observeOn() , 下游的线程就会切换一次.
        observable.subscribeOn(Schedulers.newThread()).observeOn(Schedulers.newThread()).subscribe(consumer);

        Thread.sleep(3000L);
    }

}
