package br.com.camunda.camundatask.task;

/*
    Created by Wesly Vinicius date:26/08/19
*/

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MyTask implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("Executando MyTask...");

        // setando variavel
        delegateExecution.setVariable("cpf","12345678");


    }
}
