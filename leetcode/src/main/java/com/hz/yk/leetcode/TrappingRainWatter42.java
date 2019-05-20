package com.hz.yk.leetcode;

import java.util.Stack;

/**
 * @author wuzheng.yk
 * @date 2019-05-06
 */
public class TrappingRainWatter42 {

    public static int trap1(int[] height) {
        int res = 0, mx = 0, length = height.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; ++i) {
            dp[i] = mx;
            mx = Math.max(mx, height[i]);
        }
        mx = 0;
        for (int i = length - 1; i >= 0; --i) {
            dp[i] = Math.min(dp[i], mx);
            mx = Math.max(mx, height[i]);
            if (dp[i] - height[i] > 0)
                res += dp[i] - height[i];
        }
        System.out.println(res);
        return res;
    }

    public static int trap2(int[] height) {
        int res = 0, l = 0, r = height.length - 1;
        while (l < r) {
            int mn = Math.min(height[l], height[r]);
            if (height[l] == mn) {
                ++l;
                while (l < r && height[l] < mn) {
                    res += mn - height[l++];
                }
            } else {
                --r;
                while (l < r && height[r] < mn) {
                    res += mn - height[r--];
                }
            }
        }
        System.out.println(res);
        return res;
    }

    public static int trap3(int[] height) {
        int l = 0, r = height.length - 1, level = 0, res = 0;
        while (l < r) {
            int lower = height[(height[l] < height[r]) ? l++ : r--];
            level = Math.max(level, lower);
            res += level - lower;
        }
        System.out.println(res);
        return res;
    }

    /**
     * 遍历高度，如果此时栈为空，或者当前高度小于等于栈顶高度，则把当前高度的坐标压入栈，注意我们不直接把高度压入栈，而是把坐标压入栈，这样方便我们在后来算水平距离。当我们遇到比栈顶高度大的时候，就说明有可能会有坑存在，可以装雨水。此时我们栈里至少有一个高度，如果只有一个的话，那么不能形成坑，我们直接跳过，如果多余一个的话，那么此时把栈顶元素取出来当作坑，新的栈顶元素就是左边界，当前高度是右边界，只要取二者较小的，减去坑的高度，长度就是右边界坐标减去左边界坐标再减1，二者相乘就是盛水量
     *
     * @param height
     * @return
     */
    public static int trap4(int[] height) {
        Stack<Integer> s = new Stack<Integer>();
        int i = 0, n = height.length, res = 0;
        while (i < n) {
            if (s.isEmpty() || height[i] <= height[s.peek()]) {
                s.push(i++);
            } else {
                int t = s.pop();
                if (s.isEmpty())
                    continue;
                res += (Math.min(height[i], height[s.peek()]) - height[t]) * (i - s.peek() - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //trap1(new int[]{ 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });
        //trap2(new int[]{ 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });
        trap3(new int[]{ 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });

    }
}
