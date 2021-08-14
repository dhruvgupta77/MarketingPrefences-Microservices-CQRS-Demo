package com.tg.marketing.preferences.rest.portal.service.impl;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.webjars.NotFoundException;

import com.tg.marketing.preferences.rest.dto.CustomerDto;
import com.tg.marketing.preferences.rest.portal.repository.CustomerRepository;
import com.tg.marketing.preferences.rest.portal.service.LookupMarketingPreferenceService;
import com.tg.marketing.preferences.rest.portal.util.BuildTestData;

@RunWith(SpringRunner.class)
@WebMvcTest(LookupMarketingPreferenceServiceImpl.class)
class LookupMarketingPreferenceServiceImplTest {

	@Autowired
	private LookupMarketingPreferenceService updateMarketingPreferenceService;

	@MockBean
	private CustomerRepository repository;

	@Test
	void findAllSuccess() throws Exception {
		Mockito.when(repository.findAll()).thenReturn(BuildTestData.customerSupplier.get());
		List<CustomerDto> customerList = updateMarketingPreferenceService.findAll();

		assertNotNull(customerList);
		assertEquals(customerList.size(), BuildTestData.customerSupplier.get().size());

	}

	@Test
	void findByIdSuccess() throws Exception {
		Mockito.when(repository.findById(BuildTestData.TEST_CUSTOMER_ENTITY.getId()))
				.thenReturn(Optional.of(BuildTestData.TEST_CUSTOMER_ENTITY));
		CustomerDto customer = updateMarketingPreferenceService.findById(BuildTestData.TEST_CUSTOMER_ENTITY.getId());

		assertNotNull(customer);
		assertEquals(customer.getId(), BuildTestData.TEST_CUSTOMER_ENTITY.getId());
		assertEquals(customer.getMarketingPreferences(), BuildTestData.TEST_CUSTOMER_ENTITY.getMarketingPreferences());
		assertEquals(customer.getName(), BuildTestData.TEST_CUSTOMER_ENTITY.getName());
	}

	@Test
	void findByIdFailure() throws Exception {
		Mockito.when(repository.findById(BuildTestData.NOT_FOUND_CUSTOMER_ENTITY.getId()))
				.thenThrow(new NotFoundException("no record found"));

		assertThatExceptionOfType(NotFoundException.class).isThrownBy(() -> {
			updateMarketingPreferenceService.findById(BuildTestData.NOT_FOUND_CUSTOMER_ENTITY.getId());
		});

	}
}