package net.zj.hz.yk.proxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Main {
	interface A {
		public String hello();
	}

	interface B {
		public String hello();
	}

	public static void main(String[] args) {
		List<A> list = new ArrayList<A>();
		for (int i = 0; i < 3; i++) {
			A p = getA();
			list.add(p);
			System.out.println(p.getClass().getName() + ",$$$$:"
					+ p.getClass().hashCode());
			System.out.println(p.hello());
			System.out.println("-------------");
		}
		System.out.println("######:" + (list.get(0) == list.get(1)));
		for (int i = 0; i < 3; i++) {
			B p = getB();
			System.out.println(p.getClass().getName());
			System.out.println(p.hello());
			System.out.println("-------------");
		}
	}

	private static A getA() {
		A p = (A) Proxy.newProxyInstance(Main.class.getClassLoader(),
				new Class[] { A.class }, new InvocationHandler() {
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						return "hello A";
					}
				});
		return p;
	}

	private static B getB() {
		B p = (B) Proxy.newProxyInstance(Main.class.getClassLoader(),
				new Class[] { B.class }, new InvocationHandler() {
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						return "hello B";
					}
				});
		return p;
	}

}
