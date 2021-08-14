package com.tg.marketing.preferences.rest.portal.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webjars.NotFoundException;

import com.tg.marketing.preferences.rest.dto.CustomerDto;
import com.tg.marketing.preferences.rest.portal.service.LookupMarketingPreferenceService;

@RestController
@RequestMapping("/customer/marketingPreferences")
public class LookupMarketingPreferenceResource {

	private LookupMarketingPreferenceService updateMarketingPreferenceService;

	public LookupMarketingPreferenceResource(LookupMarketingPreferenceService updateMarketingPreferenceService) {
		super();
		this.updateMarketingPreferenceService = updateMarketingPreferenceService;
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> findAll() {
		try {
			List<CustomerDto> customerList = updateMarketingPreferenceService.findAll();
			if (customerList.isEmpty())
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body("List is empty");
			return ResponseEntity.ok().body(customerList);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> findById(@PathVariable int id) {
		try {
			CustomerDto customer = updateMarketingPreferenceService.findById(id);
			return ResponseEntity.ok().body(customer);
		} catch (NotFoundException ne) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No record found for given customer id");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
