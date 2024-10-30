package com.camunda.training.delegate;

import com.camunda.training.model.RequestContext;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;

public class TweetDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        VariableMap variables = Variables.createVariables();
        try {

         //   ObjectValue requestContextJsonValue = delegateExecution.getVariableTyped("reqContext");
       //     RequestContext reqContext = (RequestContext) requestContextJsonValue.getValue();
         //   reqContext.setSpecificWitness(true);
       //     variables.putValue("reqContext", reqContext);


            // complete the external task
        //    System.out.println("Inside loanGranter" + reqContext);
            //delegateExecution.(externalTask, variables);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
