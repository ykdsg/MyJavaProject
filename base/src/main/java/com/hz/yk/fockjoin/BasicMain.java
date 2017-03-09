package com.hz.yk.fockjoin;

import java.util.concurrent.CompletableFuture;

/**
 * Created by wuzheng.yk on 17/2/23.
 */
public class BasicMain {

    public static CompletableFuture<Integer> compute() {
        final CompletableFuture<Integer> future = new CompletableFuture<>();
        return future;
    }

    public static void main(String[] args) throws Exception {

        Integer a = 2;
        Integer b = 2;
        System.out.println(a == b);

        Integer aa = 222;
        Integer bb = 222;
        System.out.println(aa==bb);

        //final CompletableFuture<Integer> f = compute();
        //class Client extends Thread {

//            CompletableFuture<Integer> f;
//
//            Client(String threadName, CompletableFuture<Integer> f){
//                super(threadName);
//                this.f = f;
//            }
//
//            @Override
//            public void run() {
//                try {
//                    System.out.println(this.getName() + ": " + f.get());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        new Client("Client1", f).start();
//        new Client("Client2", f).start();
//        System.out.println("waiting");
//        f.complete(100);
        // f.completeExceptionally(new Exception());
        //System.in.read();
    }
}
