package br.com.moraesit.rabbitmqproducer.producer;

import br.com.moraesit.rabbitmqproducer.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class HumanResourceProducer {

    private final RabbitTemplate rabbitTemplate;
    private ObjectMapper objectMapper = new ObjectMapper();

    public HumanResourceProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Employee employee) {
        try {
            var json = objectMapper.writeValueAsString(employee);
            //rabbitTemplate.convertAndSend("course.employee", json);
            rabbitTemplate.convertAndSend("x.hr","", json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
