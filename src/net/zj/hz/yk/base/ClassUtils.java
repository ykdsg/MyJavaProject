package net.zj.hz.yk.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 其中: clazz . getMethod(), 在普通public的POJO下是正常的, 但对私有实现类, 内部类, 匿名类等都有问题. 
 * @author "yangk"
 * @date 2011-1-21 下午05:28:29 
 *
 */
public class ClassUtils {
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
			Method getter = clazz.getMethod("get" + upper);
			return getter;
		} catch (NoSuchMethodException e1) {
			try {
				Method getter = clazz.getMethod("is" + upper);
				return getter;
			} catch (NoSuchMethodException e2) {
				Method getter = clazz.getMethod(property);
				return getter;
			}
		}
	}

	public static void main(String[] args) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
		Map map = new HashMap();
		map.put("aa", "bb");
		Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
		Object key = ClassUtils.getObjectProperty(entry, "key");
	}
}
