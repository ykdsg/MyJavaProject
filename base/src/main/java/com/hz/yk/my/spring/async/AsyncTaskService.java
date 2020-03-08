package com.hz.yk.my.spring.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by wuzheng.yk on 17/4/28.
 */
@Service
public class AsyncTaskService {

    @Async    //声明异步执行的方法
    public void executeAsyncTask1(Integer i) {
        System.out.println("线程ID: " + Thread.currentThread().getId() + " Integer: " + i);
    }
}
