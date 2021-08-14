package com.tg.marketing.preferences.rest.portal.service;

import java.util.List;

import com.tg.marketing.preferences.rest.dto.CustomerDto;

public interface LookupMarketingPreferenceService {

	List<CustomerDto> findAll();
	
	CustomerDto findById(int id);

}
