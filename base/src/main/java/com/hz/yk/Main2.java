package com.hz.yk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wuzheng.yk
 * @date 2018/7/17
 */
public class Main2 {

    private static final Logger log = LoggerFactory.getLogger(Main2.class);

    private static <T> List<List<T>> split(List<T> orignList, int divide) {
        if (orignList.size() <= divide)
            divide = orignList.size();
        int k = orignList.size() / divide;
        List<List<T>> res = new ArrayList<>();
        for (int i = 0; i < divide; i++) {
            List<T> lice0 = new ArrayList<>();
            if (i == divide - 1) {
                for (int j = i * k; j < orignList.size(); j++) {
                    lice0.add(orignList.get(j));
                }
                res.add(lice0);
            } else {
                List<T> lice1 = new ArrayList<>();
                for (int m = i * k; m < (i + 1) * k; m++) {
                    lice1.add(orignList.get(m));
                }
                res.add(lice1);
            }
        }
        return res;
    }

    /**
     * 异常日志输出测试，看看error msg 会不会丢失，实际会在caused by中显示
     *
     * @param args
     */
    //public static void main(String[] args) {
    //    List<String> testList = Lists.newArrayList("A", "B", "c", "d");
    //    List split = split(testList, 3);
    //    System.out.println(split);
    //}

    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] money = { 1, 2, 5, 10 };
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            int target = Integer.parseInt(s);
            int[] memo = new int[target + 1];
            memo[0] = 1;
            for (int i = 0; i < target; i++) {
                for (int num : money) {
                    if (num + i <= target) {
                        memo[i + num] += memo[i];
                    }
                }
            }
            System.out.println(memo[target]);
        }

    }

    static void dfs_(boolean[] visit, String temp, String get) {
        if (temp.length() == 3) {    //System.out.println(temp);
            if (!list.contains(temp))
                list.add(temp);
            return;
        }
        //System.out.println(temp);
        for (int i = 0; i < 5; i++) {
            if (visit[i] == false) {
                temp += get.charAt(i) + "";
                visit[i] = true;
                dfs_(visit, temp, get);
                visit[i] = false;
                temp = temp.substring(0, temp.length() - 1);

            }
        }
    }

}
