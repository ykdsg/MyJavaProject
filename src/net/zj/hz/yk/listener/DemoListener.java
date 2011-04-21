package net.zj.hz.yk.listener;

import java.util.EventListener;

/**
 * 定义新的事件监听接口，该接口继承自EventListener；该接口包含对DemeEvent事件的处理程序：
 * 
 * @author "yangk"
 * @date 2011-4-13 下午07:01:51
 * 
 */
public interface DemoListener extends EventListener {
	public void demoEvent(DemoEvent dm);
}
