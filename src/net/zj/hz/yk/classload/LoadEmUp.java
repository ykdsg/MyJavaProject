package net.zj.hz.yk.classload;

public class LoadEmUp extends Parent {
	private Parent parent = new Parent();

	{
		System.out.println("运行非静态块");
	}

	static {
		System.out.println("运行静态块 1");
	}

	public LoadEmUp() {
		System.out.println("运行LoadEmUp构造函数");
		parent = new Parent(this);
	}

	static {
		System.out.println("运行静态块 2");
	}

}
