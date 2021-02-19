package br.com.moraesit.rabbitmqproducer;

import br.com.moraesit.rabbitmqproducer.entity.Picture;
import br.com.moraesit.rabbitmqproducer.producer.EmployeeJsonProducer;
import br.com.moraesit.rabbitmqproducer.producer.FixedRateProducer;
import br.com.moraesit.rabbitmqproducer.producer.HumanResourceProducer;
import br.com.moraesit.rabbitmqproducer.producer.PictureProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

//@EnableScheduling
@SpringBootApplication
public class RabbitmqProducerApplication implements CommandLineRunner {

//	private final HelloRabbitProducer helloRabbitProducer;
//
//	public RabbitmqProducerApplication(HelloRabbitProducer helloRabbitProducer) {
//		this.helloRabbitProducer = helloRabbitProducer;
//	}

	private final FixedRateProducer fixedRateProducer;
	private final EmployeeJsonProducer employeeJsonProducer;
	private final HumanResourceProducer humanResourceProducer;
	private final PictureProducer pictureProducer;

	public RabbitmqProducerApplication(FixedRateProducer fixedRateProducer, EmployeeJsonProducer employeeJsonProducer, HumanResourceProducer humanResourceProducer, PictureProducer pictureProducer) {
		this.fixedRateProducer = fixedRateProducer;
		this.employeeJsonProducer = employeeJsonProducer;
		this.humanResourceProducer = humanResourceProducer;
		this.pictureProducer = pictureProducer;
	}

	private final List<String> SOURCES = List.of("mobile", "web");
	private final List<String> TYPES = List.of("jpg", "png", "svg");


	public static void main(String[] args) {
		SpringApplication.run(RabbitmqProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//helloRabbitProducer.sendHello("Rabbit MQ");
		for (int x = 1; x <= 10; x++) {

			//employeeJsonProducer.sendMessage(new Employee(String.valueOf(x), "Employee ".concat(String.valueOf(x)), LocalDate.now()));

			//humanResourceProducer.sendMessage(new Employee(String.valueOf(x), "Employee ".concat(String.valueOf(x)), LocalDate.now()));

			var picture = new Picture();
			picture.setName("Picture " + x);
			picture.setSize(ThreadLocalRandom.current().nextLong(1, 10001));
			picture.setSource(SOURCES.get(x % SOURCES.size()));
			picture.setType(TYPES.get(x % TYPES.size()));
			pictureProducer.sendMessage(picture);

		}
	}
}
