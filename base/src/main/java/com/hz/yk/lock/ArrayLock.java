package com.hz.yk.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 有界队列锁，使用一个volatile数组来组织线程
 * 假设L把锁，那么锁的空间复杂度为O(Ln)
 * 缺点：
 * 1. 它必须知道线程的规模数，对于同一把锁如果线程获取的次数超过了n会出现线程状态被覆盖的问题
 * 2. 空间复杂度是O(Ln)
 * 3. 对于共享的volatile数组来保存线程获取锁的状态，仍然可能存在缓存一致性。我们知道CPU读取一次内存时，会读满数据总线的位长，比如64位总线，一次读取64位长度的数据。那么对于boolean类型的数组，boolean长度是1个字节，那么一次读取能读到8个boolean变量，而高速缓存的一个缓存块的长度也是64位，也就是说一个缓存块上可以保存8个boolean变量，所以如果一次CAS操作修改了一个变量导致一个缓存块无效，它实际上可能导致8个变量失效。
 *
 * @author wuzheng.yk
 * @date 2020/8/7
 */
public class ArrayLock implements Lock {

    // 使用volatile数组来存放锁标志， flags[i] = true表示可以获得锁
    private volatile boolean[] flags;
    // 指向新加入的节点的后一个位置
    private AtomicInteger tail;
    // 总容量
    private final int capacity;
    //通过一个ThreadLocal变量给每个线程一个索引号，表示它位于队列的哪个位置。
    private ThreadLocal<Integer> mySlotIndex = new ThreadLocal<Integer>() {

        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public ArrayLock(int capacity) {
        this.capacity = capacity;
        flags = new boolean[capacity];
        tail = new AtomicInteger(0);
        flags[0] = true;
    }

    @Override

    public void lock() {
        int slot = tail.getAndIncrement() % capacity;
        mySlotIndex.set(slot);
        // flags[slot] == true 表示获得了锁， volatile变量保证锁释放及时通知
        while (!flags[slot]) {

        }
    }

    @Override
    public void unlock() {
        int slot = mySlotIndex.get();
        flags[slot] = false;
        flags[(slot + 1) % capacity] = true;
    }

    @Override
    public String toString() {
        return "ArrayLock";
    }
}
