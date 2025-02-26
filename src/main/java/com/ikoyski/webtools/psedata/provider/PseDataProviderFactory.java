package com.ikoyski.webtools.psedata.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PseDataProviderFactory {

	public static final String PROVIDER_PHISIX = "PHISIX";

	@Autowired
	PseDataProviderPhisix pseDataProviderPhisix;

	@Value("${provider.default}")
	private String PROVIDER_DEFAULT;

	public PseDataProviderBaseInterface createPseDataProvider() {
		return createPseDataProvider(PROVIDER_DEFAULT);
	}

	public PseDataProviderBaseInterface createPseDataProvider(String type) {
		if (PROVIDER_PHISIX.equals(type)) {
			return pseDataProviderPhisix;
		} else {
			throw new IllegalArgumentException("No such provider.");
		}
	}

}