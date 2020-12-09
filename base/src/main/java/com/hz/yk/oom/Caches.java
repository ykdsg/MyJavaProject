/**
 * High-Speed Service Framework (HSF)
 * www.taobao.com
 * (C) �Ա�(�й�) 2003-2008
 */
package com.hz.yk.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * For JavaHeapSpaceCase
 *
 * @author <a href="mailto:bixuan@taobao.com">bixuan</a>
 */
public class Caches {

	private static final Caches _self = new Caches();

	private List<JavaHeapSpaceObject> objects = new ArrayList<JavaHeapSpaceObject>();

	private Caches() {
		;
	}

	public static Caches getInstance() {
		return _self;
	}

	public void init() {
		for (int i = 0; i < 7; i++) {
			System.out.println("add heap space:" + i);
			objects.add(new JavaHeapSpaceObject(2));
		}
	}

	public void remove() {
		objects.remove(0);
	}

}

class JavaHeapSpaceObject {

	byte[] bytes = null;

	public JavaHeapSpaceObject(int msize) {
		bytes = new byte[1024 * 1024 * msize];
	}

}
