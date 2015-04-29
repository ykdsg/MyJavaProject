package com.hz.yk.yk.fsm.condition;


import com.hz.yk.yk.fsm.WorkFlowScope;

public interface Condition<T extends WorkFlowScope> {
		/**
		 * 条件是否满足
		 * @return
		 */
		public boolean isSuccess(T scope);
}
