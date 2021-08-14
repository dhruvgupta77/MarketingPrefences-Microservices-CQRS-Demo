package com.tg.marketing.preferences.rest.builder;

import com.tg.marketing.preferences.rest.dto.CustomerDto;
import com.tg.marketing.preferences.rest.entity.Customer;

public class CustomerBuilder {
	
	private CustomerBuilder() {} 

	public static Customer buildCustomer(CustomerDto customer) {
		return Customer.builder().id(customer.getId()).name(customer.getName())
				.marketingPreferences(customer.getMarketingPreferences()).build();
	}

	public static CustomerDto buildCustomerDto(Customer customer) {
		return CustomerDto.builder().id(customer.getId()).name(customer.getName())
				.marketingPreferences(customer.getMarketingPreferences()).build();
	}

}
