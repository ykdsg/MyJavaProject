package com.hz.yk.alg;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/articles/longest-substring-without-repeating-characters/
 *
 * @author wuzheng.yk
 * @date 2019-04-29
 */
public class Ch3 {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            char key = s.charAt(j);
            if (map.containsKey(key)) {
                i = Math.max(map.get(key), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(key, j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "abcadbcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
