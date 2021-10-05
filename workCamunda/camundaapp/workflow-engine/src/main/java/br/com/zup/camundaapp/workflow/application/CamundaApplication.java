package br.com.zup.camundaapp.workflow.application;


import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

@SpringBootApplication
@EnableProcessApplication
public class CamundaApplication {
    private static Logger logger = LoggerFactory.getLogger(CamundaApplication.class);

    public static void main(String... args) throws UnknownHostException {
        final ConfigurableApplicationContext app = SpringApplication.run(CamundaApplication.class, args);

        String applicationName = app.getEnvironment().getProperty("spring.application.name");
        String contextPath = (app.getEnvironment().getProperty("server.contextPath") == null) ? "/"
                : app.getEnvironment().getProperty("server.contextPath");
        String port = app.getEnvironment().getProperty("server.port");
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        String applicationVersion = app.getEnvironment().getProperty("server.version");
        String currentTime = LocalDateTime.now().toString();

        logger.info(String.format("|\n" +
                        "|------------------------------------------------------------\n" +
                        "|Custom '%s' is running! Access URLs:\n" +
                        "|   Local:           http://127.0.0.1:%s%s\n" +
                        "|   External:        http://%s:%s%s\n" +
                        "|   Version:         %s\n" +
                        "|   Current time:    %s\n" +
                        "|------------------------------------------------------------",
                applicationName, port, contextPath, hostAddress, port, contextPath, applicationVersion,
                currentTime));
    }
}

