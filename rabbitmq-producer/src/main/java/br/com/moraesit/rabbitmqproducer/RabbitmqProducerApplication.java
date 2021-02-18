package br.com.moraesit.rabbitmqproducer;

import br.com.moraesit.rabbitmqproducer.producer.HelloRabbitProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqProducerApplication implements CommandLineRunner {

	private final HelloRabbitProducer helloRabbitProducer;

	public RabbitmqProducerApplication(HelloRabbitProducer helloRabbitProducer) {
		this.helloRabbitProducer = helloRabbitProducer;
	}

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		helloRabbitProducer.sendHello("Rabbit MQ");
	}
}
