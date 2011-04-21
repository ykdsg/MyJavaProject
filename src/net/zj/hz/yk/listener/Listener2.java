package net.zj.hz.yk.listener;

public class Listener2 implements DemoListener {
	public void demoEvent(DemoEvent de) {
		if(de.getState()!=null && de.getState().equals("open")){
			 System.out.println("门打开了");  
		}else{
			System.out.println("门关好了");  
		}
	}
}