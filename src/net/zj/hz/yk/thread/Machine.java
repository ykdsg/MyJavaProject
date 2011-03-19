package net.zj.hz.yk.thread;

public class Machine extends Thread {

	private static StringBuffer sb = new StringBuffer();
	private static int count = 0;

	public void run() {
		for (int i = 0; i < 20; i++) {
			sb.append(currentThread().getName() + ":" + i + " ");
			if (++count % 10 == 0) {
				sb.append("\n");
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Machine machine1 = new Machine();
		Machine machine2 = new Machine();
		machine1.setName("m1");
		machine2.setName("m2");
		machine1.start();
		machine2.start();
		while (machine1.isAlive() || machine2.isAlive()) {
			Thread.sleep(500);
		}
		System.out.println(sb);

	}

}
