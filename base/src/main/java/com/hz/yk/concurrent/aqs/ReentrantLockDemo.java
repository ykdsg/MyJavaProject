package com.hz.yk.concurrent.aqs;

import org.junit.jupiter.api.Test;

/**
 * Created by wuzheng.yk on 2017/5/17.
 */
public class ReentrantLockDemo {

    class Consumer {
        private Depot depot;
        public Consumer(Depot depot) {
            this.depot = depot;
        }

        public void consume(int no) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    depot.consume(no);
                }
            }, no + " consume thread").start();
        }
    }

    class Producer {
        private Depot depot;
        public Producer(Depot depot) {
            this.depot = depot;
        }

        public void produce(int no) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    depot.produce(no);
                }
            }, no + " produce thread").start();
        }
    }

    @Test
    public  void test() throws InterruptedException {
        Depot depot = new Depot(500);
        new Producer(depot).produce(500);
        new Producer(depot).produce(200);
        new Consumer(depot).consume(500);
        new Consumer(depot).consume(200);
    }

}
