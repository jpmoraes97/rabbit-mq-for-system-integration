package br.com.moraesit.rabbitmqproducer;

import br.com.moraesit.rabbitmqproducer.entity.Message;
import br.com.moraesit.rabbitmqproducer.entity.Picture;
import br.com.moraesit.rabbitmqproducer.producer.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@EnableScheduling
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
	private final PictureProducerTwo pictureProducerTwo;
	private final MyPictureProducer myPictureProducer;

	private final EmailProducer emailProducer;

	public RabbitmqProducerApplication(FixedRateProducer fixedRateProducer, EmployeeJsonProducer employeeJsonProducer, HumanResourceProducer humanResourceProducer, PictureProducer pictureProducer, PictureProducerTwo pictureProducerTwo, MyPictureProducer myPictureProducer, EmailProducer emailProducer) {
		this.fixedRateProducer = fixedRateProducer;
		this.employeeJsonProducer = employeeJsonProducer;
		this.humanResourceProducer = humanResourceProducer;
		this.pictureProducer = pictureProducer;
		this.pictureProducerTwo = pictureProducerTwo;
		this.myPictureProducer = myPictureProducer;
		this.emailProducer = emailProducer;
	}

	private final List<String> SOURCES = List.of("mobile", "web");
	private final List<String> TYPES = List.of("jpg", "png", "svg");


	public static void main(String[] args) {
		SpringApplication.run(RabbitmqProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//helloRabbitProducer.sendHello("Rabbit MQ");
		for (int x = 1; x <= 10000; x++) {

//			employeeJsonProducer.sendMessage(new Employee(String.valueOf(x), "Employee ".concat(String.valueOf(x)), LocalDate.now()));
//
//			humanResourceProducer.sendMessage(new Employee(String.valueOf(x), "Employee ".concat(String.valueOf(x)), LocalDate.now()));


//			var picture = new Picture();
//			picture.setName("Picture " + x);
//			picture.setSize(ThreadLocalRandom.current().nextLong(1, 10001));
//			picture.setSource(SOURCES.get(x % SOURCES.size()));
//			picture.setType(TYPES.get(x % TYPES.size()));
//			pictureProducer.sendMessage(picture);


//			var picture = new Picture();
//			picture.setName("Picture " + x);
//			picture.setSize(ThreadLocalRandom.current().nextLong(9001, 10001));
//			picture.setSource(SOURCES.get(x % SOURCES.size()));
//			picture.setType(TYPES.get(x % TYPES.size()));
////			pictureProducerTwo.sendMessage(picture);
//
//			myPictureProducer.sendMessage(picture);

			Thread.sleep(1000);

			Message message = new Message();
			message.setTo("email".concat(String.valueOf(x).concat("@hotmail.com")));
			message.setSubject("Assunto do e-mail ".concat(String.valueOf(x)));

			emailProducer.sendMessage(message);

		}
	}
}
