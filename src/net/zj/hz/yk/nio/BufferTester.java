package net.zj.hz.yk.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferTester {
	public static void main(String args[]) throws IOException {
		final int BSIZE = 1024;
		// 把test.txt文件中的数据拷贝到out.txt中
		FileChannel in = new FileInputStream("test.txt").getChannel();
		FileChannel out = new FileOutputStream("out.txt").getChannel();

		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		while (in.read(buff) != -1) {
			buff.flip();
			out.write(buff);
			buff.clear();
		}
		in.close();
		out.close();
	}
}
