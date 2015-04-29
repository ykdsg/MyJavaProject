package com.hz.yk.yk.fsm;

import java.util.Map;

import com.google.common.collect.Maps;

public class DefaultWorkFlowScope implements WorkFlowScope{
   private FSM fsm;
   private String nextState;
   private String currentEvent;
   private Map<String,Object> data=Maps.newHashMap();
  
   public void setFSM(FSM fsm){
	   this.fsm=fsm;
   }
	@Override
	public FSM getFSM() {
		
		return fsm;
	}

	@Override
	public String getCurrentState() {
	
		return fsm.getCurrentState();
	}

	@Override
	public String nextState() {
	
		return nextState;
	}

	@Override
	public void setNextState(String state) {
		this.nextState=state;
		
	}
	public <V extends Object> void putAll(Map<String, V> data){
		this.data.putAll(data);
	}
	@Override
	public <V extends Object> void put(String key, V value) {
		this.data.put(key, value);
		
	}
	@Override
	public <T> T get(String key) {
		
		return data.get(key)==null?null:(T)data.get(key);
	}
	@Override
	public void setCurrentEvent(String event) {
		this.currentEvent=event;
		
	}
	@Override
	public String getCurrentEvent() {
		return this.currentEvent;
	}


}
