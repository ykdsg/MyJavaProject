package com.hz.yk.yk.statemachine;

/**
 * @author wuzheng.yk
 *         Date: 15/4/29
 *         Time: 16:24
 */
public class Aircon1 {
    IState state= StateImpl.OFF;//private改默认，删除getState()。
    //两个Action
    public void power(){//按power键
        state.power(this);
    }
    public void cool(){//按制冷键
        state.cool(this);
    }

    public void entry(){
        System.out.println("→" + this.state.name());
    }
    /**
     * ACCtrl的代码。
     */
    public static void main(String[] args){
        Aircon1 ac = new Aircon1();
        System.out.println("Current State:" + ac.state.name());
        ac.cool();
        ac.power();
        ac.cool();
        ac.cool();
        ac.power();
        ac.power();
        ac.power();

    }
}
