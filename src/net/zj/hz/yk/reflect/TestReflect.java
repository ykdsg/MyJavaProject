package net.zj.hz.yk.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflect {

	public TestReflect() {

	}

	private String id = "";

	public String getId() {
		System.out.print(id);
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			InvocationTargetException {

		String str = "net.zj.hz.yk.reflect.TestReflect";
		Class c = Class.forName(str);
		Object obj = c.newInstance();

		// ���������������Ե�ֵ
		Method m = c.getMethod("setId", Class.forName("java.lang.String"));
		m.invoke(obj, "hello");

		// ���������ȡ���Ե�ֵ
		m = c.getMethod("getId", new Class[] {});
		m.invoke(obj, new Object[] {});

	}

}
