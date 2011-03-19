package net.zj.hz.yk.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamTest {

	public static void main(String[] args) throws IOException {

		// FileInputStream in = new FileInputStream("E:\\test.txt");
		/*
		 * int data; while ((data = in.read()) != -1) { System.out.println(data
		 * + " "); }
		 * 
		 * in.close();
		 */
		InputStream in = FileInputStreamTest.class
				.getResourceAsStream("test.txt");
		// FileInputStream in = new FileInputStream("E:\\test.txt");
		FileOutputStream out = new FileOutputStream("E:\\test1.txt");
		byte[] buff = new byte[1024];
		int len = in.read(buff);
		while (len != -1) {
			out.write(buff, 0, len);
			len = in.read(buff);
		}
		in.close();
		out.close();
	}
}
