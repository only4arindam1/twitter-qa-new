package com.camunda.training;

import com.camunda.training.model.CustomTask;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class TaskController {


    private final RuntimeService runtimeService;
    private final TaskService taskService;
    private final ProcessEngine engine;


    public TaskController(RuntimeService runtimeService,
                          TaskService taskService, ProcessEngine engine) {
        this.runtimeService = runtimeService;
        this.taskService = taskService;
        this.engine = engine;
    }

    @RequestMapping(value = "/api/v1/tasks", method = RequestMethod.GET)
    @ResponseBody
    public List<CustomTask> getTasksForCurrentUsers(){
        List<Task> tasks= new ArrayList<>();
        tasks.addAll(taskService.createTaskQuery().processDefinitionKey("Twitter_QA").taskAssignee("demo").list());
        tasks.addAll(taskService.createTaskQuery().processDefinitionKey("Twitter_QA").taskCandidateGroup("management").list());

        List<CustomTask> customTasks = new ArrayList<>();
        tasks.forEach(
                t-> {
                    CustomTask  tk = new CustomTask();
                    tk.setTaskId(t.getId());
                    tk.setTaskName(t.getName());
                    customTasks.add(tk);
                }
        );

        return customTasks;
    }

    @GetMapping("/createInstance")
    public void startProcess(){

        Map<String, Object> variables = new HashMap<>();
        variables.put("approved",true);
        variables.put("content","first Tweet created by June");
        ProcessInstance instance =runtimeService.startProcessInstanceByKey("Twitter_QA",variables);

        System.out.println(instance.getProcessInstanceId());

    }

}
