package com.hz.yk.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import org.junit.jupiter.api.Test;

import static java.lang.System.out;

/**
 * http://www.jianshu.com/p/bb58571cdb64
 * zip的使用：比如一个界面需要展示用户的一些信息, 而这些信息分别要从两个服务器接口中获取, 而只有当两个都获取到了之后才能进行展示, 这个时候就可以用Zip了
 * Created by wuzheng.yk on 2017/8/22.
 */
public class RxZipDemo {

    @Test
    public void testZip() {
        Observable<Integer> observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {

            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                out.println("emit 1");
                emitter.onNext(1);
                out.println("emit 2");
                emitter.onNext(2);
                out.println("emit 3");
                emitter.onNext(3);
                out.println("emit 4");
                emitter.onNext(4);
                out.println("emit complete1");
                emitter.onComplete();
            }
        });

        Observable<String> observable2 = Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                out.println("emit A");
                emitter.onNext("A");
                out.println("emit B");
                emitter.onNext("B");
                out.println("emit C");
                emitter.onNext("C");
                out.println("emit complete2");
                emitter.onComplete();
            }
        });

        Observable.zip(observable1, observable2, new BiFunction<Integer, String, String>() {

            @Override
            public String apply(Integer integer, String s) throws Exception {
                return integer + s;
            }
        }).subscribe(new Observer<String>() {

            @Override
            public void onSubscribe(Disposable d) {
                out.println("onSubscribe");
            }

            @Override
            public void onNext(String value) {
                out.println("onNext: " + value);
            }

            @Override
            public void onError(Throwable e) {
                out.println("onError");
            }

            @Override
            public void onComplete() {
                out.println("onComplete");
            }
        });

    }

}
