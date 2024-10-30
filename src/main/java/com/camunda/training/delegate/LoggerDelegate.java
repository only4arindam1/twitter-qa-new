package com.camunda.training.delegate;

import camundajar.impl.com.google.gson.Gson;
import com.camunda.training.model.Message;
import com.camunda.training.model.ProcessVariables;
import com.camunda.training.model.Questions;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class LoggerDelegate implements JavaDelegate {

    @Autowired
    RestTemplate restTemplate;


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Inside Logger Delegate");
        String question = (String) delegateExecution.getVariable("questions");
        String businessKey = delegateExecution.getBusinessKey();
//        delegateExecution.getProcessEngineServices()
//                .getRuntimeService()
//                .createMessageCorrelation("doSomething")
//                .processInstanceBusinessKey(businessKey)
//                .correlate();
        String url = "http://localhost:8080/engine-rest/message";
        Questions questions = new Questions();
        questions.setType("String");
        questions.setValue("Checking the Event Subprocess  event");
        Message msg = new Message();
        ProcessVariables variables = new ProcessVariables();
        variables.setQuestions(questions);
        msg.setBusinessKey(businessKey);
        msg.setMessageName("travelTime");
        msg.setProcessVariables(variables);
        Gson gson = new Gson();
        String msgJson =gson.toJson(msg);
        System.out.println("msg in json"+ msgJson);
        restTemplate = new RestTemplate();
        HttpEntity<Message> request = new HttpEntity<>(msg);
        ResponseEntity response = restTemplate.postForObject(url,request, ResponseEntity.class);
       // delegateExecution.setVariable("isEscalation",true);
        System.out.println("Before Correlate Message"+ msgJson);
//                delegateExecution.getProcessEngineServices()
//                .getRuntimeService()
//                .createMessageCorrelation("doSomething")
//                .processInstanceBusinessKey(businessKey)
//                .correlate();
    }
}
