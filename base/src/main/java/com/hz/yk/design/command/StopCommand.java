package com.hz.yk.design.command;

/**
 * Created by wuzheng.yk on 2017/6/22.
 */
public class StopCommand implements Command {
    private AudioPlayer myAudio;

    public StopCommand(AudioPlayer audioPlayer){
        myAudio = audioPlayer;
    }
    @Override
    public void execute() {
        myAudio.stop();
    }

}