package net.zj.hz.yk.listener;

public class Listener1 implements DemoListener {
	public void demoEvent(DemoEvent de) {
		if(de.getState()!=null && de.getState().equals("open")){
			 System.out.println("钥匙拿出来");  
		}else{
			System.out.println("钥匙放好");  
		}
	}
}