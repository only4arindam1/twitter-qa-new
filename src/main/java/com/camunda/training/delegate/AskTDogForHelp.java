package com.camunda.training.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class AskTDogForHelp implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String question = (String) delegateExecution.getVariable("questions");
        String businessKey = "T-DOG-"+delegateExecution.getBusinessKey();

        delegateExecution.getProcessEngineServices()
                .getRuntimeService()
                .createMessageCorrelation("AskTDogNew")
                .setVariable("parentId",delegateExecution.getBusinessKey())
                .processInstanceBusinessKey(businessKey)
                .correlate();
        System.out.println(" Enter AskTDogForHelp task ");
    }
}
