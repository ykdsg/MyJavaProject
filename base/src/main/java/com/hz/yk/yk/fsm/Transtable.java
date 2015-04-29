package com.hz.yk.yk.fsm;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

/**
 * 迁移表 
 * @author flyrain.zx
 * 
 */
public class Transtable {
	private String defaultAutoEvent ;
	private HashSet<String> endStatus;
	
	public void setEndStatus(String... endStatus) {
		if(endStatus==null)return;
		this.endStatus=Sets.newHashSet(endStatus);
		
	}
	public boolean isEndStatus(String status){
		if(StringUtils.isBlank(status)){
			System.out.println("status is blank");
		}
		return this.endStatus.contains(status);
	}
	
	public HashSet<String> getEndStatus() {
		return endStatus;
	}



	public String getDefaultAutoEvent() {
		return defaultAutoEvent;
	}

	public void setDefaultAutoEvent(String defaultAutoEvent) {
		this.defaultAutoEvent = defaultAutoEvent;
	}


	private Multimap<String, TranstionItem> eventStateMap = ArrayListMultimap
			.create();
	private Multimap<String, TranstionItem> stateMap = ArrayListMultimap
			.create();

	public void addTranstion(String state, String event, String toState) {
		// TODO validate
		this.addTranstion(new TranstionItem(state, event, toState));
	}
	
	public TranstionItemBuilder from(String state){
		return new TranstionItemBuilder().from(state);
	}
	public void add(TranstionItemBuilder builder){
		this.addTranstion(builder.builder());
	}
	public void addTranstion(TranstionItem item) {

		if (item == null) {
			return;
		}
		if(StringUtils.isNotBlank(defaultAutoEvent)){
			item.setEvent(defaultAutoEvent);
		}
		this.stateMap.put(item.getState(), item);

		this.eventStateMap.put(item.getEvent(), item);
	}
	
	public Collection<TranstionItem> getTranstionItem(String event) {
		return eventStateMap.get(event);
	}
	public TranstionItem findItem(String state,String event){
		Collection<TranstionItem> items=   stateMap.get(state);
		for(TranstionItem item:items){
			if(item.getEvent().equals(event)){
				return item;
			}
		}
		return null;
	}
	
	public String findToState(String event,String currentState){
		Collection<TranstionItem> items=getTranstionItem(event);
		for(TranstionItem item :items){
			if(StringUtils.equals(currentState, item.getState())){
				return item.getToState();
			}
		}
		return null;
	}


	public List<String> getStateListByEvent(String event){
		Collection<TranstionItem> items=	this.getTranstionItem(event);
		List<String> stateList=Lists.newArrayList();
		for(TranstionItem item:items){
			stateList.add(item.getState());
		}
		return stateList;
	}
	

	public boolean isHasState(String state) {
		if(StringUtils.isBlank(state)){
			return false;
		}
		if (this.stateMap.containsKey(state)) {
			return true;
		}
		return false;
	}

}
