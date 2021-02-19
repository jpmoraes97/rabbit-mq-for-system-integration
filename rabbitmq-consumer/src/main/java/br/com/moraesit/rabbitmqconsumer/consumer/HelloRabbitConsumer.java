package br.com.moraesit.rabbitmqconsumer.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

//@Service
public class HelloRabbitConsumer {

    private final RabbitTemplate rabbitTemplate;

    public HelloRabbitConsumer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    //@RabbitListener(queues = "course.hello")
    public void listen(String message) {
        System.err.println("Consuming: " + message);
    }
}