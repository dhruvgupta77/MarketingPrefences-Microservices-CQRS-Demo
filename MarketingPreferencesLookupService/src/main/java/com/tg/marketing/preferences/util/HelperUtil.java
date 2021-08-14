package com.tg.marketing.preferences.util;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import com.tg.marketing.preferences.rest.entity.Customer;
import com.tg.marketing.preferences.rest.enums.MarketingPreferences;

public class HelperUtil {

	private HelperUtil() {
	}

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

}
