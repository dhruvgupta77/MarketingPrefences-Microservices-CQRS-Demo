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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.webjars.NotFoundException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tg.marketing.preferences.rest.portal.repository.CustomerRepository;
import com.tg.marketing.preferences.rest.portal.service.UpdateMarketingPreferenceService;
import com.tg.marketing.preferences.rest.portal.util.BuildTestData;

@RunWith(SpringRunner.class)
@WebMvcTest(UpdateMarketingPreferenceResource.class)
class UpdateMarketingPreferenceResourceTest {

	private static final String URI = "/customer/marketingPreferences";

	@Autowired
	private MockMvc mvc;

	@MockBean
	private UpdateMarketingPreferenceService updateMarketingPreferenceService;

	@MockBean
	private CustomerRepository repository;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void saveMarketingPreferencesSuccess() throws Exception {

		Mockito.when(updateMarketingPreferenceService.save(BuildTestData.TEST_CUSTOMER))
				.thenReturn(BuildTestData.TEST_CUSTOMER);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post(URI)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(BuildTestData.TEST_CUSTOMER));

		mvc.perform(mockRequest).andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
				.andExpect(jsonPath("$.id", is(21))).andExpect(jsonPath("$.name", is("TEST")))
				.andExpect(jsonPath("$.marketingPreferences", is("SMS")));
	}

	@Test
	void updateMarketingPreferencesSuccess() throws Exception {
		Mockito.when(updateMarketingPreferenceService.update(BuildTestData.TEST_CUSTOMER.getId(),
				BuildTestData.TEST_CUSTOMER)).thenReturn(BuildTestData.TEST_CUSTOMER_DATA);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.put(URI + "/" + BuildTestData.TEST_CUSTOMER.getId()).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(BuildTestData.TEST_CUSTOMER));

		mvc.perform(mockRequest).andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
				.andExpect(jsonPath("$.id", is(21))).andExpect(jsonPath("$.name", is("TEST")))
				.andExpect(jsonPath("$.marketingPreferences", is("EMAIL")));
	}

	@Test
	void updatePatientRecordForNullId() throws Exception {

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.put(URI + "/" + BuildTestData.NULL_CUSTOMER_ID.getId()).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(BuildTestData.NULL_CUSTOMER_ID));

		mvc.perform(mockRequest).andExpect(status().isBadRequest());
	}

	@Test
	void updatePatientRecord_recordNotFound() throws Exception {
		Mockito.when(updateMarketingPreferenceService.update(BuildTestData.NOT_FOUND_CUSTOMER.getId(),
				BuildTestData.NOT_FOUND_CUSTOMER))
				.thenThrow(new NotFoundException(
						"** Customer not found for id :: " + BuildTestData.TEST_CUSTOMER.getId()));

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.put(URI + "/" + BuildTestData.NOT_FOUND_CUSTOMER.getId()).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(BuildTestData.NOT_FOUND_CUSTOMER));

		mvc.perform(mockRequest).andExpect(status().isNotFound());
	}

}
