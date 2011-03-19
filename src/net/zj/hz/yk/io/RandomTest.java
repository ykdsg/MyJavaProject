package net.zj.hz.yk.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomTest {

	public static void main(String[] args) throws IOException {
		RandomAccessFile rf = new RandomAccessFile(
				"F:\\workspace_ganymede\\MyProject\\src\\net\\zj\\hz\\yk\\io\\test.txt",
				"rw");
		for (int i = 0; i < 10; i++) {
			rf.writeLong(i * 1000);
		}

		rf.seek(5 * 8);// 从文件开头开始，跳过5个long数据，接下来写第6个数据
		rf.writeLong(1234);

		rf.seek(0);// 把读指针定位到文件开头
		for (int i = 0; i < 10; i++) {
			System.out.println("Value" + i + ":" + rf.readLong());
		}
		rf.close();
	}
}
