package net.zj.hz.yk;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Main {
	// Proxy 编程是面向接口的。Proxy 并不负责实例化对象，和 Decorator 模式一样，要把 Account
	// 定义成一个接口，然后在 AccountImpl 里实现 Account 接口，接着实现一个 InvocationHandler Account
	// 方法被调用的时候，
	// 虚拟机都会实际调用这个 InvocationHandler 的 invoke 方法：

	public static void main(String[] args) {
		Account account = (Account) Proxy.newProxyInstance(Account.class
				.getClassLoader(), new Class[] { Account.class },
				new SecurityProxyInvocationHandler(new AccountImpl()));
		account.operation();

		List<Account> set = new ArrayList();
		for (int i = 0; i < 10; i++) {
			Account test = (Account) Proxy.newProxyInstance(Account.class
					.getClassLoader(), new Class[] { Account.class },
					new SecurityProxyInvocationHandler(new AccountImpl()));
			set.add(test);
			System.out.println("$$$$$$$:"
					+ test.getClass().getName().toString() + ",hashcode:"
					+ test.hashCode());
		}
		System.out.println("!!!!!!!!!:" + set.size());
		System.out.println("@@:" + set.get(0).equals(set.get(1)));

	}

}
