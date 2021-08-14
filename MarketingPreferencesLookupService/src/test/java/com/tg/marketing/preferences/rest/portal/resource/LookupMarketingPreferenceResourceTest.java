package com.tg.marketing.preferences.rest.portal.resource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.webjars.NotFoundException;

import com.tg.marketing.preferences.rest.portal.repository.CustomerRepository;
import com.tg.marketing.preferences.rest.portal.service.LookupMarketingPreferenceService;
import com.tg.marketing.preferences.rest.portal.util.BuildTestData;

@RunWith(SpringRunner.class)
@WebMvcTest(LookupMarketingPreferenceResource.class)
class LookupMarketingPreferenceResourceTest {

	private static final String URI = "/customer/marketingPreferences";

	@Autowired
	private MockMvc mvc;

	@MockBean
	private LookupMarketingPreferenceService updateMarketingPreferenceService;

	@MockBean
	private CustomerRepository repository;

	@Test
	void findAllSuccess() throws Exception {
		Mockito.when(updateMarketingPreferenceService.findAll()).thenReturn(BuildTestData.customerDtoSupplier.get());

		mvc.perform(MockMvcRequestBuilders.get(URI)).andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
				.andExpect(jsonPath("$[0].id", is(1))).andExpect(jsonPath("$[0].marketingPreferences", is("POST")));
	}

	@Test
	void findByIdSuccess() throws Exception {

		Mockito.when(updateMarketingPreferenceService.findById(BuildTestData.TEST_CUSTOMER.getId()))
				.thenReturn(BuildTestData.TEST_CUSTOMER);

		mvc.perform(MockMvcRequestBuilders.get(URI + "/" + BuildTestData.TEST_CUSTOMER.getId()))
				.andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
				.andExpect(jsonPath("$.marketingPreferences", is("SMS")));
	}

	@Test
	void findByIdFailure() throws Exception {

		Mockito.when(updateMarketingPreferenceService.findById(BuildTestData.NOT_FOUND_CUSTOMER.getId()))
				.thenThrow(new NotFoundException("no record found"));

		mvc.perform(MockMvcRequestBuilders.get(URI + "/" + BuildTestData.NOT_FOUND_CUSTOMER.getId()))
				.andExpect(status().isNotFound());
	}

}
