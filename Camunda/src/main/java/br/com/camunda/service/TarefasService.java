package br.com.camunda.service;

/*
    Created by Wesly Vinicius date:19/07/19
*/

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefasService {

    private RuntimeService runtimeService;

    @Autowired
    public TarefasService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public String tarefasStart(){

         return  runtimeService.startProcessInstanceByKey("tarefas").getProcessDefinitionId();

    }
}
