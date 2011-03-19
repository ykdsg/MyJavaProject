package net.zj.hz.yk.ooa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import net.zj.hz.yk.ooa.entity.Shape;
import net.zj.hz.yk.ooa.factory.ShapeFactory;

public class Panel {

	public void selectShape() throws NumberFormatException, IOException {
		System.out.println("输入类型:");
		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		int shapeType = Integer.parseInt(input.readLine());

		Shape shape = ShapeFactory.getShape(shapeType);

		if (null == shape) {
			System.out.println("出错了");
		} else {
			shape.draw();
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Panel().selectShape();
	}
}
