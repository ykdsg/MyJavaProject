package com.hz.yk.dsl.demo1;

/**
 * 书上的格兰特小姐例子
 * @author wuzheng.yk
 * @date 2021/4/17
 */
public class GrantMain {

    /**
     * 配置整个状态机的流转逻辑
     */
    private void buildStateMachine() {
        Event doorClosed = new Event("doorClosed", "D1CL");
        Event drawerOpened = new Event("drawerOpened", "D2OP");
        Event lightOn = new Event("lightOn", "L1ON");
        Event doorOpened = new Event("doorOpened", "D1OP");
        Event panelClosed = new Event("panelClosed", "PNCL");

        Command unlockPanelCmd = new Command("unlockPanel", "PNUL");
        Command lockPanelCmd = new Command("lockPanel", "PNLK");
        Command lockDoorCmd = new Command("lockDoor", "D1LK");
        Command unlockDoorCmd = new Command("unlockDoor", "D1UL");

        State idle = new State("idle");
        State activeState = new State("active");
        State waitingForLightState = new State("waitingForLight");
        State waitingForDrawerState = new State("waitingForDrawer");
        State unlockedPanelState = new State("unlockedPanel");

        StateMachine machine = new StateMachine(idle);

        idle.addTransition(doorClosed, activeState);
        idle.addAction(unlockDoorCmd);
        idle.addAction(lockPanelCmd);

        activeState.addTransition(drawerOpened, waitingForLightState);
        activeState.addTransition(lightOn, waitingForDrawerState);

        waitingForLightState.addTransition(lightOn, unlockedPanelState);
        waitingForDrawerState.addTransition(drawerOpened, unlockedPanelState);

        unlockedPanelState.addAction(unlockPanelCmd);
        unlockedPanelState.addAction(lockDoorCmd);
        unlockedPanelState.addTransition(panelClosed, idle);

        machine.addResetEvents(doorOpened);
    }

}
