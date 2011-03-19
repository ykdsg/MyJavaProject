package net.zj.hz.yk.io;

import java.io.IOException;
import java.io.StringBufferInputStream;

public class StringBufferInputerStreamTest {
	public static void main(String[] args) throws IOException {
		//仅仅使用了字符编码的低8位，不能对中文进行转换
		StringBufferInputStream in = new StringBufferInputStream("abc  好");
		int data;
		while ((data = in.read()) != -1) {
			System.out.println(data + " ");
		}
		in.close();
	}

}
