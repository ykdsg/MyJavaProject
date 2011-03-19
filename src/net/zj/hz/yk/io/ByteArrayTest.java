package net.zj.hz.yk.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArrayTest {

	public static void main(String[] args) throws IOException {
		// byte maskHigh = (byte) 0xf0;
		// System.out.println("###:" + maskHigh);
//		String str1 = "3jf34";
//
//		String str2 =new String("3" + "jf" + "3" + "4");
//
//		if (str1 == str2) {
//
//			System.out.println("str1 == str2");
//
//		}

		 byte[] buff = new byte[] { 2, 15, 67, -1, -9, 9 };
		 ByteArrayInputStream in = new ByteArrayInputStream(buff, 1, 4);
		 int data = in.read();
		 while (data != -1) {
		 System.out.println(data + " ");
		 data = in.read();
		 }
		 in.close();

	}
}
