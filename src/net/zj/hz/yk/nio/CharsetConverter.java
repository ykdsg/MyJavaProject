package net.zj.hz.yk.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * ByteBuffer的 asCharBuffer 会吧ByteBuffer内的数据转换成Unicode字符
 * 如果ByteBuffer中存放的不是Unicode字符编码的字节，那么转换的CharBuffer就包含乱码
 * 这时可以利用Charset类来进行Unicode字符编码与其他类型字符编码进行转换
 * @author "yangk"
 * @date 2010-7-17 下午02:26:12 
 *
 */
public class CharsetConverter {
	public static void main(String args[]) throws IOException {
		// 代码1
		ByteBuffer bb = ByteBuffer.wrap("你好".getBytes("UTF-8"));
		
		CharBuffer cb = bb.asCharBuffer();
		System.out.println(cb); // 打印??

		// 代码2
		bb = ByteBuffer.wrap("你好".getBytes("UTF-16BE"));//或Unicode
		cb = bb.asCharBuffer();
		System.out.println(cb); // 打印“你好”

		// 代码3
		bb = ByteBuffer.wrap("你好".getBytes("UTF-8"));
		Charset cs = Charset.forName("UTF-8");
		cb = cs.decode(bb);
		System.out.println(cb); // 打印“你好”

		// 代码4
		cs = Charset.forName("GBK");
		bb = cs.encode("你好");
		cb = cs.decode(bb);
		for (int i = 0; i < cb.limit(); i++)
			// 打印“你好”
			System.out.print(cb.get());
	}
}
