package net.zj.hz.yk.thread.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Condition替代wait与notify
 * 
 * @author "yangk"
 * @date 2011-1-26 下午02:13:49
 * 
 */
public class ConditionTester {
	public static void main(String[] args) throws InterruptedException {
		final Basket basket = new Basket();

		// 定义一个producer
		Runnable producer = new Runnable() {
			public void run() {
				try {
					basket.produce();
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		};

		// 定义一个consumer
		Runnable consumer = new Runnable() {
			public void run() {
				try {
					basket.consume();
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		};

		// 各产生10个consumer和producer
		ExecutorService service = Executors.newCachedThreadPool();

		for (int i = 0; i < 10; i++)
			service.submit(consumer);

		Thread.sleep(2000);

		for (int i = 0; i < 10; i++)
			service.submit(producer);

		service.shutdown();
	}
}
