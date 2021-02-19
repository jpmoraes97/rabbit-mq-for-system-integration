package br.com.moraesit.rabbitmqproducer.producer;

import br.com.moraesit.rabbitmqproducer.entity.Picture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class PictureProducer {

    private final RabbitTemplate rabbitTemplate;
    private ObjectMapper objectMapper = new ObjectMapper();

    public PictureProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Picture picture) {
        try {
            var json = objectMapper.writeValueAsString(picture);
            rabbitTemplate.convertAndSend("x.picture", picture.getType(), json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
