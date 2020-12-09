package com.hz.yk.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Case: Old Gen have too many objects,then OOM,show GC Overhead time limit and Java Heap Space
 * startup args: -Xms20m -Xmx20m -Xmn10m -XX:+HeapDumpOnOutOfMemoryError -XX:+UseParallelGC
 * <br/>
 * 在new对象或数组时Java Heap Space不足造成的，对于这种OOM，需要知道的是程序中哪些部分占用了Java Heap。
 */
public class JavaHeapSpaceCase1 {

	public static void main(String[] args) throws Exception {
		//cache 里面放入了大量的对象
		Caches.getInstance().init();
		new Thread(new Runnable() {

			@Override
			public void run() {
				List<byte[]> listbytes = new ArrayList<byte[]>();
				for (int i = 0; i < 4028; i++) {
					System.out.println("thread a: " + i);
					listbytes.add(new byte[1024]);
				}
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				List<byte[]> tests = new ArrayList<byte[]>();
				for (int i = 0; i < 10000; i++) {
					System.out.println("thread b: " + i);
					tests.add(new byte[1024 * 256]);
					try {
						Thread.sleep(200);
						if (i % 2 == 0) {
							tests.remove(0);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

}
