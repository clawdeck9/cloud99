package com.cluster9.billing;

import com.cluster9.billing.entities.Bill;
import com.cluster9.billing.entities.ProductItem;
import com.cluster9.billing.feign.CustomerRestService;
import com.cluster9.billing.feign.ProductRestService;
import com.cluster9.billing.jpa.BillRepo;
import com.cluster9.billing.model.Customer;
import com.cluster9.billing.model.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.hateoas.PagedModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
@EnableFeignClients
public class BillingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingApplication.class, args);
	}


	@Bean
	public CommandLineRunner start(RepositoryRestConfiguration rrc, CustomerRestService customerRestService, ProductRestService productRestService, BillRepo billRepo){
		// il faut noter ces mecanismes à part, soit ce sont des modèles universels soit ils sont spécifiques à Spring
		// mais dans tous les cas il faut identifier cette façon de faire.
		rrc.exposeIdsFor(Bill.class);
		return (args -> {
			System.out.println("get customers from the rest api @ customer-app:");
			try {
				Customer customer = customerRestService.getCustomerById(2L);
//				Customer customer = new Customer(null, "jojo", "jojo@myown.com");
				System.out.println(customer.toString());
				Bill bill = new Bill( customer, customer.getId());
				productRestService.getProducts("0", "5").forEach( p -> {
					System.out.println("product to add: "+p);
					Collection<ProductItem> pis = bill.getItems();
					pis.add(new ProductItem(null, bill, p, p.getId(), p.getPrice(), 10));
					bill.setItems(pis);
				});
				billRepo.save(bill);
				System.out.println("bill= "+bill.getId()+"  "+bill.getCustomer());
			} catch (Exception e) {
				e.printStackTrace();
			}


		});
	}

}
