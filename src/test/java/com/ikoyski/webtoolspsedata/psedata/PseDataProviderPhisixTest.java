package com.ikoyski.webtoolspsedata.psedata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ikoyski.webtoolspsedata.dto.PseDataResponse;
import com.ikoyski.webtoolspsedata.provider.PseDataProviderBaseInterface;
import com.ikoyski.webtoolspsedata.provider.PseDataProviderFactory;

@SpringBootTest
class PseDataProviderPhisixTest {

	@Test
	@DisplayName("PsaDataProviderPhisixTest.psaDataProviderPhisixSuccess()")
	void psaDataProviderPhisixSuccess() {
		// given
		final String symbol = "BDO";
		PseDataProviderFactory psaDataProviderFactory = new PseDataProviderFactory();
		PseDataProviderBaseInterface psaDataProvider = psaDataProviderFactory
				.createPsaDataProvider(PseDataProviderFactory.PROVIDER_PHISIX);

		// when
		PseDataResponse psaDataResponse = psaDataProvider.getData(symbol);

		// then
		Assertions.assertNotNull(psaDataResponse);
	}

	@Test
	@DisplayName("PsaDataProviderPhisixTest.psaDataProviderIpApiException()")
	void psaDataProviderIpApiException() {
		// given
		final String symbol = "\\";
		PseDataProviderFactory psaDataProviderFactory = new PseDataProviderFactory();
		PseDataProviderBaseInterface psaDataProvider = psaDataProviderFactory
				.createPsaDataProvider(PseDataProviderFactory.PROVIDER_PHISIX);

		// when and then
		Assertions.assertThrows(Exception.class, () -> psaDataProvider.getData(symbol));
	}

}
