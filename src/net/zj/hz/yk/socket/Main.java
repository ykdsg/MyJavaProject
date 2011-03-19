package net.zj.hz.yk.socket;

/**
 * 演示序列化和sockeet通信
 * @author "yangk"
 * @date 2010-5-14 下午09:20:07 
 *
 */
public class Main {
	public static void main(String[] args) {
		new MyServer().start();
		new MyClient().start();
	}
}
