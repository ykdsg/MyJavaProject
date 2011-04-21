package net.zj.hz.yk.listener;

public class Listener3 implements DemoListener {
	public void demoEvent(DemoEvent de) {
		if (de.getState() != null && de.getState().equals("open")) {
			System.out.println("灯打开了");
		} else {
			System.out.println("灯关好了");
		}
	}
}