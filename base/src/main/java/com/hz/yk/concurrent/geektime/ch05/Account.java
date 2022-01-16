package com.hz.yk.concurrent.geektime.ch05;

/**
 * @author wuzheng.yk
 * @date 2022/1/15
 */
public class Account {

    //这里需要保证为单例，不然就没起到效果
    private static Allocator allocator = new Allocator();

    private int balance;

    public void transfer(Account target, int amt) {
        while (!allocator.apply(this, target)) {
            //    实际项目中需要设置一个超时，避免一直等待下去，超时到了返回异常或者错误
        }
        try {
            // It's need lock this and target ,because there are other situation that change the balance ,eg. withdrawal from other. 
            synchronized (this) {
                synchronized (target) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        } finally {
            allocator.free(this, target);
        }
    }
}
