package net.zj.hz.yk.io;

import java.io.IOException;
import java.io.StringBufferInputStream;

public class StringBufferInputStreamTester {

	public static void main(String[] args) throws IOException {
		//只能使用字符编码的低8位，不能将中文正确转为字节，因此已废弃，代之用StrignReader
		StringBufferInputStream in = new StringBufferInputStream("abcd1 好");
		int data;
		while ((data = in.read()) != -1) {
			System.out.println(data + "");
		}
		in.close();
	}
}
