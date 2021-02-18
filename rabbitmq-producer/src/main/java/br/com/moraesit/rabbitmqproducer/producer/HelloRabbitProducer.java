package br.com.moraesit.rabbitmqproducer.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class HelloRabbitProducer {

    private final RabbitTemplate rabbitTemplate;

    public HelloRabbitProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendHello(String name) {
        //@@ 2 parameters ->  queue name, message!!
        rabbitTemplate.convertAndSend("course.hello", "Hello ".concat(name));
    }
}