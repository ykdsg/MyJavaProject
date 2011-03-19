package net.zj.hz.yk.ooa;

import net.zj.hz.yk.ooa.factory.ShapeFactory;

public class Main {

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			final String s = i + "";
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					System.out
							.println("线程" + s + "启动," + ShapeFactory.test1(s));
				}
			});
			thread.start();
		}
	}
}
