package com.hz.yk.yk.fsm.event;


import com.hz.yk.yk.fsm.WorkFlowScope;

/**
 * 
 * @author flyrain.zx
 * 
 */
public abstract class AbstractDispatchEvent<T extends Object> extends
		AbstractEvent<T> {

	private static final String DISPATCH_OUTPUT = "DispatchOutput";
	private static final String DISPATCH_INPUT = "DispatchInput";

	@Override
	public void action(T eventSource) {

		try {
			WorkFlowScope scope = (WorkFlowScope) eventSource;
			Object input = scope.get(DISPATCH_INPUT);
            Object output = scope.get(DISPATCH_OUTPUT);
			this.action(input, output, eventSource);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public abstract void action(Object input, Object output,T scope);

}
