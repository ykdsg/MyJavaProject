package com.hz.yk.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wuzheng.yk
 * @date 2020/10/29
 */
public class AnalysisMain {

    public static void main(String[] args) throws IOException {
        final Map<String, AppLevel> result = readFile("/level/trade.txt", "/level/base.txt", "/level/mall.txt",
                                                      "/level/crm.txt", "/level/data.txt");
        System.out.println(result);

        Set<AppLevel> p1App = new HashSet<>();
        Set<AppLevel> p2App = new HashSet<>();
        Set<AppLevel> p3App = new HashSet<>();
        for (AppLevel appLevel : result.values()) {
            if (appLevel.getLevel() == 1) {
                p1App.add(appLevel);
            }
            if (appLevel.getLevel() == 2) {
                p2App.add(appLevel);
            }
            if (appLevel.getLevel() == 3) {
                p3App.add(appLevel);
            }

        }
        System.out.println("P1级别应用：");
        for (AppLevel appLevel : p1App) {
            System.out.println(appLevel.getApp() + "  " + appLevel.getGroup());
        }
        System.out.println("P2级别应用：");
        for (AppLevel appLevel : p2App) {
            System.out.println(appLevel.getApp() + "  " + appLevel.getGroup());
        }

        //System.out.println("P3级别应用：");
        //for (AppLevel appLevel : p3App) {
        //    System.out.println(appLevel.getApp() + "  " + appLevel.getGroup());
        //}
    }

    private static Map<String, AppLevel> readFile(String... filePaths) throws IOException {
        Map<String, AppLevel> resultMap = new HashMap<>();
        for (String filePath : filePaths) {
            final InputStream inputStream = AnalysisMain.class.getResourceAsStream(filePath);
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String strLine;
            String group = null;
            if (filePath.contains("base")) {
                group = "基础线";
            } else if (filePath.contains("data")) {
                group = "数据线";
            } else if (filePath.contains("mall")) {
                group = "商城线";
            } else if (filePath.contains("crm")) {
                group = "CRM线";
            } else if (filePath.contains("trade")) {
                group = "交易线";
            }
            if (group == null) {
                throw new IllegalArgumentException("group is not confirm");
            }

            while ((strLine = in.readLine()) != null) {
                final String[] strs = strLine.split(",");
                if (strs.length < 2) {
                    continue;
                }
                String appName = strs[0].trim();
                String value = strs[1].trim();

                final int level = Integer.parseInt(value.charAt(1) + "");
                AppLevel appLevel = new AppLevel(appName, level, group);

                if (!resultMap.containsKey(appName)) {
                    resultMap.put(appName, appLevel);
                } else {
                    final AppLevel originValue = resultMap.get(appName);
                    int originLevel = originValue.getLevel();
                    int currentLevel = Integer.parseInt(value.charAt(1) + "");

                    if (currentLevel < originLevel) {
                        resultMap.put(appName, appLevel);
                    }
                }

            }
        }

        return resultMap;
    }

}
