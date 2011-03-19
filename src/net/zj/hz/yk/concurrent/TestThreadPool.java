package net.zj.hz.yk.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用了2个大小的线程池来处理100个线程 即使线程池大小小于实际线程数大小，线程池也不会阻塞的
 * 
 * @author "yangk"
 * @date 2011-1-28 上午11:14:32
 * 
 */
public class TestThreadPool {
	public static void main(String args[]) throws InterruptedException {
		// only two threads
		ExecutorService exec = Executors.newFixedThreadPool(20);
		for (int index = 0; index < 100; index++) {
			final int i = index;
			Runnable run = new Runnable() {
				public void run() {
					long time = (long) (Math.random() * 1000);
					System.out.println(i + "Sleeping " + time + "ms");
					try {
						Thread.sleep(time);
					} catch (InterruptedException e) {
					}
				}
			};
			exec.execute(run);
		}
		System.out.println("----------------for exit");
		// must shutdown
		exec.shutdown();
	}
}
