package net.zj.hz.yk.concurrent;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;

public class MyConcurrentHashMap<K, V> extends AbstractMap<K, V> implements
		ConcurrentMap<K, V>, Serializable {

	/**
	 * int 32位，所以这里最大到第31位，因为扩容的话会再扩大一倍刚好是到第32位 The maximum capacity, used if a
	 * higher value is implicitly specified by either of the constructors with
	 * arguments. MUST be a power of two <= 1<<30 to ensure that entries are
	 * indexable using ints.
	 */
	static final int MAXIMUM_CAPACITY = 1 << 30;

	transient Set<Map.Entry<K, V>> entrySet;

	/**
	 * The segments, each of which is a specialized hash table
	 */
	final Segment<K, V>[] segments;

	/**
	 * 段索引偏移值 Shift value for indexing within segments.
	 */
	final int segmentShift;

	/**
	 * Mask value for indexing into segments. The upper bits of a key's hash
	 * code are used to choose the segment.
	 */
	final int segmentMask;

	/**
	 * 允许的segment最大个数
	 */
	static final int MAX_SEGMENTS = 1 << 16; // slightly conservative

	/**
	 * 默认的并发级别，（segment的个数），是2的n次方 The default concurrency level for this table,
	 * used when not otherwise specified in a constructor.
	 */
	static final int DEFAULT_CONCURRENCY_LEVEL = 16;

	/**
	 * 默认的装载因子
	 */
	static final float DEFAULT_LOAD_FACTOR = 0.75f;

	static final int DEFAULT_INITIAL_CAPACITY = 16;

	/**
	 * Number of unsynchronized retries in size and containsValue methods before
	 * resorting to locking. This is used to avoid unbounded retries if tables
	 * undergo continuous modification which would make it impossible to obtain
	 * an accurate result. 在依靠锁定前允许几次size与containsValue
	 * 不一致。这是为了防止无限制的重试而不能得到正确的结果
	 */
	static final int RETRIES_BEFORE_LOCK = 2;

	public boolean remove(Object key, Object value) {
		int hash = hash(key.hashCode());
		if (value == null)
			return false;
		return segmentFor(hash).remove(key, hash, value) != null;
	}

	private static int hash(int h) {
		h += (h << 15) ^ 0xffffcd7d;
		h ^= (h >>> 10);
		h += (h << 3);
		h ^= (h >>> 6);
		h += (h << 2) + (h << 14);
		return h ^ (h >>> 16);
	}

	/**
	 * Returns the segment that should be used for key with given hash
	 * 
	 * @param hash
	 *            the hash code for the key
	 * @return the segment
	 */
	final Segment<K, V> segmentFor(int hash) {
		return segments[(hash >>> segmentShift) & segmentMask];
	}

	/**
	 * 段类型
	 * 
	 * @author "yangk"
	 * @date 2011-3-17 下午05:25:23
	 * 
	 * @param <K>
	 * @param <V>
	 */
	static final class Segment<K, V> extends ReentrantLock implements
			Serializable {
		private static final long serialVersionUID = -8217357260448096785L;
		/**
		 * Segment中元素个数
		 */
		transient volatile int count;

		/**
		 * 更新而导致表数目改变的次数。这是用来确保大量读方法看到一致的快照。
		 * 如果在各个segments循环计算size或者检索containsValue时modCounts改变，那么将得到不一致的结果。
		 * 通常这个必须重来。
		 */
		transient  int modCount;

		/**
		 * table将会重新hash如果size超过threshold。这个值=(容量 * {@link #loadFactor})
		 */
		transient int threshold;

		/**
		 * 存放元素的table数组
		 */
		transient volatile HashEntry<K, V>[] table;

		/**
		 * 装载因子. 尽管这个值对所有的Segment是相同，但是它需要被复制，以避免外部对象对他的引用。
		 * 
		 * @serial
		 */
		final float loadFactor;

		Segment(int initialCapacity, float lf) {
			loadFactor = lf;
			setTable(HashEntry.<K, V> newArray(initialCapacity));
		}

		@SuppressWarnings("unchecked")
		static final <K, V> Segment<K, V>[] newArray(int i) {
			return new Segment[i];
		}

		/**
		 * 
		 * 设置table到新的数组，只有在持有锁或者在构造函数中调用
		 */
		void setTable(HashEntry<K, V>[] newTable) {
			threshold = (int) (newTable.length * loadFactor);
			table = newTable;
		}

		/**
		 * 根据hash值返回适当取得的第一个entry Returns properly casted first entry of bin for
		 * given hash.
		 */
		HashEntry<K, V> getFirst(int hash) {
			HashEntry<K, V>[] tab = table;
			return tab[hash & (tab.length - 1)];
		}

		/**
		 * 在带锁的情况下读取一个entry的值，如果该值曾经为null就会被调用。 只有在编译器碰巧切换这个HashEntry的初始化到table
		 * assignment时，这个时候HashEntry没有初始化好，但是已经可被其他线程可见。 这个在内存模型下是合法 的。
		 * 
		 * 感觉主要是与JIT相关，这句话的意思是说当你tab[index] = new HashEntry()的时候，可能发生partial
		 * construct,
		 * 也就是说其他的Thread可以看到这个reference，但是对象却没有构造完全。这是由JLS来决定的，因为JLS没有说
		 * ，是否应该完成之后再赋值。 而现代的编译器(JIT)可以使用out of
		 * ordering来调度指令，可能就把reference的赋值放在构造函数前边。
		 * 这篇文章给除了很好的分析：http://www.ibm.com
		 * /developerworks/java/library/j-dcl.html。 所以在这里为了避免partial
		 * construct，当value是null的时候，也就是说可能发生partial construct的时候，需要lock（）来保证，
		 * 如果发生了partial construct，那么必然在构造HashEntry，这个HashEntry的构造是在lock（）之下的，
		 * 所以这里的lock就可以等待对象构造的完全。 Reads value field of an entry under lock.
		 * Called if value field ever appears to be null. This is possible only
		 * if a compiler happens to reorder a HashEntry initialization with its
		 * table assignment, which is legal under memory model but is not known
		 * to ever occur.
		 */
		V readValueUnderLock(HashEntry<K, V> e) {
			lock();
			try {
				return e.value;
			} finally {
				unlock();
			}
		}

		/* Specialized implementations of map methods */

		/**
		 * 为什么其他的final的field在partial construct的情况下，不会发生null value之类的错误？ 文献中这么说：
		 * A new guarantee of initialization safety should be provided. If an
		 * object is properly constructed (which means that references to it do
		 * not escape during construction), then all threads which see a
		 * reference to that object will also see the values for its final
		 * fields that were set in the constructor, without the need for
		 * synchronization. 一个对像的值域在构造函数没有逃逸，那么将不会出现部分初始化的现象
		 */
		V get(Object key, int hash) {
			if (count != 0) { // read-volatile
				HashEntry<K, V> e = getFirst(hash);
				while (e != null) {
					if (e.hash == hash && key.equals(e.key)) {
						V v = e.value;
						if (v != null)
							return v;
						return readValueUnderLock(e); // 这里需要再确认是否有发生部分构造而导致的null
					}
					e = e.next;
				}
			}
			return null;
		}

		boolean containsKey(Object key, int hash) {
			if (count != 0) { // read-volatile
				HashEntry<K, V> e = getFirst(hash);
				while (e != null) {
					if (e.hash == hash && key.equals(e.key)) {
						return true;
					}
					e = e.next;
				}
			}
			return false;
		}

		boolean containsValue(Object value) {
			if (count != 0) {
				HashEntry<K, V>[] tab = table;
				int len = tab.length;
				for (int i = 0; i < len; i++) {
					for (HashEntry<K, V> e = tab[i]; e != null; e = e.next) {
						V v = e.value;
						if (v == null) // recheck
							v = readValueUnderLock(e);
						if (value.equals(v))
							return true;
					}
				}
			}
			return false;
		}

		boolean replace(K key, int hash, V oldValue, V newValue) {
			lock();
			try {
				HashEntry<K, V> e = getFirst(hash);
				while (e != null && (e.hash != hash || !key.equals(e.key)))
					e = e.next;

				boolean replaced = false;
				if (e != null && oldValue.equals(e.value)) {
					replaced = true;
					e.value = newValue;
				}
				return replaced;
			} finally {
				unlock();
			}

		}

		V replace(K key, int hash, V newValue) {
			lock();
			try {
				HashEntry<K, V> e = getFirst(hash);
				while (e != null && (e.hash != hash || !key.equals(e.key)))
					e = e.next;

				V oldValue = null;
				if (e != null) {
					oldValue = e.value;
					e.value = newValue;
				}
				return oldValue;
			} finally {
				unlock();
			}
		}

		V put(K key, int hash, V value, boolean onlyIfAbsent) {
			lock();
			try {
				int c = count;
				if (c++ > threshold) // 需要扩容
					rehash();
				HashEntry<K, V>[] tab = table;
				int index = hash & (tab.length - 1);
				HashEntry<K, V> first = tab[index];
				HashEntry<K, V> e = first;
				while (e != null && (e.hash != hash || !e.key.equals(key)))
					e = e.next;
				V oldValue;
				if (e != null) {// 如果e不等于null，说明键值重复
					oldValue = e.value;
					if (!onlyIfAbsent) {
						e.value = value;
					}
				} else {// 如果e为null说明需要增加一个
					oldValue = null;
					++modCount;
					tab[index] = new HashEntry<K, V>(key, hash, first, value);
					count = c; // write-volatile
				}
				return oldValue;

			} finally {
				unlock();
			}
		}

		void rehash() {
			HashEntry<K, V>[] oldTable = table;
			int oldCapacity = oldTable.length;
			if (oldCapacity >= MAXIMUM_CAPACITY)
				return;
			// 扩容一倍
			HashEntry<K, V>[] newTable = HashEntry.newArray(oldCapacity << 1);
			threshold = (int) (newTable.length * loadFactor);
			int sizeMask = newTable.length - 1;
			for (int i = 0; i < oldCapacity; i++) {
				// 必须保证现有的map可以继续读，所以我们不能清空每个槽
				HashEntry<K, V> e = oldTable[i];
				if (e != null) {
					HashEntry<K, V> next = e.next;
					int idx = e.hash & sizeMask;
					// 如果只是单个节点
					if (next == null)
						newTable[idx] = e;
					else {
						HashEntry<K, V> lastRun = e;
						int lastIdx = idx;
						// 先把链表末端的节点移到新的槽位，然后把其余的节点克隆到新的槽位 ，rehash之后idx相同的元素
						// 这些元素相当于一个串一起移到新的槽位 ，例如：原来oldTable[i] 下有10个HashEntry，
						// 按照下面的算法，假设从第5个开始，这些HashEntry在newTable中计算的hash值都一样，那么只要移动第5位即可。
						for (HashEntry<K, V> last = next; last != null; last = last.next) {
							// 在新table中的hash值
							int k = last.hash & sizeMask;
							if (k != lastIdx) {
								lastIdx = k;
								lastRun = last;
							}
						}
						// 这里这样处理不知道是否有算法的保证，因为怎么确定newTable[lastIdx]在循环中一直没有值？
						newTable[lastIdx] = lastRun;

						// 复制剩下的所有HashEntry
						for (HashEntry<K, V> p = e; p != lastRun; p = p.next) {
							int k = p.hash & sizeMask;
							HashEntry<K, V> n = newTable[k];
							newTable[k] = new HashEntry<K, V>(p.key, p.hash, n,
									p.value);
						}

					}
				}
			}
			table = newTable;
		}

		/**
		 * Remove; match on key only if value null, else match both.
		 */
		V remove(Object key, int hash, Object value) {
			lock();
			try {
				int c = count - 1;
				HashEntry<K, V>[] tab = table;
				int index = hash & (tab.length - 1);
				HashEntry<K, V> first = tab[index];
				HashEntry<K, V> e = first;
				while (e != null && (e.hash != hash || !key.equals(e.key)))
					e = e.next;

				V oldValue = null;
				if (e != null) {
					V v = e.value;
					if (value == null || value.equals(v)) {
						oldValue = v;
						// 被删除节点的后面列表可以保留，但是前面的需要复制
						++modCount;
						HashEntry<K, V> newFirst = e.next;
						// 如果原来是1,2,3,4,5,6,7；要移除第4位，那么新的序列变成3,2,1,5,6,7
						for (HashEntry<K, V> p = first; p != e; p = p.next)
							newFirst = new HashEntry<K, V>(p.key, p.hash,
									newFirst, p.value);
						tab[index] = newFirst;
						count = c; // write-volatile
					}
				}
				return oldValue;
			} finally {
				unlock();
			}
		}

		void clear() {
			if (count != 0) {
				lock();
				try {
					HashEntry<K, V>[] tab = table;
					for (int i = 0; i < tab.length; i++)
						tab[i] = null;
					++modCount;
					count = 0; // write-volatile
				} finally {
					unlock();
				}
			}
		}
	}

	static final class HashEntry<K, V> {
		final K key;
		final int hash;
		volatile V value;
		final HashEntry<K, V> next;

		HashEntry(K key, int hash, HashEntry<K, V> next, V value) {
			this.key = key;
			this.hash = hash;
			this.next = next;
			this.value = value;
		}

		@SuppressWarnings("unchecked")
		static final <K, V> HashEntry<K, V>[] newArray(int i) {
			return new HashEntry[i];
		}

	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> es = entrySet;
		return (es != null) ? es : (entrySet = new EntrySet());
	}

	final class EntrySet extends AbstractSet<Map.Entry<K, V>> {

		@Override
		public Iterator<Map.Entry<K, V>> iterator() {
			return new EntryIterator();
		}

		@Override
		public boolean contains(Object o) {
			if (!(o instanceof Map.Entry))
				return false;
			Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
			V v = MyConcurrentHashMap.this.get(e.getKey());
			return v != null && v.equals(e.getValue());
		}

		@Override
		public boolean remove(Object o) {
			if (!(o instanceof Map.Entry))
				return false;
			Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
			return MyConcurrentHashMap.this.remove(e.getKey(), e.getValue());
		}

		@Override
		public int size() {
			return MyConcurrentHashMap.this.size();
		}

		@Override
		public void clear() {
			MyConcurrentHashMap.this.clear();
		}

	}

	final class EntryIterator extends HashIterator implements
			Iterator<Entry<K, V>> {
		@Override
		public Map.Entry<K, V> next() {
			HashEntry<K, V> e = super.nextEntry();
			return new WriteThroughEntry(e.key, e.value);
		}
	}

	/**
	 * Custom Entry class used by EntryIterator.next(), that relays setValue
	 * changes to the underlying map.
	 */
	final class WriteThroughEntry extends AbstractMap.SimpleEntry<K, V> {

		WriteThroughEntry(K k, V v) {
			super(k, v);
		}

		/**
		 * Set our entry's value and write through to the map. The value to
		 * return is somewhat arbitrary here. Since a WriteThroughEntry does not
		 * necessarily track asynchronous changes, the most recent "previous"
		 * value could be different from what we return (or could even have been
		 * removed in which case the put will re-establish). We do not and
		 * cannot guarantee more.
		 */
		@Override
		public V setValue(V value) {
			if (value == null)
				throw new NullPointerException();
			V v = super.setValue(value);
			MyConcurrentHashMap.this.put(getKey(), value);
			return v;
		}
	}

	/* ---------------- Iterator Support -------------- */

	abstract class HashIterator {
		int nextSegmentIndex;
		int nextTableIndex;
		HashEntry<K, V>[] currentTable;
		HashEntry<K, V> nextEntry;
		HashEntry<K, V> lastReturned;

		HashIterator() {
			nextSegmentIndex = segments.length - 1;
			nextTableIndex = -1;
			advance();
		}

		public boolean hasMoreElements() {
			return hasNext();
		}

		//循环segments 返回nextEntry
		final void advance() {
			if (nextEntry != null && (nextEntry = nextEntry.next) != null)
				return;

			while (nextTableIndex >= 0) {
				if ((nextEntry = currentTable[nextTableIndex--]) != null)
					return;
			}

			while (nextSegmentIndex >= 0) {
				Segment<K, V> seg = segments[nextSegmentIndex--];
				if (seg.count != 0) {
					currentTable = seg.table;
					for (int j = currentTable.length - 1; j >= 0; --j) {
						if ((nextEntry = currentTable[j]) != null) {
							nextTableIndex = j - 1;
							return;
						}
					}
				}
			}
		}

		public boolean hasNext() {
			return nextEntry != null;
		}

		HashEntry<K, V> nextEntry() {
			if (nextEntry == null)
				throw new NoSuchElementException();
			lastReturned = nextEntry;
			advance();
			return lastReturned;
		}

		public void remove() {
			if (lastReturned == null)
				throw new IllegalStateException();
			MyConcurrentHashMap.this.remove(lastReturned.key);
			lastReturned = null;
		}
	}

	/* ---------------- Public operations -------------- */

	public MyConcurrentHashMap(int initialCapacity, float loadFactor,
			int concurrencyLevel) {
		if (!(loadFactor > 0) || initialCapacity < 0 || concurrencyLevel <= 0)
			throw new IllegalArgumentException();
		if (concurrencyLevel > MAX_SEGMENTS)
			concurrencyLevel = MAX_SEGMENTS;
		// Find power-of-two sizes best matching arguments
		int sshift = 0;
		//Segment数组长度
		int ssize = 1;
		while (ssize < concurrencyLevel) {
			++sshift;
			ssize <<= 1;
		}
		segmentShift = 32 - sshift;
		segmentMask = ssize - 1;
		this.segments = Segment.newArray(ssize);

		if (initialCapacity > MAXIMUM_CAPACITY)
			initialCapacity = MAXIMUM_CAPACITY;
		int c = initialCapacity / ssize;
		if (c * ssize < initialCapacity)
			++c;
		//每个Segment的初始容量
		int cap = 1;
		while (cap < c)
			cap <<= 1;

		for (int i = 0; i < this.segments.length; ++i)
			this.segments[i] = new Segment<K, V>(cap, loadFactor);
	}

	public MyConcurrentHashMap(int initialCapacity, float loadFactor) {
		this(initialCapacity, loadFactor, DEFAULT_CONCURRENCY_LEVEL);
	}

	public MyConcurrentHashMap(int initialCapacity) {
		this(initialCapacity, DEFAULT_LOAD_FACTOR, DEFAULT_CONCURRENCY_LEVEL);
	}

	public MyConcurrentHashMap() {
		this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR,
				DEFAULT_CONCURRENCY_LEVEL);
	}

	public MyConcurrentHashMap(Map<? extends K, ? extends V> m) {
		this(Math.max((int) (m.size() / DEFAULT_LOAD_FACTOR) + 1,
				DEFAULT_INITIAL_CAPACITY), DEFAULT_LOAD_FACTOR,
				DEFAULT_CONCURRENCY_LEVEL);
		putAll(m);
	}

	public boolean isEmpty() {
		final Segment<K, V>[] segments = this.segments;
		/*
		 * We keep track of per-segment modCounts to avoid ABA problems in which
		 * an element in one segment was added and in another removed during
		 * traversal, in which case the table was never actually empty at any
		 * point. Note the similar use of modCounts in the size() and
		 * containsValue() methods, which are the only other methods also
		 * susceptible to ABA problems.
		 */

		/**
		 *保存每个segment
		 * 的modCounts值，避免ABA问题在一个segment中一个元素被增加和一个元素在遍历的时候被删除。在这种情况下
		 * ，table数组没有真正的 empty 在任何一个点。注意相似的在
		 * size()方法和containsValue()方法，基本上只有这些方法比较容易受ABA问题的影响。
		 */
		int[] mc = new int[segments.length];
		int mcsum = 0;

		for (int i = 0; i < segments.length; ++i) {
			if (segments[i].count != 0)
				return false;
			else
				mcsum += mc[i] = segments[i].modCount;
		}
		// If mcsum happens to be zero, then we know we got a snapshot
		// before any modifications at all were made. This is
		// probably common enough to bother tracking.
		/*
		 * 如果mcsm==0，那么我们刚好得到一个在任何修改操作之前的快照。如果不是那可能就是常见的打扰跟踪。
		 * 但貌似也不是百分百的，如果在if的时候mcsum是0的
		 * ，但是这个时候线程被切开了，其他的线程增加或者删除了元素，这个时候再切回来，貌似就不准了
		 * 不过就像上面说的这个就是个快照，在多线程的情况下不会那么精准，基本上的业务都应该可以忍受这样的进度，如果非要准确值，估计只有加锁了。
		 */
		if (mcsum != 0) {
			// 如果mcsum不为0， 那么说明在统计的过程中有变化，需要重新统计
			for (int i = 0; i < segments.length; ++i) {
				//modCount有变化就说明不为empty
				if (segments[i].count != 0 || mc[i] != segments[i].modCount)
					return false;
			}
		}
		return true;
	}

	@Override
	public int size() {
		final Segment<K, V>[] segments = this.segments;
		long sum = 0;
		long check = 0;
		int[] mc = new int[segments.length];
		// Try a few times to get accurate count. On failure due to
		// continuous async changes in table, resort to locking.
		for (int k = 0; k < RETRIES_BEFORE_LOCK; ++k) {
			check = 0;
			sum = 0;
			int mcsum = 0;
			for (int i = 0; i < segments.length; ++i) {
				sum += segments[i].count;
				mcsum += mc[i] = segments[i].modCount;
			}
			if (mcsum != 0) {
				for (int i = 0; i < segments.length; ++i) {
					check += segments[i].count;
					if (mc[i] != segments[i].modCount) {
						// 如果这个时候segments有过数据的改变，那么强制从新统计
						check = -1; // force retry
						break;
					}
				}
			}
			if (check == sum)
				break;
		}
		// 加锁统计
		if (check != sum) { // Resort to locking all segments
			sum = 0;
			for (int i = 0; i < segments.length; ++i)
				segments[i].lock();
			for (int i = 0; i < segments.length; ++i)
				sum += segments[i].count;
			for (int i = 0; i < segments.length; ++i)
				segments[i].unlock();
		}
		if (sum > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		else
			return (int) sum;
	}

	@Override
	public boolean containsValue(Object value) {
		if (value == null)
			throw new NullPointerException();

		final Segment<K, V>[] segments = this.segments;
		int[] mc = new int[segments.length];

		// 这里就和size()方法里相似
		for (int k = 0; k < RETRIES_BEFORE_LOCK; ++k) {
			int sum = 0;
			int mcsum = 0;
			for (int i = 0; i < segments.length; ++i) {
				int c = segments[i].count;
				mcsum += mc[i] = segments[i].modCount;
				if (segments[i].containsValue(value))
					return true;
			}
			boolean cleanSweep = true;
			if (mcsum != 0) {
				for (int i = 0; i < segments.length; ++i) {
					int c = segments[i].count;
					if (mc[i] != segments[i].modCount) {
						cleanSweep = false;
						break;
					}
				}
			}
			if (cleanSweep)
				return false;
		}
		// Resort to locking all segments
        for (int i = 0; i < segments.length; ++i)
            segments[i].lock();
        boolean found = false;
        try {
            for (int i = 0; i < segments.length; ++i) {
                if (segments[i].containsValue(value)) {
                    found = true;
                    break;
                }
            }
        } finally {
            for (int i = 0; i < segments.length; ++i)
                segments[i].unlock();
        }
        return found;
	}
	
	@Override
	public V put(K key, V value) {
        if (value == null)
            throw new NullPointerException();
        int hash = hash(key.hashCode());
        return segmentFor(hash).put(key, hash, value, false);
    }

	
	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> e : m.entrySet())
            put(e.getKey(), e.getValue());
    }
	
	@Override
	public V get(Object key) {
		int hash = hash(key.hashCode());
		return segmentFor(hash).get(key, hash);
	}

	@Override
	public boolean containsKey(Object key) {
		int hash = hash(key.hashCode());
		return segmentFor(hash).containsKey(key, hash);
	}

	@Override
	public V putIfAbsent(K key, V value) {
		if (value == null)
			throw new NullPointerException();
		int hash = hash(key.hashCode());
		return segmentFor(hash).put(key, hash, value, true);
	}

	@Override
	public V replace(K key, V value) {
		if (value == null)
			throw new NullPointerException();
		int hash = hash(key.hashCode());
		return segmentFor(hash).replace(key, hash, value);
	}

	@Override
	public boolean replace(K key, V oldValue, V newValue) {
		if (oldValue == null || newValue == null)
			throw new NullPointerException();
		int hash = hash(key.hashCode());
		return segmentFor(hash).replace(key, hash, oldValue, newValue);
	}

	@Override
	public void clear() {
		for (int i = 0; i < segments.length; ++i)
			segments[i].clear();
	}

	public static void main(String[] args) {
		System.out.println("###:" + MAX_SEGMENTS);
	}
}
