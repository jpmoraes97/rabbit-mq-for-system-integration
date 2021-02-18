package br.com.moraesit.rabbitmqconsumer.consumer;

import br.com.moraesit.rabbitmqconsumer.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EmployeeJsonConsumer {

    private ObjectMapper objectMapper = new ObjectMapper();
    private Logger log = LoggerFactory.getLogger(EmployeeJsonConsumer.class);

    @RabbitListener(queues = "course.employee")
    public void consumeEmployee(String message) {
        try {
            var employee = objectMapper.readValue(message, Employee.class);
            log.info("Employee is {}", employee);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
