package net.zj.hz.yk.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 操作系统的信号量是个很重要的概念，在进程控制方面都有应用。Java并发库的Semaphore可以很轻松完成信号量控制，
 * Semaphore可以控制某个资源可被同时访问的个数
 * ，acquire()获取一个许可，如果没有就等待，而release()释放一个许可。比如在Windows下可以设置共享文件的最大客户端访问个数。
 * 
 * Semaphore维护了当前访问的个数，提供同步机制，控制同时访问的个数。在数据结构中链表可以保存“无限”的节点，
 * 用Semaphore可以实现有限大小的链表。另外重入锁ReentrantLock也可以实现该功能，但实现上要负责些，代码也要复杂些。
 * 
 * @author "yangk"
 * @date 2011-1-28 下午05:28:49
 * 
 */
public class TestSemaphore {
	public static void main(String[] args) {
		// 线程池
		ExecutorService exec = Executors.newCachedThreadPool();
		// 只能5个线程同时访问
		final Semaphore semp = new Semaphore(5);
		// 模拟20个客户端访问
		for (int index = 0; index < 20; index++) {
			final int NO = index;
			Runnable run = new Runnable() {
				public void run() {
					try {
						// 获取许可
						semp.acquire();
						System.out.println("Accessing: " + NO);
						Thread.sleep((long) (Math.random() * 10000));
						// 访问完后，释放
						semp.release();
					} catch (InterruptedException e) {
					}
				}
			};
			exec.execute(run);
		}
		// 退出线程池
		exec.shutdown();
	}
}
