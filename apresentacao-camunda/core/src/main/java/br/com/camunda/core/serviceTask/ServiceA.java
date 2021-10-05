package br.com.camunda.core.serviceTask;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class ServiceA implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Thread.sleep(10 * 1000);
    }
}
