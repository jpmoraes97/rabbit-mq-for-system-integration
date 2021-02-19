package br.com.moraesit.rabbitmqproducer.producer;

import br.com.moraesit.rabbitmqproducer.entity.Picture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class PictureProducerTwo {

    private final RabbitTemplate rabbitTemplate;
    private ObjectMapper objectMapper = new ObjectMapper();

    public PictureProducerTwo(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Picture picture) {
        var sb = new StringBuilder();
        sb.append(picture.getSource());
        sb.append(".");

        if (picture.getSize() > 4000)
            sb.append("large");
        else
            sb.append("small");
        sb.append(".");

        sb.append(picture.getType());

        try {
            var json = objectMapper.writeValueAsString(picture);
            var routingKey = sb.toString();
            rabbitTemplate.convertAndSend("x.picture2", routingKey, json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
