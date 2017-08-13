package com.yk.akka.typedactor;

import akka.dispatch.Futures;
import akka.japi.Option;
import scala.concurrent.Future;

/**
 * Created by wuzheng.yk on 2017/8/1.
 */
public class SquarerImpl implements Squarer {

    private String name;

    public SquarerImpl() {
        this.name = "default";
    }

    public SquarerImpl(String name) {
        this.name = name;
    }

    @Override
    public Future<Integer> square(int i) {
        return Futures.successful(squareNow(i));
    }

    @Override
    public Option<Integer> squareNowPlease(int i) {
        return Option.some(squareNow(i));
    }

    @Override
    public int squareNow(int i) {
        System.out.println("开始sleep....");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行里面");
        return i * i;
    }

}
