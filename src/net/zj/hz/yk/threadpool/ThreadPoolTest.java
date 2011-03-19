package net.zj.hz.yk.threadpool;

public class ThreadPoolTest {

	// 线程数
	private static final int THREAD_NUM = 16;

	// 任务数
	private static final int TASK_NUM = 15;

	// 费时的操作的时间度
	public static final int TAKETIME_NUM = 5500;

	public static void main(String[] args) throws InterruptedException {
		long beginTime = System.currentTimeMillis();
		// 创建一个有THREAD_NUM个工作线程的线程池
		ThreadPool threadPool = new ThreadPool(THREAD_NUM);
		// 休眠500毫秒,以便让线程池中的工作线程全部运行
		Thread.sleep(500);
		// 运行任务
		for (int i = 0; i <= TASK_NUM; i++) { // 创建TASK_NUM个任务
			threadPool.execute(createTask(i));
		}
		threadPool.waitFinish(); // 等待所有任务执行完毕
		threadPool.closePool(); // 关闭线程池
		long endTime = System.currentTimeMillis();
		System.out.print("****当前线程数：" + THREAD_NUM + ",******共用时间:"
				+ (endTime - beginTime));

	}

	private static Runnable createTask(final int taskID) {
		return new Runnable() {
			public void run() {
				// System.out.println("Task" + taskID + "开始");
				System.out.println("Hello world");
				// System.out.println("Task" + taskID + "结束");
			}
		};
	}

}
