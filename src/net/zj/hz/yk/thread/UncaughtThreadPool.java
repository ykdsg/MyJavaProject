package net.zj.hz.yk.thread;

import net.zj.hz.yk.serial.User;
import net.zj.hz.yk.thread.lock.Basket;

class MachineGroup extends ThreadGroup {

	public MachineGroup() {
		super("MachineGroup");
		// TODO Auto-generated constructor stub
	}

	public void uncaughtException(Thread t, Throwable e) {
		System.out.println(getName() + " cathces an exception from "
				+ t.getName());
		super.uncaughtException(t, e);
	}

}

class MachineHandler implements Thread.UncaughtExceptionHandler {
	private String name;

	public MachineHandler(String name) {
		this.name = name;
	}

	public void uncaughtException(Thread t, Throwable e) {
		System.out.println(name + " cathces an exception from " + t.getName());
	}
}

public class UncaughtThreadPool extends Thread {
	public UncaughtThreadPool(ThreadGroup group, String name) {
		super(group, name);
	}

	public UncaughtThreadPool() {
		super();
	}

	public void run() {
		int a = 1 / 0;
	}

	public static void main(String[] args) {
		// UncaughtThreadPool s = new UncaughtThreadPool();

		ThreadGroup group = new MachineGroup();
		UncaughtExceptionHandler defaultHandler = new MachineHandler(
				"DefaultHandler");
		Thread.setDefaultUncaughtExceptionHandler(defaultHandler);
		UncaughtThreadPool m1 = new UncaughtThreadPool(group, "machine1");
		UncaughtThreadPool m2 = new UncaughtThreadPool(group, "machine2");

		UncaughtExceptionHandler currHandler = new MachineHandler("yk\'handler");

		m2.setUncaughtExceptionHandler(currHandler);

		m1.start();
		m2.start();
	}

}
