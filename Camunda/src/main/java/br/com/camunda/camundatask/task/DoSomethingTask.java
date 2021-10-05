package br.com.camunda.camundatask.task;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/*
    Created by Wesly Vinicius date:18/07/19
*/
@Slf4j
@Component
public class DoSomethingTask implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("dentro da Task do Camunda");


        log.info("setando uma variavel, para o context do camunda..");
        delegateExecution.setVariable("cpf","12345678");


    }
}
