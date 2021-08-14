package com.tg.marketing.preferences;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.tg.marketing.preferences.rest.entity.Customer;
import com.tg.marketing.preferences.rest.portal.repository.CustomerRepository;
import com.tg.marketing.preferences.util.HelperUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableJpaRepositories
public class MarketingPreferencesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketingPreferencesApplication.class, args);
	}

	@Autowired
	private CustomerRepository customerRepository;

	@Bean
	CommandLineRunner runner() {
		return args -> {
			List<Customer> customers = customerRepository.findAll();
			if (customers.isEmpty()) {
				log.info("******* Inserting Customers to DB *******");
				customerRepository.saveAll(HelperUtil.customerSupplier.get());
			} else {
				log.info("******* Customers stored in DB Size :: {}", customers.size());
				log.info("******* Customers stored in DB :: {}", customers);
			}

		};
	}

}
