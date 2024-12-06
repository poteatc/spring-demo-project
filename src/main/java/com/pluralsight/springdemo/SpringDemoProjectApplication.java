package com.pluralsight.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringDemoProjectApplication implements CommandLineRunner {

	@Autowired
	DealershipRepository dealershipRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World!!!");
		Iterable<Dealership> dealerships = dealershipRepository.findAll();

		for (Dealership d : dealerships) {
			System.out.printf("""
					Dealership:
						id: %d
						name: %s
						address: %s
						phone: %s
					""", d.getDealership_id(), d.getName(), d.getAddress(), d.getPhone());
		}
	}
}
