package net.zj.hz.yk.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class ObjectSaver {
	private static String FILE_PATH = "objectFile.obj";

	public static void main(String agrs[]) throws Exception {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				FILE_PATH));

		String obj1 = "hello";
		Date obj2 = new Date();
		Customer obj3 = new Customer("Tom", 20);
		// 序列化对象
		out.writeObject(obj1);
		out.writeObject(obj2);
		out.writeObject(obj3);
		out.close();

		// 反序列化对象
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				FILE_PATH));
		String obj11 = (String) in.readObject();
		System.out.println("obj11:" + obj11);
		System.out.println("obj11==obj1:" + (obj11 == obj1));
		System.out.println("obj11.equals(obj1):" + obj11.equals(obj1));

		Date obj22 = (Date) in.readObject();
		System.out.println("obj22:" + obj22);
		System.out.println("obj22==obj2:" + (obj22 == obj2));
		System.out.println("obj22.equals(obj2):" + obj22.equals(obj2));

		Customer obj33 = (Customer) in.readObject();
		System.out.println("obj33:" + obj33);
		System.out.println("obj33==obj3:" + (obj33 == obj3));
		System.out.println("obj33.equals(obj3):" + obj33.equals(obj3));
		in.close();
	}
}

class Customer implements Serializable {
	private String name;
	//transient会禁止对这种属性进行序列化
	private transient int age;

	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("call second constructor");
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Customer))
			return false;
		final Customer other = (Customer) o;

		if (this.name.equals(other.name) && this.age == other.age)
			return true;
		else
			return false;
	}

	public String toString() {
		return "name=" + name + ",age=" + age;
	}
}
