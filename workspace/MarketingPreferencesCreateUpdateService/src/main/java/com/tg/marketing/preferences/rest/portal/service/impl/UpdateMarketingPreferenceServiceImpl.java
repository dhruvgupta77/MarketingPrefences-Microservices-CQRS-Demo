package com.tg.marketing.preferences.rest.portal.service.impl;

import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.tg.marketing.preferences.rest.builder.CustomerBuilder;
import com.tg.marketing.preferences.rest.dto.CustomerDto;
import com.tg.marketing.preferences.rest.portal.repository.CustomerRepository;
import com.tg.marketing.preferences.rest.portal.service.UpdateMarketingPreferenceService;

@Service
public class UpdateMarketingPreferenceServiceImpl implements UpdateMarketingPreferenceService {

	private CustomerRepository repository;

	public UpdateMarketingPreferenceServiceImpl(CustomerRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public CustomerDto save(CustomerDto customer) {
		return CustomerBuilder.buildCustomerDto(repository.save(CustomerBuilder.buildCustomer(customer)));
	}

	@Override
	public CustomerDto update(int id, CustomerDto customer) {
		repository.findById(id).orElseThrow(() -> new NotFoundException("** Customer not found for id :: " + id));

		customer.setId(id);
		return CustomerBuilder.buildCustomerDto(repository.save(CustomerBuilder.buildCustomer(customer)));
	}

}
