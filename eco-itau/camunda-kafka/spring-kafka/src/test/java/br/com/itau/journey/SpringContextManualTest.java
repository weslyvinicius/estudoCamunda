package br.com.itau.journey;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaApplication.class)
public class SpringContextManualTest {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
