package com.hz.yk.yk.fsm;

import com.hz.yk.yk.fsm.condition.Condition;
import com.hz.yk.yk.fsm.event.IEvent;
import java.util.Map;


/**
 * 有限状态机
 * 
 * @author flyrain.zx
 * 
 */
public class FSM {
	private String initState;
	private String currentState;
	private Transtable table;
	private DefaultWorkFlowScope scope;
	public DefaultWorkFlowScope getScope(){
		return scope;
	}
	public <T extends Object> FSM(String initState, Transtable table,
			Map<String, T> input) {
		this.initState = initState;
		this.currentState = initState;
		this.table = table;
		scope = new DefaultWorkFlowScope();
		scope.setFSM(this);
		if (input != null)
			scope.putAll(input);

	}

	public String getInitState() {
		return initState;
	}

	public void setInitState(String initState) {
		this.initState = initState;
	}

	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	public Transtable getTable() {
		return table;
	}

	public void setTable(Transtable table) {
		this.table = table;
	}

	public void reset() {
		this.initState = currentState;
	}

	public String getState() {
		return this.currentState;
	}

	public String frie(String eventName) {

		TranstionItem item = table.findItem(currentState, eventName);
		if (item == null) {
			throw new RuntimeException("current state:" + currentState
					+ " is not  event:" + eventName);
		}

		scope.setCurrentEvent(eventName);
		Condition c = item.getCondition();
        IEvent action = item.getOnSuccAction();
		if (c == null) {
			return	notCondition(eventName, action);
		}
		
		if (c.isSuccess(scope)) {
			if(action!=null){
				action.action(scope);
			}
	
			this.currentState=item.getOnSuccState();
		}else{
			if(action!=null){
				action.action(scope);
			}
			
			this.currentState=item.getOnFailState();
		}
		return currentState;
	
	}
	private String notCondition(String eventName, IEvent action) {
		if(action!=null){
			action.action(scope);
		}
		return  findState(this.getCurrentState(), eventName);
	}

	private String findState(String state, String event) {
		String toState = table.findToState(event, state);
		if (toState == null) {
			this.reset();
			throw new RuntimeException("current state:" + currentState
					+ " is not  event:" + event);
		}
		return toState;
	}
}
