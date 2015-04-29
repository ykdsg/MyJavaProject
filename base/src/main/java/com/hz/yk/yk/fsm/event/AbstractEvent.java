package com.hz.yk.yk.fsm.event;
/**
 * 
 * @author flyrain.zx
 *
 */
public abstract   class AbstractEvent<T extends Object> implements IEvent<T>{
	private String eventCode;
	@Override
	public void setEventCode(String eventCode){
		this.eventCode=eventCode;
	}
	@Override
	public String getEventCode() {
		return eventCode;
	}



}
