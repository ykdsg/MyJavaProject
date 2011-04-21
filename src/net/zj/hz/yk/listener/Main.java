package net.zj.hz.yk.listener;

public class Main {

	public static void main(String args[]) {
		DemoSource ds = new DemoSource();
		Listener1 l1 = new Listener1();
		Listener2 l2 = new Listener2();
		Listener3 l3 = new Listener3();

		ds.addDemoListener(l1);// 给钥匙增加监听器
		ds.addDemoListener(l2);// 给门增加监听器
		ds.addDemoListener(l3);// 给灯增加监听器

		ds.fireWorkspaceOpened();
		System.out.println("我进来干坏事了");
		ds.fireWorkspaceClosed();
	}
}
