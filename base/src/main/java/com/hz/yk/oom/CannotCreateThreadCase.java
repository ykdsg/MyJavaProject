package com.hz.yk.oom;

/**
 * Case: Cannot create native Thread 
 * 
 * startup args: -Xms1536m -Xmx1536m -Xss100m
 */
public class CannotCreateThreadCase {

	public static void main(String[] args) throws Exception{
		for (int i = 0; i < 20; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(20000);
					} 
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}

}
