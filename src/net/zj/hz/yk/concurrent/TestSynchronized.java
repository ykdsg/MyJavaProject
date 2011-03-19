package net.zj.hz.yk.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestSynchronized {
	static int i;
	final ReentrantLock lock = new ReentrantLock();

	final Condition con = lock.newCondition();
	final int time = 5;

	public synchronized void add1() {
		System.out.println("进入操作 waiting :" + Thread.currentThread());
		try {
			this.wait(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("wait over..." + Thread.currentThread());
		i++;
		System.out.println("operation is done,i=" + i + " ;"
				+ Thread.currentThread());
	}

	public void add2() {
		System.out.println("Pre " + Thread.currentThread());
		lock.lock();
		System.out.println("count:" + lock.getHoldCount()+";"+Thread.currentThread());
		try {
			con.await(time, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Post " + lock.toString()+";"+Thread.currentThread());
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		final ExecutorService exec = Executors.newFixedThreadPool(4);
		final TestSynchronized t = new TestSynchronized();
		final Runnable add = new Runnable() {
			@Override
			public void run() {
				t.add1();
				t.add2();
			}
		};

		for (int index = 0; index < 4; index++)
			exec.submit(add);

		exec.shutdown();
	}
}
