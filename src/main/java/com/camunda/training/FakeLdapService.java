package com.camunda.training;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FakeLdapService {

    @Autowired
    ProcessEngine processEngine;

    public List<String> findAllSales() {
        processEngine.getRuntimeService();
        processEngine.getExternalTaskService();
        return Arrays.asList("demo","kermit", "gonzo", "fozzie");
    }
}
