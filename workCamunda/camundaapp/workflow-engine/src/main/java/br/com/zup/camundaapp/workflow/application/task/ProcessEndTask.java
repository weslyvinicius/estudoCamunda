package br.com.zup.camundaapp.workflow.application.task;

import br.com.zup.camundaapp.workflow.application.Constants;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ProcessEndTask extends BaseTask implements JavaDelegate {

    private static Logger logger = LoggerFactory.getLogger(ProcessEndTask.class);

    @Override
    public void execute(DelegateExecution delegateExecution) {
        String customerId = getCustomerId(delegateExecution);
        Double amount = getAmount(delegateExecution);

        logger.info("End processing Customer: " + customerId + " Amount: " + amount);

        delegateExecution.setVariable(Constants.VarName.NEED_PAYMENT.getName(), amount > 20);
    }
}
