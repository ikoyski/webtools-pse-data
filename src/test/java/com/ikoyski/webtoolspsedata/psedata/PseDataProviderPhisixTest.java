package com.ikoyski.webtoolspsedata.psedata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.ikoyski.webtoolspsedata.dto.PseDataResponse;
import com.ikoyski.webtoolspsedata.provider.PseDataProviderBaseInterface;
import com.ikoyski.webtoolspsedata.provider.PseDataProviderFactory;

@SpringBootTest
class PseDataProviderPhisixTest {
	
	@Value("${provider.phisix.baseUrl}")
	private String phisixBaseUrl;
	
	@Test
	@DisplayName("PsaDataProviderPhisixTest.psaDataProviderPhisixException()")
	void psaDataProviderIpApiException() {
		// given
		PseDataProviderFactory psaDataProviderFactory = new PseDataProviderFactory();
		psaDataProviderFactory.setPhisixBaseUrl("\\");
		PseDataProviderBaseInterface psaDataProvider = psaDataProviderFactory
				.createPsaDataProvider(PseDataProviderFactory.PROVIDER_PHISIX);

		// when and then
		Assertions.assertThrows(Exception.class, () -> psaDataProvider.stock());
	}

	@Test
	@DisplayName("PsaDataProviderPhisixTest.psaDataProviderPhisixSuccess2()")
	void psaDataProviderPhisixSuccess2() {
		// given
		final String symbol = "BDO";
		PseDataProviderFactory psaDataProviderFactory = new PseDataProviderFactory();
		psaDataProviderFactory.setPhisixBaseUrl(phisixBaseUrl);
		PseDataProviderBaseInterface psaDataProvider = psaDataProviderFactory
				.createPsaDataProvider(PseDataProviderFactory.PROVIDER_PHISIX);

		// when
		PseDataResponse psaDataResponse = psaDataProvider.stock(symbol);

		// then
		Assertions.assertNotNull(psaDataResponse);
	}

	@Test
	@DisplayName("PsaDataProviderPhisixTest.psaDataProviderPhisixException2()")
	void psaDataProviderIpApiException2() {
		// given
		final String symbol = "\\";
		PseDataProviderFactory psaDataProviderFactory = new PseDataProviderFactory();
		psaDataProviderFactory.setPhisixBaseUrl(phisixBaseUrl);
		PseDataProviderBaseInterface psaDataProvider = psaDataProviderFactory
				.createPsaDataProvider(PseDataProviderFactory.PROVIDER_PHISIX);

		// when and then
		Assertions.assertThrows(Exception.class, () -> psaDataProvider.stock(symbol));
	}

}
