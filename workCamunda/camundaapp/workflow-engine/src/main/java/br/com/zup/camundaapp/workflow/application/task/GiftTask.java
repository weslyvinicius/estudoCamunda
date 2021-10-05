package br.com.zup.camundaapp.workflow.application.task;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class GiftTask extends BaseTask implements JavaDelegate {

    private static Logger logger = LoggerFactory.getLogger(GiftTask.class);

    @Override
    public void execute(DelegateExecution delegateExecution) {
        logger.info("It was a gift for customer: " +
                getCustomerId(delegateExecution) +
                " at process: " + delegateExecution.getProcessInstanceId());
    }
}
