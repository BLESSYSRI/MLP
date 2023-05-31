package com.truviq.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SettingVariable implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		// TODO Auto-generated method stub
		String name =(String)execution.getVariable("PartyName");
		
		if (name==null) {
			execution.setVariable("VAR", "ABC");
		}
		else {
			execution.setVariable("VAR", "XYZ");
		}
	}

}
