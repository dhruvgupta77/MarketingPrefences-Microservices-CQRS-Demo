package com.tg.marketing.preferences.rest.portal.util;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import com.tg.marketing.preferences.rest.dto.CustomerDto;
import com.tg.marketing.preferences.rest.entity.Customer;
import com.tg.marketing.preferences.rest.enums.MarketingPreferences;

public class BuildTestData {

	public static Supplier<List<CustomerDto>> customerDtoSupplier = () -> Arrays.asList(
			CustomerDto.builder().id(1).name("Aman").marketingPreferences(MarketingPreferences.POST).build(),
			CustomerDto.builder().id(2).name("Peter").marketingPreferences(MarketingPreferences.EMAIL).build(),
			CustomerDto.builder().id(3).name("Patrick").marketingPreferences(MarketingPreferences.SMS).build(),
			CustomerDto.builder().id(4).name("Jan").marketingPreferences(MarketingPreferences.EMAIL).build(),
			CustomerDto.builder().id(5).name("Steve").marketingPreferences(MarketingPreferences.POST).build(),
			CustomerDto.builder().id(6).name("Robert").marketingPreferences(MarketingPreferences.SMS).build(),
			CustomerDto.builder().id(7).name("David").marketingPreferences(MarketingPreferences.EMAIL).build(),
			CustomerDto.builder().id(8).name("Mike").marketingPreferences(MarketingPreferences.SMS).build(),
			CustomerDto.builder().id(9).name("Richard").marketingPreferences(MarketingPreferences.EMAIL).build(),
			CustomerDto.builder().id(10).name("Paul").marketingPreferences(MarketingPreferences.SMS).build(),
			CustomerDto.builder().id(11).name("Chris").marketingPreferences(MarketingPreferences.POST).build());

	public static CustomerDto TEST_CUSTOMER = CustomerDto.builder().id(21).name("TEST")
			.marketingPreferences(MarketingPreferences.SMS).build();

	public static CustomerDto TEST_CUSTOMER_DATA = CustomerDto.builder().id(21).name("TEST")
			.marketingPreferences(MarketingPreferences.EMAIL).build();

	public static CustomerDto NULL_CUSTOMER_ID = CustomerDto.builder().id(null).name("TEST")
			.marketingPreferences(MarketingPreferences.EMAIL).build();

	public static CustomerDto NOT_FOUND_CUSTOMER = CustomerDto.builder().id(100).name("TEST")
			.marketingPreferences(MarketingPreferences.SMS).build();

	public static Supplier<List<Customer>> customerSupplier = () -> Arrays.asList(
			Customer.builder().id(1).name("Aman").marketingPreferences(MarketingPreferences.POST).build(),
			Customer.builder().id(2).name("Peter").marketingPreferences(MarketingPreferences.EMAIL).build(),
			Customer.builder().id(3).name("Patrick").marketingPreferences(MarketingPreferences.SMS).build(),
			Customer.builder().id(4).name("Jan").marketingPreferences(MarketingPreferences.EMAIL).build(),
			Customer.builder().id(5).name("Steve").marketingPreferences(MarketingPreferences.POST).build(),
			Customer.builder().id(6).name("Robert").marketingPreferences(MarketingPreferences.SMS).build(),
			Customer.builder().id(7).name("David").marketingPreferences(MarketingPreferences.EMAIL).build(),
			Customer.builder().id(8).name("Mike").marketingPreferences(MarketingPreferences.SMS).build(),
			Customer.builder().id(9).name("Richard").marketingPreferences(MarketingPreferences.EMAIL).build(),
			Customer.builder().id(10).name("Paul").marketingPreferences(MarketingPreferences.SMS).build(),
			Customer.builder().id(11).name("Chris").marketingPreferences(MarketingPreferences.POST).build());

	public static Customer TEST_CUSTOMER_ENTITY = Customer.builder().id(21).name("TEST")
			.marketingPreferences(MarketingPreferences.SMS).build();

	public static Customer TEST_CUSTOMER_DATA_ENTITY = Customer.builder().id(21).name("TEST")
			.marketingPreferences(MarketingPreferences.EMAIL).build();

	public static Customer NULL_CUSTOMER_ID_ENTITY = Customer.builder().id(null).name("TEST")
			.marketingPreferences(MarketingPreferences.EMAIL).build();

	public static Customer NOT_FOUND_CUSTOMER_ENTITY = Customer.builder().id(100).name("TEST")
			.marketingPreferences(MarketingPreferences.SMS).build();

}
