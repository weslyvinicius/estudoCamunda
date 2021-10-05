package br.com.zup.camundaapp.workflow.application.integration.feign.payment;

import br.com.zup.camundaapp.workflow.application.domain.PaymentRequest;
import br.com.zup.camundaapp.workflow.application.domain.PaymentResponse;
import feign.Headers;
import feign.RequestLine;

public interface PaymentApi {

    @RequestLine("POST /payment")
    @Headers("Content-Type: application/json")
    PaymentResponse payment(PaymentRequest request);
}
