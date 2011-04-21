package net.zj.hz.yk.listener;

import java.util.EventObject;

/**
 * 构造函数的参数传递了产生这个事件的事件源（比如各种控件），方法getSource用来获得这个事件源的引用。
 * 
 * @author "yangk"
 * @date 2011-4-13 下午07:01:36
 * 
 */
public class DemoEvent extends EventObject {
	String state="";//表示状态

	public DemoEvent(Object source, String state) {
		super(source);
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
}
