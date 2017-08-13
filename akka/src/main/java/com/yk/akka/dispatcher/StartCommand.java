package com.yk.akka.dispatcher;

import java.io.Serializable;

/**
 * Created by wuzheng.yk on 2017/8/1.
 */
public class StartCommand implements Serializable {

    private int actorCount =0;

    public StartCommand() {
    }

    public StartCommand(int actorCount) {
        this.actorCount = actorCount;
    }

    public int getActorCount() {
        return actorCount;
    }

    public void setActorCount(int actorCount) {
        this.actorCount = actorCount;
    }

}
