package net.zj.hz.yk.classload;

public class Parent {
	public static String s="parent test";
	static {
		System.out.println("运行parent的静态代码段1");
	}
	
	public Parent(){
		System.out.println("运行Parent的默认构造函数!");
	}
	
	public Parent(Object owner){
		System.out.println("运行Parent的带参构造函数!");
	}
}
