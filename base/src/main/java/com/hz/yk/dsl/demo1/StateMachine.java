package com.hz.yk.dsl.demo1;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author wuzheng.yk
 * @date 2021/4/17
 */
public class StateMachine {

    private State start;

    /**
     * 为了处理重置事件 ，在状态机上保存了一个列表
     */
    private final List<Event> resetEvents = Lists.newArrayList();

    public StateMachine(State start) {
        this.start = start;
    }

    //从这个状态可以到达的状态机里的任何状态
    public Collection<State> getStates() {
        List<State> result = Lists.newArrayList();
        collectStates(result, start);
        return result;
    }

    private void collectStates(Collection<State> result, State start) {
        if (result.contains(start)) {
            return;
        }
        result.add(start);
        for (State next : start.getAllTargets()) {
            collectStates(result, next);
        }
    }

    public void addResetEvents(Event... events) {
        resetEvents.addAll(Arrays.asList(events));
    }

    public State getStart() {
        return start;
    }

    public boolean isResetEvent(String eventCode) {
        return resetEventCodes().contains(eventCode);
    }

    private List<String> resetEventCodes() {
        List<String> result = new ArrayList<String>();
        for (Event event : resetEvents) {
            result.add(event.getCode());
        }
        return result;
    }
}
