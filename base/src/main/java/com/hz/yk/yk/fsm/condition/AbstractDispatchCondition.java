package com.hz.yk.yk.fsm.condition;


import com.hz.yk.yk.fsm.WorkFlowScope;

public  abstract class AbstractDispatchCondition<T extends WorkFlowScope> implements Condition<T>{
	
	@Override
	public boolean isSuccess(T scope) {
		try{
			Object input=scope.get("DispatchInput");
            Object outpt=scope.get("DispatchOutput");
            return doSuccess(input, outpt, scope);
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	public abstract boolean doSuccess(Object input,Object output,T scope);
}
