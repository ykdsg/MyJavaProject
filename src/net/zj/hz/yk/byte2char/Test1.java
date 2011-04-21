package net.zj.hz.yk.byte2char;

import java.nio.charset.Charset;

public class Test1 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		char c = 's';
		String s = "你";
		int temp = (int) c;
		byte[] b1 = new byte[2];
		byte[] b2 = s.getBytes(Charset.forName("GBK"));
		char[] c2 = s.toCharArray();
		for (int i = b1.length - 1; i > -1; i--) {
			b1[i] = new Integer(temp & 0xff).byteValue(); // 将最高位保存在最低位
			temp = temp >> 8; // 向右移8位
		}
		System.out.println("$$:" + b1.toString());
		System.out.println("###:" + new String(b1));
		System.out.println("###:" + new String(b2, Charset.forName("GBK")));
		for (int i = 0; i < b2.length; i++) {
			System.out.println("!!!:" + (int) b2[i]);
		}
	}
}
