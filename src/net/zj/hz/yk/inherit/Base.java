package net.zj.hz.yk.inherit;

public class Base {

	public String s="base";
	
	public static void staticMethod() {

	}

	public void method1() {

	}

	public String showMe() {
		return "base";
	}

	public void print() {
		System.out.println(showMe());
	}

	public static void main(String[] args) {
		Base b = new Base();
	}
}
