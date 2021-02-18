package br.com.moraesit.rabbitmqproducer;

import br.com.moraesit.rabbitmqproducer.entity.Employee;
import br.com.moraesit.rabbitmqproducer.producer.EmployeeJsonProducer;
import br.com.moraesit.rabbitmqproducer.producer.FixedRateProducer;
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

	public RabbitmqProducerApplication(FixedRateProducer fixedRateProducer, EmployeeJsonProducer employeeJsonProducer) {
		this.fixedRateProducer = fixedRateProducer;
		this.employeeJsonProducer = employeeJsonProducer;
	}

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//helloRabbitProducer.sendHello("Rabbit MQ");
		for (int x = 1; x <= 10; x++) {
			employeeJsonProducer.sendMessage(new Employee(String.valueOf(x), "Employee ".concat(String.valueOf(x)), LocalDate.now()));
		}
	}
}
