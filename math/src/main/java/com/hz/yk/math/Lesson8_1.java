package com.hz.yk.math;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuzheng.yk
 * @date 2020/7/12
 */
public class Lesson8_1 {

    /**
     * @param teams-目前还剩多少队伍没有参与组合，result-保存当前已经组合的队伍
     * @return void
     * @Description: 使用函数的递归（嵌套）调用，找出所有可能的队伍组合
     */

    public static void combine(List<String> teams, List<String> result, int m) {
        if (result.size() == m) {
            System.out.println(result);
            return;
        }
        for (int i = 0; i < teams.size(); i++) {
            List<String> newResult = Lists.newArrayList(result);
            newResult.add(teams.get(i));
            // 只考虑当前选择之后的所有队伍
            List<String> newTeams = teams.subList(i + 1, teams.size());
            combine(newTeams, newResult, m);
        }
    }

    public static void combine2(List<String> teams, List<String> result, int m, List<List<String>> combineList) {
        if (result.size() == m) {
            System.out.println("获奖组合：" + result);
            combineList.add(Lists.newArrayList(result));
        }
        for (int i = 0; i < teams.size(); i++) {
            List<String> newResult = Lists.newArrayList(result);
            newResult.add(teams.get(i));
            // 只考虑当前选择之后的所有队伍
            List<String> newTeams = teams.subList(i + 1, teams.size());
            combine2(newTeams, newResult, m, combineList);
        }
    }

    public static void main(String[] args) {
        List<String> teams = new ArrayList<String>(Arrays.asList("t1", "t2", "t3"));
        combine(teams, new ArrayList<String>(), 2);

        List<String> team100 = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            team100.add("t" + i);
        }
        List<List<String>> thirdPrizeList = Lists.newArrayList();
        combine2(team100, new ArrayList<>(), 10, thirdPrizeList);
        for (List<String> thirdList : thirdPrizeList) {
            System.out.println("三等奖获奖：" + thirdList);
            ArrayList<String> newTeam = Lists.newArrayList(team100);
            newTeam.removeAll(thirdList);
            List<List<String>> secondPrizeList = Lists.newArrayList();
            combine2(team100, new ArrayList<>(), 5, secondPrizeList);
        }

    }

}
