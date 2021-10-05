package br.com.camunda.camundatask.task;

/*
    Created by Wesly Vinicius date:30/07/19
*/

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class ToUppercaseTask implements JavaDelegate {

    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Dentro da ToUppercaseTask ..");

        String var = (String) execution.getVariable("input");

        System.out.println("Valor var1: "+var);
        var = var.toUpperCase();

        execution.setVariable("input", var);

        System.out.println();
        System.out.println("Valor var2: "+var);

    }

}
