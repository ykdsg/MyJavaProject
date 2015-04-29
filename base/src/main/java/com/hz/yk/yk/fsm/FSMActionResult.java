package com.hz.yk.yk.fsm;

public class FSMActionResult {
	private boolean succ;
	public boolean isSucc() {
		return succ;
	}
	public void setSucc(boolean succ) {
		this.succ = succ;
	}

	public String getCurrentEvent() {
		return currentEvent;
	}
	public void setCurrentEvent(String currentEvent) {
		this.currentEvent = currentEvent;
	}

	private String currentEvent;
	
}
