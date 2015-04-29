package com.hz.yk.yk.fsm;

import java.util.Map;

import org.junit.Test;

import com.google.common.collect.Maps;

public class FSMTests {
	String STATE_LOCKED = "locked"; // 锁定状态
	String STATE_UNLOCKED = "unlocked";// 解锁状态

	// 事件定义
	String EVENT_COIN = "coin"; // 投币
	String EVENT_PASS = "pass";// 通过


	@Test
	public void test() {
		Transtable table = new Transtable();

		Map<String, Object> ctx = Maps.newHashMap();
		// ctx init
		 table.addTranstion(STATE_LOCKED, EVENT_COIN, STATE_UNLOCKED);
		 table.addTranstion(STATE_UNLOCKED, EVENT_PASS, STATE_LOCKED);

		FSM fsm = new FSM(STATE_LOCKED, table, ctx);

		System.out.println("current state :" + fsm.frie(EVENT_COIN));
		System.out.println("current state :" + fsm.frie(EVENT_PASS));
		
		System.out.println("current state :" + fsm.frie(EVENT_COIN));
		System.out.println("current state :" + fsm.frie(EVENT_PASS));

	}

}
