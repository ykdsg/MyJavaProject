package com.hz.yk.io.nio.reactor;

import java.nio.ByteBuffer;
import java.util.ArrayList;

public class BufferPoolTest {

	@org.junit.Test
	public void Test() {
		BufferPool pool = new BufferPool(1024 * 5, 1024);
		int i = pool.capacity();
		ArrayList<ByteBuffer> all = new ArrayList<ByteBuffer>();
		for (int j = 0; j <= i; j++) {
			all.add(pool.allocate());
		}
		for (ByteBuffer buf : all) {
			pool.recycle(buf);
		}
	}
}
