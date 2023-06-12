package com.hz.yk.threadlocal;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * https://blog.csdn.net/xlgen157387/article/details/78298840
 *
 * @author wuzheng.yk
 * @date 2019-03-12
 */
public class ThreadLocalOOMDemo {

    private static final int THREAD_LOOP_SIZE        = 500;
    private static final int MOCK_DIB_DATA_LOOP_SIZE = 10000;

    private static ThreadLocal<SoftReference<Map<String, User>>> sfThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<Map<String, User>>                threadLocal   = new ThreadLocal<>();

    private static final Logger log = LoggerFactory.getLogger(ThreadLocalOOMDemo.class);

    /**
     * TL 里面如果是强引用如果没有及时remove 会造成内存泄漏
     */
    @Test
    public void testStrongThreadLocal() {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_LOOP_SIZE);

        for (int i = 0; i < THREAD_LOOP_SIZE; i++) {
            executorService.execute(() -> {
                threadLocal.set(addBigMap());
                Thread t = Thread.currentThread();
                System.out.println(Thread.currentThread().getName());
                //threadLocal.remove(); //不取消注释的话就可能出现OOM
            });
            try {
                Thread.sleep(200L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //executorService.shutdown();
    }

    @Test
    public void testSoftThreadLocal() {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_LOOP_SIZE);

        for (int i = 0; i < THREAD_LOOP_SIZE; i++) {
            executorService.execute(() -> {
                sfThreadLocal.set(addSFBigMap());
                Thread t = Thread.currentThread();
                System.out.println(Thread.currentThread().getName());
                //threadLocal.remove(); //不取消注释的话就可能出现OOM
                SoftReference<Map<String, User>> mapSoftReference = sfThreadLocal.get();
                Map<String, User> userMap = mapSoftReference.get();
                userMap.put("tt", new User("xuliugen", "password" + 1, "男", 10));

            });
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //executorService.shutdown();
    }

    private SoftReference<Map<String, User>> addSFBigMap() {
        Map<String, User> params = new HashMap<>(MOCK_DIB_DATA_LOOP_SIZE);
        SoftReference<Map<String, User>> softParams = new SoftReference(params);
        for (int i = 0; i < MOCK_DIB_DATA_LOOP_SIZE; i++) {
            params.put(System.currentTimeMillis() + "-" + i, new User("xuliugen", "password" + i, "男", i));
        }
        return softParams;
    }

    private Map<String, User> addBigMap() {
        Map<String, User> params = new HashMap<>(MOCK_DIB_DATA_LOOP_SIZE);
        for (int i = 0; i < MOCK_DIB_DATA_LOOP_SIZE; i++) {
            params.put(System.currentTimeMillis() + "-" + i, new User("xuliugen", "password" + i, "男", i));
        }
        return params;
    }

    class User {

        private String userName;
        private String password;
        private String sex;
        private int    age;

        public User(String userName, String password, String sex, int age) {
            this.userName = userName;
            this.password = password;
            this.sex = sex;
            this.age = age;
        }
    }
}
