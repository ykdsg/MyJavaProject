package net.zj.hz.yk.inherit;

/**
 * 父类与子类的关系
 * 1.实例方法是由 引用的对象的方法绑定（动态绑定）
 * 2.静态方法由声明的类绑定（静态绑定）
 * 3.成员变量（实例变量，静态变量） 由声明的类绑定（静态绑定）
 * 
 * @author "yangk"
 * @date 2010-7-30 下午09:49:57 
 *
 */
public class Sub extends Base {

	public String s = "sub";

	public Sub() {
	}

	public static void staticMethod() {

	}

	public void method1() {
	}

	public String showMe() {
		return "sub";
	}

	public static void main(String[] args) {
		Base sub = new Sub();
		//成员变量（实例变量，静态变量） 由声明的类绑定（静态绑定）
		System.out.println("###:" + sub.s);
	}
}
