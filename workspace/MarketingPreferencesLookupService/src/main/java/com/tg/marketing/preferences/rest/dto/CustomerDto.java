package com.tg.marketing.preferences.rest.dto;

import javax.validation.constraints.NotNull;

import com.tg.marketing.preferences.rest.enums.MarketingPreferences;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

	@NotNull
	private Integer id;
	@NotNull
	private String name;
	@NotNull
	private MarketingPreferences marketingPreferences;
}
