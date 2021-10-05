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

import br.com.camunda.service.TarefasService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/tarefas")
@Slf4j
public class TarefasController {

    private TarefasService tarefasService;

    @Autowired
    public TarefasController(TarefasService tarefasService) {
        this.tarefasService = tarefasService;
    }

    @PostMapping("/myServiceTask")
    @ResponseStatus(HttpStatus.OK)
    public String startWorkflow(){

        String idProcess = tarefasService.tarefasStart();

       log.info("Id do processo - Controller "+idProcess);

        return idProcess;
    }


}
