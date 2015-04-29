package com.hz.yk.yk.fsm;


import com.hz.yk.yk.fsm.condition.Condition;
import com.hz.yk.yk.fsm.event.IEvent;
import org.apache.commons.lang.StringUtils;

public class TranstionItemBuilder {
	private TranstionItem item=new TranstionItem();
	public   TranstionItemBuilder from(String state){
		item.setState(state);
		return this;
	}
	public TranstionItemBuilder to(String state){
		item.setToState(state);
		return this;
	}
	public TranstionItemBuilder event(String event){
		item.setEvent(event);
		return this;
	}
	public TranstionItemBuilder condition(Condition c){
		item.setCondition(c);
		return this;
	}
	 public TranstionItemBuilder onSucc(String succState){
		
			return onSucc(null, succState);
	 }
	public TranstionItemBuilder onSucc(IEvent<?> succAction,String succState){
			item.setOnSuccAction(succAction);
			item.setOnSuccState(succState);
		
			return this;
	}
	public TranstionItemBuilder onFail(String failState){
		item.setOnFailState(failState);
		return this;
	}
	public TranstionItemBuilder onFail(IEvent failAction,String failState){
		item.setOnFailAction(failAction);
		item.setOnFailState(failState);
		return this;
	}
	
	public TranstionItem builder(){
			if(StringUtils.isBlank(item.getToState())){
				item.setToState(item.getOnSuccState());
			}
			return item;
	}
	
	
}
