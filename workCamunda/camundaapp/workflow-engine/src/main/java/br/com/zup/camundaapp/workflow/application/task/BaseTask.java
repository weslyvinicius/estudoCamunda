package br.com.zup.camundaapp.workflow.application.task;

import br.com.zup.camundaapp.workflow.application.Constants;
import org.camunda.bpm.engine.delegate.DelegateExecution;

public abstract class BaseTask {

    protected String getCustomerId(DelegateExecution delegateExecution) {
        return (String)delegateExecution.getVariable(Constants.VarName.CUSTOMER_ID.getName());
    }

    protected Double getAmount(DelegateExecution delegateExecution) {
        return (Double) delegateExecution.getVariable(Constants.VarName.AMOUNT.getName());
    }
}
