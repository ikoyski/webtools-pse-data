package com.ikoyski.webtools.psedata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.ikoyski.webtools.psedata.dto.PseDataResponse;
import com.ikoyski.webtools.psedata.provider.PseDataProviderBaseInterface;
import com.ikoyski.webtools.psedata.provider.PseDataProviderFactory;

@SpringBootTest
class PseDataProviderPhisixTest {
	
	@Value("${provider.phisix.baseUrl}")
	private String phisixBaseUrl;
	
	@Test
	@DisplayName("PseDataProviderPhisixTest.pseDataProviderPhisixException()")
	void pseDataProviderIpApiException() {
		// given
		PseDataProviderFactory pseDataProviderFactory = new PseDataProviderFactory();
		pseDataProviderFactory.setPhisixBaseUrl("\\");
		PseDataProviderBaseInterface pseDataProvider = pseDataProviderFactory
				.createPseDataProvider(PseDataProviderFactory.PROVIDER_PHISIX);

		// when and then
		Assertions.assertThrows(Exception.class, () -> pseDataProvider.stock());
	}

	@Test
	@DisplayName("PseDataProviderPhisixTest.pseDataProviderPhisixSuccess2()")
	void pseDataProviderPhisixSuccess2() {
		// given
		final String symbol = "BDO";
		PseDataProviderFactory pseDataProviderFactory = new PseDataProviderFactory();
		pseDataProviderFactory.setPhisixBaseUrl(phisixBaseUrl);
		PseDataProviderBaseInterface pseDataProvider = pseDataProviderFactory
				.createPseDataProvider(PseDataProviderFactory.PROVIDER_PHISIX);

		// when
		PseDataResponse pseDataResponse = pseDataProvider.stock(symbol);

		// then
		Assertions.assertNotNull(pseDataResponse);
	}

	@Test
	@DisplayName("PseDataProviderPhisixTest.pseDataProviderPhisixException2()")
	void pseDataProviderIpApiException2() {
		// given
		final String symbol = "\\";
		PseDataProviderFactory pseDataProviderFactory = new PseDataProviderFactory();
		pseDataProviderFactory.setPhisixBaseUrl(phisixBaseUrl);
		PseDataProviderBaseInterface pseDataProvider = pseDataProviderFactory
				.createPseDataProvider(PseDataProviderFactory.PROVIDER_PHISIX);

		// when and then
		Assertions.assertThrows(Exception.class, () -> pseDataProvider.stock(symbol));
	}

}
