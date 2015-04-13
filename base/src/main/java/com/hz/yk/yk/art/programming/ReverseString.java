package com.hz.yk.yk.art.programming;

import org.junit.Test;

/**
 * 给定一个字符串，要求把字符串前面的若干个字符移动到字符串的尾部，如把字符串“abcdef”前面的2个字符'a'和'b'移动到字符串的尾部，使得原字符串变成字符串“cdefab”。请写一个函数完成此功能，要求对长度为n的字符串操作的时间复杂度为 O(n)，空间复杂度为 O(1)。
 * @author wuzheng.yk
 *         Date: 14-7-10
 *         Time: 下午7:33
 */
public class ReverseString {

    /**
     * 针对长度为n的字符串来说，假设需要移动m个字符到字符串的尾部，那么总共需要 m*n 次操作，同时设立一个变量保存第一个字符，如此，时间复杂度为O(m * n)，空间复杂度为O(1)
     * 暴力移位法
     * @param str
     */
    static String leftShiftOne(String str) {
        char[] s=str.toCharArray();
        char t = s[0];
        for (int i = 1; i < s.length; i++) {
            s[i - 1] = s[i];
        }
        s[s.length - 1] = t;
        return String.valueOf(s);
    }


    @Test
    public  void testLeftShift() {
        String test = "abcdefg";
        int m = 3;
        while (m > 0) {
            test=leftShiftOne(test);
            m--;
        }
        System.out.println(test);
    }

    /**
     * 将一个字符串分成X和Y两个部分，在每部分字符串上定义反转操作，如X^T，即把X的所有字符反转（如，X="abc"，那么X^T="cba"），那么就得到下面的结论：(X^TY^T)^T=YX，显然就解决了字符串的反转问题。

     例如，字符串 abcdef ，若要让def翻转到abc的前头，只要按照下述3个步骤操作即可：

     首先将原字符串分为两个部分，即X:abc，Y:def；
     将X反转，X->X^T，即得：abc->cba；将Y反转，Y->Y^T，即得：def->fed。
     反转上述步骤得到的结果字符串X^TY^T，即反转字符串cbafed的两部分（cba和fed）给予反转，cbafed得到defabc，形式化表示为(X^TY^T)^T=YX，这就实现了整个反转。
     * @param str
     * @param from
     * @param to
     * @return
     */
    static String resverString(String str, int from, int to) {
        char[] s = str.toCharArray();
        while (from < to) {
            char t = s[from];
            s[from++] = s[to];
            s[to--] = t;

        }
        return String.valueOf(s);
    }

    @Test
    public void testLeftRotateString(){
        String test = "abcdefg";
        int m = 3;
        resverString(test, 0, m - 1);
        resverString(test, m, test.length() - 1);
        resverString(test, 0, test.length() - 1);

    }

}
