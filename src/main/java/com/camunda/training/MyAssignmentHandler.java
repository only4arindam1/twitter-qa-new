package com.camunda.training;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

public class MyAssignmentHandler implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        delegateTask.setAssignee("demo");
        delegateTask.addCandidateUser("ari");
        delegateTask.addCandidateGroup("management");
    }
}
