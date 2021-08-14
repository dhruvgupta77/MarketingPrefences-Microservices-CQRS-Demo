package com.tg.marketing.preferences.rest.portal.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.tg.marketing.preferences.rest.builder.CustomerBuilder;
import com.tg.marketing.preferences.rest.dto.CustomerDto;
import com.tg.marketing.preferences.rest.portal.repository.CustomerRepository;
import com.tg.marketing.preferences.rest.portal.service.LookupMarketingPreferenceService;

@Service
public class LookupMarketingPreferenceServiceImpl implements LookupMarketingPreferenceService {

	private CustomerRepository repository;

	public LookupMarketingPreferenceServiceImpl(CustomerRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<CustomerDto> findAll() {
		return repository.findAll().stream().map(CustomerBuilder::buildCustomerDto).collect(Collectors.toList());
	}

	@Override
	public CustomerDto findById(int id) {
		return CustomerBuilder.buildCustomerDto(repository.findById(id)
				.orElseThrow(() -> new NotFoundException("** Customer not found for id :: " + id)));
	}

}
