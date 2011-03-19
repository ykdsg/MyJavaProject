package net.zj.hz.yk.extend;

class Base {
	String var = "base";
	static String staticVar = "static base var";

	void method() {
		System.out.println("base method");
	}

	static void staticMethod() {
		System.out.println("static base method");
	}
}

class Sub extends Base {
	String var = "sub";
	static String staticVar = "static Sub var";

	void method() {
		System.out.println("Sub method:staticVar="+staticVar+","+var);
	}

	static void staticMethod() {
		System.out.println("static Sub method");
	}

}

public class Polymorphism {

	public static void main(String[] args) {
		Base who = new Sub();
		System.out.println("who.var=" + who.var);

		System.out.println("staticvar=" + who.staticVar);
		who.method();
		who.staticMethod();
	}

}
