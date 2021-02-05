package com.hz.yk.statemachine.builder;

import com.hz.yk.statemachine.StateMachine;
import com.hz.yk.statemachine.impl.StateMachineException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wuzheng.yk
 * @date 2021/2/1
 */
public class StateMachineFactory {

    static Map<String /* machineId */, StateMachine> stateMachineMap = new ConcurrentHashMap<>();

    public static <S, E, C> void register(StateMachine<S, E, C> stateMachine) {
        final String machineId = stateMachine.getMachineId();
        if (stateMachineMap.get(machineId) != null) {
            throw new StateMachineException(
                    "The state machine with id [" + machineId + "] is already built, no need to build again");
        }
        stateMachineMap.put(stateMachine.getMachineId(), stateMachine);
    }
}
