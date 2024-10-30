package com.camunda.training.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class AskTDog implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String question = (String) delegateExecution.getVariable("questions");
        String businessKey = "T-DOG"+delegateExecution.getBusinessKey();
        delegateExecution.getProcessEngineServices()
                .getRuntimeService()
                .createMessageCorrelation("AskTDog")
                .setVariable("questions",question)
                .processInstanceBusinessKey(businessKey)
                .correlate();
    }
}
