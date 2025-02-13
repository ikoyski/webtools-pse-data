package com.ikoyski.webtoolspsedata.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PseDataProviderFactory {

	public static final String PROVIDER_PHISIX = "Phisix";

	@Value("${provider.default}")
	private String PROVIDER_DEFAULT;

	@Value("${provider.phisix.baseUrl}")
	private String phisixBaseUrl;

	public void setPhisixBaseUrl(String phisixBaseUrl) {
		this.phisixBaseUrl = phisixBaseUrl;
	}

	public PseDataProviderBaseInterface createPsaDataProvider() {
		return createPsaDataProvider(PROVIDER_DEFAULT);
	}

	public PseDataProviderBaseInterface createPsaDataProvider(String type) {
		if (PROVIDER_PHISIX.equals(type)) {
			// using https://phisix-api3.appspot.com
			return new PseDataProviderPhisix(phisixBaseUrl);
		} else {
			throw new IllegalArgumentException("No such provider.");
		}
	}

}
