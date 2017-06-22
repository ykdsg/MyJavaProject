package com.hz.yk.design.command;

/**
 * 接收者角色类，由录音机类扮演
 * Created by wuzheng.yk on 2017/6/22.
 */
public class AudioPlayer {
    public void play(){
        System.out.println("播放...");
    }

    public void rewind(){
        System.out.println("倒带...");
    }

    public void stop(){
        System.out.println("停止...");
    }
}
