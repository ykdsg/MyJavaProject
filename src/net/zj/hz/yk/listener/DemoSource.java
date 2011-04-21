package net.zj.hz.yk.listener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/**
 * 事件源对象，在这里你可以把它想象成一个控制开门关门的遥控器，
 * 
 * @author "yangk"
 * @date 2011-4-13 下午07:54:08
 * 
 */
public class DemoSource {
	private ArrayList listeners = new ArrayList();
	DemoListener dl;

	public DemoSource() {

	}

	public void addDemoListener(DemoListener dl) {
		listeners.add(dl);
	}

	/**
	 * 移除事件
	 * 
	 * @param listener
	 *            DoorListener
	 */
	public void removeDoorListener(DemoListener listener) {
		if (listeners == null)
			return;
		listeners.remove(listener);
	}

	/**
	 * 触发开门事件
	 */
	protected void fireWorkspaceOpened() {
		if (listeners == null)
			return;
		DemoEvent event = new DemoEvent(this, "open");
		notifyListeners(event);
	}

	/**
	 * 触发关门事件
	 */
	protected void fireWorkspaceClosed() {
		if (listeners == null)
			return;
		DemoEvent event = new DemoEvent(this, "closed");
		notifyListenersReverser(event);
	}

	/**
	 * 触发事件的方法，顺序通知所有的Listener：事件发生了，调用相应的处理函数（回调函数）
	 * 
	 * @author "yangk"
	 * @date 2011-4-13 下午07:07:13
	 */
	public void notifyListeners(DemoEvent event) {
		doEvent(event, listeners);
	}

	/**
	 * 触发事件的方法，倒序序通知所有的Listener：事件发生了，调用相应的处理函数（回调函数）
	 * 
	 * @author "yangk"
	 * @date 2011-4-13 下午08:20:59
	 * @param event
	 */
	public void notifyListenersReverser(DemoEvent event) {
		List reverserListeners = listeners;
		Collections.reverse(reverserListeners);
		doEvent(event, reverserListeners);
	}

	public void doEvent(DemoEvent event, List alisteners) {
		Iterator iter = alisteners.iterator();
		while (iter.hasNext()) {
			dl = (DemoListener) iter.next();
			dl.demoEvent(event);
		}
	}
}
