package com.hz.yk.concurrent.geektime.ch24;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;

import static com.hz.yk.thread.state.StopThread.sleep;

/**
 * @author wuzheng.yk
 * @date 2022/4/19
 */
public class CompletableFutureDemo {

    @Test
    public void demo1(){
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
            System.out.println("T1:洗水壶。。。");
            sleep(1000);

            System.out.println("T1：烧开水。。。");
            sleep(1500);
            
        });

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("T2：洗茶壶。。。");
            sleep(1000);

            System.out.println("T2：洗茶杯。。。");
            sleep(2000);

            System.out.println("T2：拿茶叶。。。");
            sleep(1000);

            return "龙井";
        });

        CompletableFuture<String> f3 = f1.thenCombine(f2, (__, tf) -> {
            System.out.println("T1：拿到茶叶：" + tf);
            System.out.println("T1：泡茶。。。");
            return " 上茶：" + tf;
        });

        System.out.println(f3.join());
        
        
    }
    
    @Test
    public void testSerial() {
        //通过supplyAsync 开启异步线程，接着是2个串行操作。
        final CompletableFuture<String> f0 = CompletableFuture.supplyAsync(() -> "hello world")
                .thenApply(s -> s + " QQ").thenApply(String::toUpperCase);

        System.out.println(f0.join());
    }
    
    @Test
    public void testException() {
        final CompletableFuture<Integer> f0 = CompletableFuture.supplyAsync(() -> (7 / 0))
                .thenApply(r -> (r * 10)).exceptionally(e -> 0);
        System.out.println(f0.join());
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
