package br.com.camunda.endpoint;

/*
    Created by Wesly Vinicius date:19/07/19
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.camunda.service.WorkflowService;

@RestController
@RequestMapping("/workflow")
public class WorkflowController {

    private WorkflowService workflowService;

    @Autowired
    public WorkflowController(WorkflowService workflowService) {
        this.workflowService = workflowService;
    }

    @PostMapping("/start")
    @ResponseStatus(HttpStatus.OK)
    public String startWorkflow(){

        System.out.println("Strat do processo - Controller ");

        String idProcess = workflowService.workflowStart();

        System.out.println("Id do processo - Controller "+idProcess);

        return idProcess;
    }

    @PostMapping("/javaservice")
    @ResponseStatus(HttpStatus.OK)
    public String startJavaServiceTask(){

        System.out.println("Strat do processo - Controller ");

        String idProcess = workflowService.javaServiceStart();

        System.out.println("Id do processo - Controller "+idProcess);

        return idProcess;
    }

    @PostMapping("/touppercase")
    @ResponseStatus(HttpStatus.OK)
    public String toUppercaseTask(){

        System.out.println("Strat do processo - Controller ");

        String idProcess = workflowService.toUppercaseServiceStart();

        System.out.println("Id do processo - Controller "+idProcess);

        return idProcess;
    }

    @PostMapping("/javaexpression")
    @ResponseStatus(HttpStatus.OK)
    public String javaExpressionTask(){

        System.out.println("Strat do processo - Controller ");

        String idProcess = workflowService.javaExpressionStart();


        return idProcess;
    }
}
