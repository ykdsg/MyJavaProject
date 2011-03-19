package net.zj.hz.yk.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UseBuffer {
	public void Print() {
		String a = this.getClass().getClassLoader().getResource(".").getPath();
		String b = this.getClass().getResource("").getPath();
		String c = this.getClass().getResource(" ").getPath();
		String d = this.getClass().getResource("/").getPath();
		String e = System.getProperty("user.dir");
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println("*********************");
		System.out.println(e);
		System.out.println("*********************");

	}
	
	public String takeClassPath(){
		return this.getClass().getResource("").getPath();
	}

	public static void main(String[] args) throws IOException {
		
		UseBuffer test = new UseBuffer();
//		test.Print();
		FileInputStream in = new FileInputStream(test.takeClassPath()+"test.txt");
		byte[] buff = new byte[1024];
		int len = in.read(buff);
		while (len != -1) {
			System.out.println(buff);
			len = in.read(buff);
		}
		in.close();
//		File directory = new File(".");
		// System.out.println(directory.getCanonicalPath());
		// System.out.println(directory.getAbsolutePath());
		/*final int SIZE = 1024;
		FileInputStream in = new FileInputStream("test.txt");
		// InputStream in = UseBuffer.class
		// .getResourceAsStream("test.txt");
		FileOutputStream out = new FileOutputStream("out.txt");
		byte[] buff = new byte[SIZE];

		int len = in.read(buff);
		while (len != -1) {
			out.write(buff, 0, len);
			len = in.read(buff);
		}
		in.close();
		out.close();*/

	}
}
