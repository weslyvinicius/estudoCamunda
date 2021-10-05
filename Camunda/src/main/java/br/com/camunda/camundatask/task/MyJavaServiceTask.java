package br.com.camunda.camundatask.task;

/*
    Created by Wesly Vinicius date:29/07/19
*/

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class MyJavaServiceTask implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Dentro do MyJavaService Task...");
    }
}
