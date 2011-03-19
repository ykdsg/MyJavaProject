package net.zj.hz.yk.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import static  net.zj.hz.yk.MyConstants.*;

public class FileChannelTester {

	public static void main(String[] args) throws IOException {
		final int BSIZE = 1024;

		// 向文件中写数据
		FileChannel fc = new FileOutputStream(FILE_PATH).getChannel();
		fc.write(ByteBuffer.wrap("你好,".getBytes()));
		fc.position(fc.size());// 定位到文件末尾
		fc.close();

		// 向文件末尾添加数据
		fc = new RandomAccessFile(FILE_PATH, "rw").getChannel();
		fc.position(fc.size());
		fc.write(ByteBuffer.wrap("朋友！".getBytes()));

		// 读数据
		fc = new FileInputStream(FILE_PATH).getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);// 将容量设为1024个字节
		fc.read(buff);
		// 把极限值设为位置值，再把位置设为0
		buff.flip();
		Charset cs = Charset.defaultCharset();
		// 转换为unicode字符编码
		System.out.println(cs.decode(buff));

		fc.close();
	}
}
