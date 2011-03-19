package net.zj.hz.yk.classload;

/**
 * 主要展示对象在初始化时 对各种代码的执行顺序
 * 
 * @author "yangk"
 * @date 2010-5-17 下午01:37:08
 * 
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("$$$$$:"+LoadEmUp.s);
		System.out.println(" ----------华丽丽的分割线--------");
		new LoadEmUp();
		System.out.println(" ----------华丽丽的分割线--------");
		Parent referee = new Parent();
		System.out.println(" ----------华丽丽的分割线--------");
		new LoadEmUp();
	}
}
