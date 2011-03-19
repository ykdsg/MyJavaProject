package net.zj.hz.yk.nio;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;

public class LockTester {
	public static void main(String args[]) throws Exception {
		FileOutputStream fos = new FileOutputStream("test.txt");
		FileLock fl = fos.getChannel().tryLock();
		if (fl != null) {
			System.out.println("Locked File");
			System.out.println(fl.isShared());
			Thread.sleep(60000); // 锁定文件60秒
			fl.release();
			System.out.println("Released Lock");
		}
	}
}
