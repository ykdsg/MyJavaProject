package net.zj.hz.yk.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class FileChannelTester {
	public static void main(String args[]) throws IOException {
		final int BSIZE = 1024;

		// 向文件中写数据
		FileChannel fc = new FileOutputStream("test.txt").getChannel();
		fc.write(ByteBuffer.wrap("你好,".getBytes()));
		fc.close();

		// 向文件末尾添加数据
		fc = new RandomAccessFile("test.txt", "rw").getChannel();
		fc.position(fc.size()); // 定位到文件末尾
		fc.write(ByteBuffer.wrap("朋友!".getBytes()));
		fc.close();

		// 读数据
		fc = new FileInputStream("test.txt").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		fc.read(buff); // 把文件中的数据读入到ByteBuffer中
		buff.flip();//将极限设为位置值，再把位置设为0
		Charset cs = Charset.defaultCharset(); // 获得本地平台的字符编码
		System.out.println(cs.decode(buff)); // 转换为Unicode编码

		fc.close();
	}
}
