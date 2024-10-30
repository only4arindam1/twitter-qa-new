package com.camunda.training.delegate;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.ProcessInstance;

public class CalingDoSomething implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String question = (String) delegateExecution.getVariable("questions");
        String businessKey = delegateExecution.getBusinessKey();
        System.out.println("Inside CalingDoSomething JavaDelegate");
        RuntimeService rs = delegateExecution.getProcessEngine().getRuntimeService();
        String id = delegateExecution.getProcessInstanceId();

        rs.createMessageCorrelation("travelTime")
                .processInstanceId(id)
           //     .processInstanceBusinessKey(businessKey)
            //    .processInstanceVariableEquals("customerId", businessKey)
                .correlate();

       //I wont'e delegateExecution.getBusinessKey()
//        delegateExecution.getProcessEngineServices()
//                .getRuntimeService()
//                .createMessageCorrelation("travelTime")
//                .processInstanceBusinessKey(businessKey)
//                .processInstanceVariableEquals("customerId", businessKey)
//                .correlate();

    }
}
