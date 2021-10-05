package br.com.camunda.restapi.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/teste")
public class StartProjeto {

    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());


   // private final KafkaTemplate kafkaTemplate;

//    //public StartProjeto(KafkaTemplate kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }

    @PostMapping
    public void startProcesso(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForLocation("http://localhost:8080/camunda/startProcess", null);

    }

//    @PostMapping("publish-callback/{message}")
//    public String messageProduceCallBack(@PathVariable String message){
//
//        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(Topics.FIRST_TOPIC, message);
//        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
//
//            @Override
//            public void onSuccess(final SendResult<String, String> message) {
//                LOGGER.info("sent message= " + message + " with offset= " + message.getRecordMetadata().offset());
//            }
//
//            @Override
//            public void onFailure(final Throwable throwable) {
//                LOGGER.error("unable to send message= " + message, throwable);
//            }
//        });
//
//        return "Messagem enviado com sucesso";
//    }
}
