package com.yk.akka.typedactor;

import akka.japi.Option;
import scala.concurrent.Future;

/**
 * 定义Actor的接口.对于异步的方法,需要返回scala.concurrent.Future对象.阻塞的异步调用,需要返回akka.japi.Option.同步调用直接返回结果对象.
 * Created by wuzheng.yk on 2017/8/1.
 */
public interface Squarer {
    Future<Integer> square(int i); //non-blocking send-request-reply

    Option<Integer> squareNowPlease(int i);//blocking send-request-reply

    int squareNow(int i); //blocking send-request-reply
}
