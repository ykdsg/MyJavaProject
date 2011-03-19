package net.zj.hz.yk.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;

public class SequenceTester {
	public static void main(String[] args) throws IOException {
		InputStream s1 = new ByteArrayInputStream("你".getBytes());
		InputStream s2 = new ByteArrayInputStream("好".getBytes());
		InputStream in = new SequenceInputStream(s1, s2);
		int data;
		//打出来的字符，和文件的编码有关系，跟java文件的编码有关系，如果是GBK的是196 227 186 195
		//如果是UTF-8，打印出来是228 189 160 229 165 189 
		while ((data = in.read()) != -1) {
			System.out.println(data + " ");

		}
		in.close();
	}
}
