package net.zj.hz.yk.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class ClassUtils2 {
	/**
	 * 获取对象的属性值
	 * 
	 * @param object
	 *            对象实例
	 * @param property
	 *            属性名
	 * @return 属性的值
	 */
	public static Object getObjectProperty(Object object, String property)
			throws NoSuchMethodException, SecurityException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, NoSuchFieldException {
		if (object == null)
			return null;
		try {
			return getClassGetter(object.getClass(), property).invoke(object,
					new Object[0]);
		} catch (NoSuchMethodException e) {
			return object.getClass().getField(property).get(object);
		}
	}

	/**
	 * 查找getXXX与isXXX的属性Getter方法
	 * 
	 * @param clazz
	 *            类元
	 * @param property
	 *            属性名
	 * @return 属性Getter方法
	 */
	public static Method getClassGetter(Class clazz, String property)
			throws NoSuchMethodException, SecurityException {
		property = property.trim();
		String upper = property.substring(0, 1).toUpperCase()
				+ property.substring(1);
		try {
			Method getter = getClassMethod(clazz, "get" + upper);
			return getter;
		} catch (NoSuchMethodException e1) {
			try {
				Method getter = getClassMethod(clazz, "is" + upper);
				return getter;
			} catch (NoSuchMethodException e2) {
				Method getter = getClassMethod(clazz, property);
				return getter;
			}
		}
	}

	/**
	 * 获取类的方法 (保证返回方法的公开性)
	 * 
	 * @param clazz
	 *            类
	 * @param methodName
	 *            方法名
	 * @return 公开的方法
	 */
	public static Method getClassMethod(Class clazz, String methodName)
			throws NoSuchMethodException, SecurityException {
		try {
			//搜索接口里的方法
			return searchPublicMethod(clazz.getInterfaces(), methodName);
		} catch (NoSuchMethodException e1) {
			try {
				//搜索父类和接口
				return searchPublicMethod(clazz.getClasses(), methodName);
			} catch (NoSuchMethodException e2) {
				//最后搜索自己
				return clazz.getMethod(methodName, new Class[0]);
			}
		}
	}

	// 查找公开的方法 (辅助方法)
	private static Method searchPublicMethod(Class[] classes, String methodName)
			throws NoSuchMethodException, SecurityException {
		if (classes != null && classes.length > 0) {
			for (int i = 0, n = classes.length; i < n; i++) {
				Class cls = classes[i];
				if ((cls.getModifiers() & Modifier.PUBLIC) == 1) { // 首先保证类是公开的
					try {
						Method method = cls.getMethod(methodName, new Class[0]);
						if ((method.getModifiers() & Modifier.PUBLIC) == 1) // 再保证方法是公开的
							return method;
					} catch (NoSuchMethodException e) {
						// ignore, continue
					}
				}
			}
		}
		throw new NoSuchMethodException(); // 未找到方法
	}

	public static void main(String[] args) throws SecurityException,
			IllegalArgumentException, NoSuchMethodException,
			IllegalAccessException, InvocationTargetException,
			NoSuchFieldException {
		Map map = new HashMap();
		map.put("aa", "bb");
		Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
		Object key = ClassUtils2.getObjectProperty(entry, "key");
		System.out.println("###:"+key);
	}

}
