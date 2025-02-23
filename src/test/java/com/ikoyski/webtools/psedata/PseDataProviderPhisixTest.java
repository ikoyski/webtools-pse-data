package com.ikoyski.webtools.psedata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.ikoyski.webtools.psedata.dto.PseDataResponse;
import com.ikoyski.webtools.psedata.provider.PseDataProviderBaseInterface;
import com.ikoyski.webtools.psedata.provider.PseDataProviderFactory;

@SpringBootTest
@ActiveProfiles("test")
class PseDataProviderPhisixTest {

	@Autowired
	PseDataProviderFactory pseDataProviderFactory;

	@Test
	@DisplayName("PseDataProviderPhisixTest.pseDataProviderPhisixSuccess()")
	void pseDataProviderPhisixSuccess() {
		// given
		PseDataProviderBaseInterface pseDataProvider = pseDataProviderFactory
				.createPseDataProvider(PseDataProviderFactory.PROVIDER_PHISIX);

		// when
		PseDataResponse pseDataResponse = pseDataProvider.stock();

		// then
		Assertions.assertNotNull(pseDataResponse);
	}

	@Test
	@DisplayName("PseDataProviderPhisixTest.pseDataProviderPhisixSuccess2()")
	void pseDataProviderPhisixSuccess2() {
		// given
		final String symbol = "BDO";
		PseDataProviderBaseInterface pseDataProvider = pseDataProviderFactory
				.createPseDataProvider(PseDataProviderFactory.PROVIDER_PHISIX);

		// when
		PseDataResponse pseDataResponse = pseDataProvider.stock(symbol);

		// then
		Assertions.assertNotNull(pseDataResponse);
	}

	@Test
	@DisplayName("PseDataProviderPhisixTest.pseDataProviderPhisixException()")
	void pseDataProviderPhisixException() {
		// given
		final String symbol = "*";
		PseDataProviderBaseInterface pseDataProvider = pseDataProviderFactory
				.createPseDataProvider(PseDataProviderFactory.PROVIDER_PHISIX);

		// when and then
		Assertions.assertThrows(Exception.class, () -> pseDataProvider.stock(symbol));
	}
	
}
