package com.camunda.training.controller;

import camundajar.impl.com.google.gson.JsonElement;
import camundajar.impl.com.google.gson.JsonObject;
import com.camunda.training.model.RequestContext;
import com.camunda.training.model.Tweet;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.camunda.bpm.engine.variable.value.SerializationDataFormat;
import org.camunda.bpm.engine.variable.value.TypedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class TwiterReviewController {

    private final ProcessEngine processEngine;

    @Autowired
    RestTemplate restTemplate;

    public TwiterReviewController(ProcessEngine processEngine) {
        this.processEngine = processEngine;
    }

    @PostMapping("/process/create")
    public  void startProcess(@RequestBody RequestContext reqContext){
        RuntimeService runtimeService = processEngine.getRuntimeService();
       RequestContext context = new RequestContext();
       context.setRequestId(reqContext.getRequestId());
       context.setWitnessId(reqContext.getWitnessId());
       ObjectValue contextJson =Variables
                                        .objectValue(context)
                                        .serializationDataFormat(Variables.SerializationDataFormats.JSON)
                                        .create();

       HashMap variables = new HashMap();
       //variables.put()
        variables.put("reqContext",contextJson);

       ProcessInstance instance =runtimeService.startProcessInstanceByKey("twitter_qa",variables);
       System.out.println(instance.getProcessInstanceId());

    }
    @PostMapping("/startProcess")
    public void startWitnessProcess(@RequestBody String requestContext){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RequestContext requestContext1 = new RequestContext();

        HttpEntity<String> entity = new HttpEntity(requestContext,headers);

        restTemplate.postForObject("http://localhost:8080/engine-rest/process-definition/key/witnessProcess/start",entity,String.class);
    }
}
