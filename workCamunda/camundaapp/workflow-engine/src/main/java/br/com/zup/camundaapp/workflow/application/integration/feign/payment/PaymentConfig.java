package br.com.zup.camundaapp.workflow.application.integration.feign.payment;

import br.com.zup.camundaapp.workflow.application.conf.ObjectMapperUtils;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {

    @Bean
    public PaymentApi paymentApi() {
        return Feign.builder()
                .encoder(new JacksonEncoder(ObjectMapperUtils.getObjectMapper()))
                .decoder(new JacksonDecoder(ObjectMapperUtils.getObjectMapper()))
                .logLevel(feign.Logger.Level.FULL)
                .target(PaymentApi.class, "http://localhost:8080");

    }


}
