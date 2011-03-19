package net.zj.hz.yk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SecurityProxyInvocationHandler implements InvocationHandler {
	private Object proxyedObject;

	public SecurityProxyInvocationHandler(Object o) {
		proxyedObject = o;
	}

	public Object invoke(Object object, Method method, Object[] arguments)
			throws Throwable {
		if (object instanceof Account && method.getName().equals("operation")) {
			SecurityChecker.checkSecurity();
		}
		return method.invoke(proxyedObject, arguments);
	}

	
}
