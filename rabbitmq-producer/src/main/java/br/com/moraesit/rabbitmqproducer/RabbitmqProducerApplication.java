package br.com.moraesit.rabbitmqproducer;

import br.com.moraesit.rabbitmqproducer.entity.Employee;
import br.com.moraesit.rabbitmqproducer.producer.EmployeeJsonProducer;
import br.com.moraesit.rabbitmqproducer.producer.FixedRateProducer;
import br.com.moraesit.rabbitmqproducer.producer.HumanResourceProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

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

	public RabbitmqProducerApplication(FixedRateProducer fixedRateProducer, EmployeeJsonProducer employeeJsonProducer, HumanResourceProducer humanResourceProducer) {
		this.fixedRateProducer = fixedRateProducer;
		this.employeeJsonProducer = employeeJsonProducer;
		this.humanResourceProducer = humanResourceProducer;
	}

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//helloRabbitProducer.sendHello("Rabbit MQ");
		for (int x = 1; x <= 10; x++) {
			//employeeJsonProducer.sendMessage(new Employee(String.valueOf(x), "Employee ".concat(String.valueOf(x)), LocalDate.now()));
			humanResourceProducer.sendMessage(new Employee(String.valueOf(x), "Employee ".concat(String.valueOf(x)), LocalDate.now()));
		}
	}
}
