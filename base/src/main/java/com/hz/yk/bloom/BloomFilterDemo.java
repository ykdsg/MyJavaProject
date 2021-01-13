package com.hz.yk.bloom;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.apache.commons.io.Charsets;

/**
 * 布隆过滤器相关demo
 * https://juejin.cn/post/6844904007790673933
 *
 * @author wuzheng.yk
 * @date 2021/1/13
 */
public class BloomFilterDemo {

    public static void main(String[] args) {
        int total = 1000000;
        //BloomFilter<CharSequence> bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), total);
        //如果想提高匹配精度，可以设置误判率
        BloomFilter<CharSequence> bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), total, 0.0002);
        //初始化数据到过滤器
        for (int i = 0; i < total; i++) {
            bf.put("" + i);
        }

        int count = 0;
        for (int i = 0; i < total + 10000; i++) {
            if (bf.mightContain("" + i)) {
                count++;
            }
        }
        System.out.println("已匹配数量:" + count);
    }
}
