package com.hz.yk.file;

/**
 * @author wuzheng.yk
 * @date 2020/10/29
 */
public class AppLevel {

    /**
     * 应用
     */
    private String app;
    /**
     * 评估的等级
     */
    private int level;
    /**
     * 依赖的团队
     */
    private String group;

    public AppLevel(String app, int level, String group) {
        this.app = app;
        this.level = level;
        this.group = group;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
