package net.zj.hz.yk.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import static net.zj.hz.yk.MyConstants.*;

public class BigFileTester {

	public static void main(String[] args) throws IOException {
		int capacity = 0x8000000;// 128MB

		MappedByteBuffer mb = new RandomAccessFile(FILE_PATH, "rw").getChannel()
				.map(FileChannel.MapMode.READ_WRITE, 0, capacity);
		
		mb.put("你好啊".getBytes("GBK"));//向文件中写入采用GBK编码的字符串
		mb.flip();
		System.out.println(Charset.forName("GBK").decode(mb));
		
	
	}
}
