package br.com.moraesit.rabbitmqconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

//@Service
public class FixedRateConsumer {

    private final RabbitTemplate rabbitTemplate;
    private final Logger log = LoggerFactory.getLogger(FixedRateConsumer.class);

    public FixedRateConsumer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = "course.fixedrate")
    public void listen(String message) {
        System.err.println("Consuming: " + message);
        log.info("Consuming {}", message);
    }
}
