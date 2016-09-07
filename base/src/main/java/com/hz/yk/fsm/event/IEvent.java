package com.hz.yk.fsm.event;

/**
 * 
 * @author flyrain.zx
 *
 */
public interface IEvent<T extends Object> {
	
	public void setEventCode(String eventCode);
	public String getEventCode();

	public void action(T sourceData);
}
