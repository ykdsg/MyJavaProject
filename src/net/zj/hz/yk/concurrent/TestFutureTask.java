package net.zj.hz.yk.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 有时候在实际应用中，某些操作很耗时，但又不是不可或缺的步骤。比如用网页浏览器浏览新闻时，最重要的是要显示文字内容，至于与新闻相匹配的图片就没有那么重要的，
 * 所以此时首先保证文字信息先显示，而图片信息会后显示，但又不能不显示，由于下载图片是一个耗时的操作，所以必须一开始就得下载。
 * 
 * 
 * Java的并发库的Future类就可以满足这个要求。Future的重要方法包括get()和cancel()，get()获取数据对象，如果数据没有加载，
 * 就会阻塞直到取到数据，而
 * cancel()是取消数据加载。另外一个get(timeout)操作，表示如果在timeout时间内没有取到就失败返回，而不再阻塞。
 * 
 * 下面的Demo简单的说明了Future的使用方法：一个非常耗时的操作必须一开始启动，但又不能一直等待；其他重要的事情又必须做，等完成后，
 * 就可以做不重要的事情。
 * 
 * @author "yangk"
 * @date 2011-1-28 下午05:12:57
 * 
 */
public class TestFutureTask {
	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		final ExecutorService exec = Executors.newFixedThreadPool(5);
		Callable call = new Callable() {
			public String call() throws Exception {
				Thread.sleep(1000 * 5);
				return "Other less important but longtime things.";
			}
		};
		Future task = exec.submit(call);
		// 重要的事情
		Thread.sleep(1000 * 3);
		System.out.println("Let’s do important things.");
		// 其他不重要的事情
		String obj = (String) task.get();
		System.out.println(obj);
		// 关闭线程池
		exec.shutdown();
	}
}
