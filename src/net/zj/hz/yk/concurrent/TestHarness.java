package net.zj.hz.yk.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch是一种闭锁，它通过内部一个计数器count来标示状态，当count>0时，所有调用其await方法的线程都需等待，
 * 当通过其countDown方法将count降为0时所有等待的线程将会被唤起。使用实例如下所示：
 * @author "yangk"
 * @date 2011-3-29 下午08:57:14 
 *
 */
public class TestHarness {
	public long timeTasks(int nThreads, final Runnable task)
			throws InterruptedException {
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(nThreads);
		for (int i = 0; i < nThreads; i++) {
			Thread t = new Thread() {
				public void run() {
					try {
						startGate.await();
						try {
							task.run();
						} finally {
							endGate.countDown();
						}
					} catch (InterruptedException ignored) {
					}
				}
			};
			t.start();
		}
		long start = System.nanoTime();
		startGate.countDown();
		endGate.await();
		long end = System.nanoTime();
		return end - start;
	}

	public static void main(String[] args) throws InterruptedException {
		TestHarness test = new TestHarness();
		test.timeTasks(500, new Runnable() {
			@Override
			public void run() {
				System.out.println("-------------start:"
						+ Thread.currentThread());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("++++++++++++++end:"
						+ Thread.currentThread());
			}
		});
	}
}
