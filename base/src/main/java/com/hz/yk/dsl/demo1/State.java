package com.hz.yk.dsl.demo1;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 状态类记录了它会发送的命令及其相应的转换
 * @author wuzheng.yk
 * @date 2021/4/17
 */
public class State {

    private String name;
    private List<Command> actions = Lists.newArrayList();
    private Map<String, Transition> transitions = Maps.newHashMap();

    public State(String name) {
        this.name = name;
    }

    public void addTransition(Event event, State targetState) {
        assert null != targetState;
        transitions.put(event.getCode(), new Transition(this, targetState, event));
    }

    public Collection<State> getAllTargets() {
        final List<State> result = Lists.newArrayList();
        for (Transition t : transitions.values()) {
            result.add(t.getTarget());
        }
        return result;
    }

    public boolean hasTransition(String eventCode) {
        return transitions.containsKey(eventCode);
    }

    public State targetState(String eventCode) {
        return transitions.get(eventCode).getTarget();
    }

    public void executeActions(CommandChannel commandChannel) {
        for (Command action : actions) {
            commandChannel.send(action.getCode());
        }
    }

    public void addAction(Command command) {
        actions.add(command);
    }
}
