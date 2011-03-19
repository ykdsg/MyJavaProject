package net.zj.hz.yk.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * GC回收referent后(phantom是在回收前，finalize后)，将reference
 * enqueue到RQ中，程序通过调用RQ的remove方法来感知reference被GC回收的事件。
 * remove方法是阻塞的，当没有referent被回收时
 * （GC未调用enqueue），remove方法会一直挂起线程，当有referent被回收时，该方法返回 referent对应的reference对象。
 * 同样，RQ也提供了一个非阻塞的方法 poll，但这样就做不到实时回调了。
 * 
 * @author "yangk"
 * @date 2011-1-26 下午03:22:46
 * 
 */
public class ReferenceQueueTest {
	public static void main(String[] args) {
		final ReferenceQueue q = new ReferenceQueue();
		String str = new String("AK47");
		WeakReference wr = new WeakReference(str, q);

		Thread t = new Thread() {
			@Override
			public void run() {
				try {
					Reference reference = q.remove();
					System.out.println(reference + " event fired.");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t.setDaemon(true);
		t.start();
		System.out.println("Reference Queue is listening.");

		str = null; // clear strong reference
		System.out.println("Ready to gc");
		System.gc();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("wr.get: " + wr.get());
	}

}
