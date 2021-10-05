package br.com.camunda.service;

/*
    Created by Wesly Vinicius date:19/07/19
*/

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkflowService {

    private RuntimeService runtimeService;

    @Autowired
    public WorkflowService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public String workflowStart(){

        System.out.println("Strat do processo - Service ");
        final String task_doSomething = runtimeService.startProcessInstanceByKey("task_doSomething").getProcessDefinitionId();

        //System.out.println("setando uma variavel, para o context do camunda..");

        System.out.println("Id process  - Service :"+task_doSomething);

        return task_doSomething;
    }

    public String javaServiceStart(){

        System.out.println("Strat do processo - Service ");
        final String javaService =
                runtimeService.startProcessInstanceByKey("myJavaService").getProcessDefinitionId();

        return javaService;
    }

    public String toUppercaseServiceStart(){

        System.out.println("Strat do processo - Service ");
        final String javaService =
                runtimeService.startProcessInstanceByKey("beanServiceTask").getProcessDefinitionId();

        return javaService;
    }

    public String javaExpressionStart(){

        System.out.println("Strat do processo - Service ");
        final String javaService =
                runtimeService.startProcessInstanceByKey("javaExpression").getProcessDefinitionId();

        return javaService;
    }
}
