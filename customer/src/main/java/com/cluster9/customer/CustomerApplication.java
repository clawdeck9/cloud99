package com.cluster9.customer;

import com.cluster9.customer.entities.Customer;
import com.cluster9.customer.jpa.CustomerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepo cr) {
		return args -> {
			cr.save(new Customer(null, "alpha", "alpha@cloud.org"));
			cr.save(new Customer(null, "beta", "beta@cloud.org"));
			cr.save(new Customer(null, "gamma", "gamma@cloud.org"));
			System.out.println("customers : ");
			cr.findAll().forEach(c -> System.out.println(c.toString()));
		};
	}
}
