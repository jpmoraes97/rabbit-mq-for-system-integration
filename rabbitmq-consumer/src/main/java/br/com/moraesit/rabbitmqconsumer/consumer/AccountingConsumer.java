package br.com.moraesit.rabbitmqconsumer.consumer;

import br.com.moraesit.rabbitmqconsumer.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

//@Service
public class AccountingConsumer {

    private ObjectMapper objectMapper = new ObjectMapper();
    private Logger log = LoggerFactory.getLogger(AccountingConsumer.class);

    //@RabbitListener(queues = "q.hr.accounting")
    public void consumeEmployee(String message) {
        Employee employee = null;
        try {
            employee = objectMapper.readValue(message, Employee.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        log.info("On account, employee is {}", employee);
    }

}
