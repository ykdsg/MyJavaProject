package com.hz.yk.reactor.core.publisher;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wuzheng.yk
 * @date 2019-04-26
 */
public class MyEventSource {

    private List<MyEventListener> listeners;

    public MyEventSource() {
        this.listeners = new ArrayList<>();
    }

    public void register(MyEventListener listener) {    // 1
        listeners.add(listener);
    }

    public void newEvent(MyEvent event) {
        for (MyEventListener listener : listeners) {
            listener.onNewEvent(event);     // 2
        }
    }

    public void eventStopped() {
        for (MyEventListener listener : listeners) {
            listener.onEventStopped();      // 3
        }
    }

    public static class MyEvent {   // 4

        private Date   timeStemp;
        private String message;

        public MyEvent() {
        }

        public MyEvent(Date timeStemp, String message) {
            this.timeStemp = timeStemp;
            this.message = message;
        }

        public Date getTimeStemp() {
            return timeStemp;
        }

        public void setTimeStemp(Date timeStemp) {
            this.timeStemp = timeStemp;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
