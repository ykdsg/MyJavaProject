package net.zj.hz.yk;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class JustMyTestMain {

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			SecurityException, InvocationTargetException,
			ClassNotFoundException {
		JustMyTestMain t = new JustMyTestMain();
		Animal a = t.new Animal();
		Dog d = t.new Dog();
		Cat c = t.new Cat();
		a = d;
		// 实际上a应用的是dog对象，并不能把dog对象转换成cat对象
		// c=(Cat) a;//编译可以通过，但运行出错
		a.call();
		
		//对于公开非静态内部类的默认构造函数需要一个外围类的实例
		//getConstructors()返回一个包含某些 Constructor 对象的数组，
		//这些对象反映此 Class 对象所表示的类的所有公共构造方法。
		Animal a1 = (Animal) d.getClass().getSuperclass().getConstructors()[0]
				.newInstance(t);
		a1.call();

		// 对于非公开内部类需要调用getDeclaredConstructors
		//该方法返回 Constructor 对象的一个数组，这些对象反映此 Class 对象表示的类声明的所有构造方法。
		//不只是公共的构造方法
		Class cla = Class.forName("net.zj.hz.yk.JustMyTestMain$Dog");
		Dog d1 = (Dog) cla.getDeclaredConstructors()[0].newInstance(t);
		d1.call();

		cla = Class.forName("net.zj.hz.yk.JustMyTestMain$Cat");
		Constructor con = cla.getDeclaredConstructors()[0];
		// 对于私有内部类，需要将构造函数设置成可访问，如果这行注释去掉，将会异常
		con.setAccessible(true);
		Cat c1 = (Cat) con.newInstance(t);
		c1.call();

		//如果是 static内部类，则默认构造函数是一个无参的构造函数
		cla = Class.forName("net.zj.hz.yk.JustMyTestMain$Inner");
		Inner in = (Inner) cla.getConstructors()[0].newInstance();
		in.call();

		cla = Class.forName("net.zj.hz.yk.JustMyTestMain$Inner2");
		Inner2 in2 = (Inner2) cla.getDeclaredConstructors()[0].newInstance();
		in2.call();
	}

	public class Animal {
		public void call() {
			System.out.println("Animal");
		}
	}

	class Dog extends Animal {
		String var="sub";
		public void call() {
			System.out.println("Dog");
		}
	}

	private class Cat extends Animal {
		public void call() {
			System.out.println("Cat");
		}
	}

	public static class Inner {
		public void call() {
			System.out.println("Inner");
		}
	}

	static class Inner2 {
		public void call() {
			System.out.println("Inner2");
		}
	}
}
