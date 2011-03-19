package net.zj.hz.yk.nio;

import java.io.IOException;
import java.nio.ByteBuffer;

public class UseView {
	public static void main(String args[])throws IOException{
	    ByteBuffer bb=ByteBuffer.allocate(1024);

	    bb.asCharBuffer().put("好");
	    System.out.println(bb.getChar());  //打印“好”

	    bb.rewind();
	    bb.asIntBuffer().put(123);
	    System.out.println(bb.getInt());  //打印123

	    bb.rewind();
	    bb.asFloatBuffer().put(123.45F);
	    System.out.println(bb.getFloat());  //打印123.45
	  }
}
