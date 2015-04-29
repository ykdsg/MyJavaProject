package com.hz.yk.yk.fsm;


import com.hz.yk.yk.fsm.condition.Condition;
import com.hz.yk.yk.fsm.event.IEvent;

/**
 * 迁移表配置项
 * @author flyrain.zx
 *
 */
public class TranstionItem {
	
	public TranstionItem(){}
	
	public TranstionItem(String state, String event, String toState) {
		this.state = state;
		this.event = event;
		this.toState = toState;
	}
	private Condition condition;
	private IEvent onSuccAction;
	private IEvent  onFailAction;
	private String onSuccState;
	private String onFailState;
	private String state;

	public String getState() {
		return state;
	}

	public Condition  getCondition() {
		return condition;
	}

	public void setCondition(Condition  condition) {
		this.condition = condition;
	}

	public IEvent  getOnSuccAction() {
		return onSuccAction;
	}

	public void setOnSuccAction(IEvent  onSuccAction) {
		this.onSuccAction = onSuccAction;
	}

	public IEvent  getOnFailAction() {
		return onFailAction;
	}

	public void setOnFailAction(IEvent  onFailAction) {
		this.onFailAction = onFailAction;
	}

	public String getOnSuccState() {
		return onSuccState;
	}

	public void setOnSuccState(String onSuccState) {
		this.onSuccState = onSuccState;
	}

	public String getOnFailState() {
		return onFailState;
	}

	public void setOnFailState(String onFailState) {
		this.onFailState = onFailState;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getToState() {
		return toState;
	}

	public void setToState(String toState) {
		this.toState = toState;
	}

	private String event;
	private String toState;
}
