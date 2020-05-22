package com.hz.yk.thread.runnable;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author wuzheng.yk
 * @date 2020/4/1
 */
public class BlockThread {

    @Test
    //进入（enter）同步块时阻塞
    public void testBlocked() throws Exception {
        class Counter {

            int counter;

            public synchronized void increase() {
                counter++;
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        Counter c = new Counter();

        Thread t1 = new Thread(new Runnable() {

            public void run() {
                c.increase();
            }
        }, "t1线程");
        t1.start();

        Thread t2 = new Thread(new Runnable() {

            public void run() {
                c.increase();
            }
        }, "t2线程");
        t2.start();

        Thread.sleep(100); // 确保 t2 run已经得到执行
        assertThat(t2.getState()).isEqualTo(Thread.State.BLOCKED);
    }

    @Test
    //wait 之后重进入（reenter）同步块时阻塞
    public void testReenterBlocked() throws Exception {
        class Account {

            int amount = 100; // 账户初始100元

            public synchronized void deposit(int cash) { // 存钱
                amount += cash;
                notify();
                try {
                    Thread.sleep(30000); // 通知后却暂时不退出
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            public synchronized void withdraw(int cash) { // 取钱
                while (cash > amount) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                amount -= cash;
            }
        }
        Account account = new Account();

        Thread withdrawThread = new Thread(new Runnable() {

            @Override
            public void run() {
                account.withdraw(200);
            }
        }, "取钱线程");
        withdrawThread.start();

        Thread.sleep(100); // 确保取钱线程已经得到执行
        //取钱线程先启动，并进入（enter）同步块，试图取200元，发现钱不够，调用 wait，锁释放，线程挂起（WAITING 状态）。
        assertThat(withdrawThread.getState()).isEqualTo(Thread.State.WAITING);

        Thread depositThread = new Thread(new Runnable() {

            @Override
            public void run() {
                account.deposit(100);
            }
        }, "存钱线程");
        Thread.sleep(1000); // 让取钱线程等待一段时间
        depositThread.start();
        Thread.sleep(300); // 确保取钱线程已经被存钱线程所通知到
        //存钱线程启动，存入钱并通知（notify）取钱线程，但之后继续在同步块中睡眠，导致锁没有释放。
        // 取钱线程收到通知后，退出 WAITING 状态，但已经不持有锁，当试图重新进入（reenter）同步块以恢复执行时，因锁尚未被存钱线程释放，于是被阻塞（BLOCKED 状态）。
        assertThat(withdrawThread.getState()).isEqualTo(Thread.State.BLOCKED);
    }
}
