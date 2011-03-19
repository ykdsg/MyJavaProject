package net.zj.hz.yk.ooa.factory;

import java.util.HashMap;
import java.util.Map;

import net.zj.hz.yk.ooa.entity.Shape;

public class ShapeFactory {

	public static final int SHAPE_TYPE_CIRCLE = 1;
	public static final int SHAPE_TYPE_RECTANGLE = 2;
	public static final int SHAPE_TYPE_LINE = 3;

	private static Map<Integer, String> shapeMap = new HashMap<Integer, String>();

	static {
		shapeMap.put(SHAPE_TYPE_CIRCLE, "Circle");
		shapeMap.put(SHAPE_TYPE_RECTANGLE, "Rectangle");
		shapeMap.put(SHAPE_TYPE_LINE, "Line");
	}

	public static Shape getShape(int type) {
		String packageName = "net.zj.hz.yk.ooa.entity";
		String classname = shapeMap.get(type);
		try {
			// 利用反射来动态装载类
			return (Shape) Class.forName(packageName + "." + classname)
					.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static String test1(String s) {
		return " test 返回：" + s;
	}
}
