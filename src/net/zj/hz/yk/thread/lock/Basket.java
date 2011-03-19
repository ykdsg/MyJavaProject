package net.zj.hz.yk.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Basket {
	Lock lock = new ReentrantLock();

	// 产生Condition对象
	Condition produced = lock.newCondition();
	Condition consumed = lock.newCondition();
	boolean available = false;

	public void produce() throws InterruptedException {
		lock.lock();

		try {
			if (available) {
				produced.await(); // 放弃lock进入睡眠
			}

			System.out.println("Apple produced.");

			available = true;

			consumed.signal(); // 发信号唤醒等待这个Condition的线程
		} finally {
			lock.unlock();
		}
	}

	public void consume() throws InterruptedException {
		lock.lock();

		try {
			if (!available) {
				consumed.await(); // 放弃lock进入睡眠
			}

			/* 吃苹果 */
			System.out.println("Apple consumed.");

			available = false;

			produced.signal(); // 发信号唤醒等待这个Condition的线程
		} finally {
			lock.unlock();
		}
	}
}
