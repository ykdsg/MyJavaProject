package com.hz.yk.reactor;

import reactor.core.publisher.Mono;

/**
 * 参考：往简单的方向深入理解，或许反应式编程更容易入门
 * https://mp.weixin.qq.com/s?__biz=MzU0MzE1NDU1OA==&mid=2247486456&idx=1&sn=8096f8bc88ab53587a7e8be7cd79da2b&chksm=fb0e83e9cc790affc20d232a4e10ff8a6fc7e6b79b50590c098c5ff7c9826636250021d543c0&scene=178&cur_album_id=1586559916134187009#rd
 *
 * @author wuzheng.yk
 * @date 2021/5/13
 */
public class ReacviceDemo {

    public static void main(String[] args) {
        Mono.just(1).subscribe(System.out::println);
    }
}
