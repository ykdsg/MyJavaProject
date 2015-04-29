package com.hz.yk.yk.fsm.notify;


import com.hz.yk.yk.fsm.event.IEvent;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.lang.StringUtils;

/**
 * 事件通知中心
 * 注册主题消息
 * 注册事件
 * 事件分发
 * @author flyrain.zx
 *
 */
public enum EventNotifyCenter {
	instace;

	private final ConcurrentHashMap<String, CopyOnWriteArrayList<IEvent<?>>> obseverList = new ConcurrentHashMap<String, CopyOnWriteArrayList<IEvent<?>>>();

	public synchronized void register(String msgCode, IEvent<?> event) {
		if (StringUtils.isBlank(msgCode) || event == null) {
			return;
		}
		CopyOnWriteArrayList<IEvent<?>> eventList = obseverList.get(msgCode);
		if (eventList != null) {
			if (!eventList.contains(event)) {
				eventList.add(event);
			}
		} else {
			eventList = new CopyOnWriteArrayList<IEvent<?>>();
			eventList.add(event);
			obseverList.put(msgCode, eventList);
		}
	}

	public void remove(String msgCode) {
		obseverList.remove(msgCode);
	}

	public void remove(IEvent<?> event) {

	}

	public void remove(String msgCode, IEvent<?> event) {

	}

	public void removeAll() {
		obseverList.clear();

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  <T extends Object> void postNotify(String msgCode, T sourceData) {
		if (StringUtils.isBlank(msgCode) || null == sourceData) {
			return;
		}
		CopyOnWriteArrayList<IEvent<?>> eventList = obseverList.get(msgCode);
		if (eventList == null) {
			return;
		}
		for (IEvent event : eventList) {
			event.action(sourceData);
		}
	}

	public void postNotifyWithEventSource(String msgCode, Object sourceData,
			Object sourceEvent) {
		throw new UnsupportedOperationException();
	}

}
