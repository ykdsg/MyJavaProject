package net.zj.hz.yk.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamTester {
	public static void main(String[] args) throws IOException {
		// ByteArrayOutputStream类向内存中的字节数组写数据
		// 不过这个例子有点无聊，我都直接可以取得字符串的字节数组了
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		out.write("你好".getBytes("UTF-8"));

		// byte[] buff = out.toByteArray();
		byte[] buff = "你好".getBytes("UTF-8");
		out.close();

		ByteArrayInputStream in = new ByteArrayInputStream(buff);
		int len = in.available();
		byte[] buffIn = new byte[len];
		in.read(buffIn);
		in.close();

		System.out.println(new String(buffIn, "UTF-8"));

		out = new ByteArrayOutputStream();
		//write方法只会想输出流写入一个字节，259的二进制形式的最后8位
		//最后结果是3
		out.write(259);
		buff = out.toByteArray();
		out.close();

		System.out.println("buff.length=" + buff.length);
		in = new ByteArrayInputStream(buff);
		int data;
		while ((data = in.read()) != -1) {
			System.out.println(data);
		}

	}
}
