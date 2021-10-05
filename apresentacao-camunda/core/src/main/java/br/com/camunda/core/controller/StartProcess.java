package br.com.camunda.core.controller;


import org.camunda.bpm.engine.RuntimeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/camunda/startProcess")
public class StartProcess {

    private final RuntimeService runtimeService;

    public StartProcess(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @PostMapping
    public String startProcesso(){
        return runtimeService.startProcessInstanceByKey("completude").getProcessInstanceId();
    }
}
