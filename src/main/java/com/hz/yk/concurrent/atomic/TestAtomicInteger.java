package com.hz.yk.concurrent.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wuzheng.yk
 *         Date: 13-1-16
 *         Time: 上午10:42
 */
public class TestAtomicInteger {
    final AtomicInteger ai;
    public TestAtomicInteger(int total){
        ai=new AtomicInteger(total);
    }

    public static void main(String[] agrs) throws InterruptedException{
        final TestAtomicInteger ti=new TestAtomicInteger(100000);
        //搞10个线程去更新
        ExecutorService es= Executors.newFixedThreadPool(10);
        List<Callable<String>> tasks=new ArrayList<Callable<String>>();
        for(int i=0;i<10;i++){
            tasks.add(new Callable<String>() {
                public String call() throws Exception{
                    ti.incerment();
                    return "";
                }
            });
        }

        es.invokeAll(tasks);
        es.shutdown();
    }

    String incerment(){
        int aii=ai.get();
        Thread.yield();
        if(ai.compareAndSet(aii, aii+1)){
            System.out.println(Thread.currentThread().getName()+"execute successful! "+aii);
        }else{
            System.out.println(Thread.currentThread().getName()+" execute  failed!");
        }

        return "";
    }


}
