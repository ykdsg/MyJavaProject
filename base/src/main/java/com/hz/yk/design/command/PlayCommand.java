package com.hz.yk.design.command;

/**
 * Created by wuzheng.yk on 2017/6/22.
 */
public class PlayCommand implements Command {

    private AudioPlayer myAudio;

    public PlayCommand(AudioPlayer audioPlayer){
        myAudio = audioPlayer;
    }
    /**
     * 执行方法
     */
    @Override
    public void execute() {
        myAudio.play();
    }

}