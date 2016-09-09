package com.hz.yk.art.programming;

import org.junit.Test;

/**
 * ����һ���ַ�����Ҫ����ַ���ǰ������ɸ��ַ��ƶ����ַ�����β��������ַ�����abcdef��ǰ���2���ַ�'a'��'b'�ƶ����ַ�����β����ʹ��ԭ�ַ�������ַ�����cdefab������дһ��������ɴ˹��ܣ�Ҫ��Գ���Ϊn���ַ���������ʱ�临�Ӷ�Ϊ O(n)���ռ临�Ӷ�Ϊ O(1)��
 * @author wuzheng.yk
 *         Date: 14-7-10
 *         Time: ����7:33
 */
public class ReverseString {

    /**
     * ��Գ���Ϊn���ַ�����˵��������Ҫ�ƶ�m���ַ����ַ�����β������ô�ܹ���Ҫ m*n �β�����ͬʱ����һ�����������һ���ַ�����ˣ�ʱ�临�Ӷ�ΪO(m * n)���ռ临�Ӷ�ΪO(1)
     * ������λ��
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
     * ��һ���ַ����ֳ�X��Y�������֣���ÿ�����ַ����϶��巴ת��������X^T������X�������ַ���ת���磬X="abc"����ôX^T="cba"������ô�͵õ�����Ľ��ۣ�(X^TY^T)^T=YX����Ȼ�ͽ�����ַ����ķ�ת���⡣

     ���磬�ַ��� abcdef ����Ҫ��def��ת��abc��ǰͷ��ֻҪ��������3������������ɣ�

     ���Ƚ�ԭ�ַ�����Ϊ�������֣���X:abc��Y:def��
     ��X��ת��X->X^T�����ã�abc->cba����Y��ת��Y->Y^T�����ã�def->fed��
     ��ת��������õ��Ľ���ַ���X^TY^T������ת�ַ���cbafed�������֣�cba��fed�����跴ת��cbafed�õ�defabc����ʽ����ʾΪ(X^TY^T)^T=YX�����ʵ����������ת��
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
        System.out.println(resverString(test, 0, m - 1));
        System.out.println(resverString(test, m, test.length() - 1));
        System.out.println(resverString(test, 0, test.length() - 1));

    }

}
