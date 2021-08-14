package com.tg.marketing.preferences.rest.enums;

public enum MarketingPreferences {

	POST("post"), EMAIL("email"), SMS("sms");

	private String marketingPreferences;

	private MarketingPreferences(String marketingPreferences) {
		this.marketingPreferences = marketingPreferences;
	}

	public String getMarketingPreferences() {
		return marketingPreferences;
	}

}
