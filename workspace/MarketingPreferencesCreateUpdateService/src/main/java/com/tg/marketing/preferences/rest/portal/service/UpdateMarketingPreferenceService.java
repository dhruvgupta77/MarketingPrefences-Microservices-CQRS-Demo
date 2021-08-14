package com.tg.marketing.preferences.rest.portal.service;

import com.tg.marketing.preferences.rest.dto.CustomerDto;

public interface UpdateMarketingPreferenceService {

	CustomerDto save(CustomerDto customer);

	CustomerDto update(int id, CustomerDto customer);
		
}
