package net.zj.hz.yk.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class ViewTester {
	public static void main(String args[])throws IOException{
	    ByteBuffer bb=ByteBuffer.allocate(5);
	    while(bb.hasRemaining()) { //打印4个0
	       System.out.println(bb.get());
	       }
	    bb.rewind();

	    CharBuffer cb=bb.asCharBuffer();  //获得ByteBuffer的CharBuffer视图
	    cb.put("你好");
	    while(bb.hasRemaining()) { //依次打印79,96,89,125
	       System.out.println(bb.get());
	       }
	  }
}
