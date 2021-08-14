package com.tg.marketing.preferences.rest.portal.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webjars.NotFoundException;

import com.tg.marketing.preferences.rest.dto.CustomerDto;
import com.tg.marketing.preferences.rest.portal.service.UpdateMarketingPreferenceService;

@RestController
@RequestMapping("/customer/marketingPreferences")
public class UpdateMarketingPreferenceResource {

	private UpdateMarketingPreferenceService updateMarketingPreferenceService;

	public UpdateMarketingPreferenceResource(UpdateMarketingPreferenceService updateMarketingPreferenceService) {
		super();
		this.updateMarketingPreferenceService = updateMarketingPreferenceService;
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> save(@RequestBody CustomerDto customer) {
		try {
			CustomerDto savedCustomer = updateMarketingPreferenceService.save(customer);
			return ResponseEntity.ok().body(savedCustomer);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> update(@PathVariable int id, @RequestBody CustomerDto customer) {
		try {
			CustomerDto updatedCustomer = updateMarketingPreferenceService.update(id, customer);
			return ResponseEntity.ok().body(updatedCustomer);
		} catch (NotFoundException ne) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No record found for given customer id");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
