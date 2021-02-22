package com.cluster9.producinventory;

import com.cluster9.producinventory.entities.Product;
import com.cluster9.producinventory.jpa.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProducInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducInventoryApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepo pr){
		return ( args -> {
			pr.save(new Product(null, "Toaster", 20, 50));
			pr.save(new Product(null, "Eraser", 30, 60));
			pr.save(new Product(null, "Burner", 40, 70));
			pr.findAll().forEach(product -> System.out.println(product.toString()));
		});
	}

}
