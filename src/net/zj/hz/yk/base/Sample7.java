package net.zj.hz.yk.base;

import org.junit.Test;

public class Sample7 {
	final int var1;

	static {
		// var1=1;
	}

	public Sample7() {
		var1 = 1;
	}

	public Sample7(int i) {
		this();
		// var1=i;
	}

	public static void main(String[] args) {
		try {
			System.out.println("Begin");
			System.exit(0);
		} finally {
			System.out.println("Finally");
		}
		System.out.println("Emd");

	}

}
