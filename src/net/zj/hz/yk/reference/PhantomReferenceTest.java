package net.zj.hz.yk.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;

/**
 * Phanton Reference, 是一种特殊的Reference，正如他的名字所表达的，幻影引用，他可以像幻影一样附着在referent上。
 * 当GC在遍历引用关系时，如果发现被phantom reference包装过的referent不存在strong, weak,
 * soft引用时(就是除phantom外没有任何引用，幻影的由来)，GC会将 phantom reference 放入 Reference
 * queue。以便程序在另一边通过queue的remove/poll方法，感知referent被GC回收的事件。
 * 
 * @author "yangk"
 * @date 2011-1-26 下午03:21:34
 * 
 */
public class PhantomReferenceTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ReferenceQueue referenceQueue = new ReferenceQueue();
		Object object = new Object() {
			public String toString() {
				return "Referenced Object";
			}
		};

		Object data = new Object() {
			public String toString() {
				return "Data";
			}
		};

		HashMap map = new HashMap();
		Reference reference = null;
		System.out.println("Testing PhantomReference.");
		reference = new PhantomReference(object, referenceQueue);

		map.put(reference, data);

		System.out.println(reference.get()); // null
		System.out.println(map.get(reference)); // Data
		System.out.println(reference.isEnqueued()); // false

		System.gc();
		System.out.println(reference.get()); // null
		System.out.println(map.get(reference)); // Data
		System.out.println(reference.isEnqueued()); // false

		object = null;
		data = null;

		System.gc();
		System.out.println(reference.get()); // null
		System.out.println(map.get(reference)); // Data
		System.out.println(reference.isEnqueued()); // true, because object has
		// been reclaimed.
	}
}
