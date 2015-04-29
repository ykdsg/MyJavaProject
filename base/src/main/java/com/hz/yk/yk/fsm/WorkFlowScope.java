package com.hz.yk.yk.fsm;
/**
 * 工作流上下文
 * @author flyrain.zx
 *
 */
public interface WorkFlowScope {
	
	public void setFSM(FSM fsm);

	public FSM getFSM();
	
	public void setCurrentEvent(String event);
	public String getCurrentEvent();
	public String getCurrentState();

	public String nextState();

	public void setNextState(String state);

	public <V> void put(String key, V value);

	public <T> T get(String key);

}
