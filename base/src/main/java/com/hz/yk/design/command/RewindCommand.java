package com.hz.yk.design.command;

/**
 * Created by wuzheng.yk on 2017/6/22.
 */
public class RewindCommand implements Command {

    private AudioPlayer myAudio;

    public RewindCommand(AudioPlayer audioPlayer){
        myAudio = audioPlayer;
    }
    @Override
    public void execute() {
        myAudio.rewind();
    }

}