package br.com.moraesit.rabbitmqconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class FixedRateConsumer {

    private final RabbitTemplate rabbitTemplate;
    private final Logger log = LoggerFactory.getLogger(FixedRateConsumer.class);

    public FixedRateConsumer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = "course.fixedrate", concurrency = "3")
    public void listen(String message) {
        log.info("Consuming {} on Thread {}", message, Thread.currentThread().getName());

        try {
            Thread.sleep(ThreadLocalRandom.current().nextLong(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
