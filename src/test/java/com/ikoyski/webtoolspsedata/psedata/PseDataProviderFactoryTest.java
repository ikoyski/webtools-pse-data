package com.ikoyski.webtoolspsedata.psedata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ikoyski.webtoolspsedata.provider.PseDataProviderBaseInterface;
import com.ikoyski.webtoolspsedata.provider.PseDataProviderFactory;

@SpringBootTest
class PseDataProviderFactoryTest {

	@Test
	@DisplayName("PsaDataProviderFactoryTest.psaDataProviderFactorySuccess()")
	void psaDataProviderFactorySuccess() {
		// given
		PseDataProviderFactory pseDataProviderFactory = new PseDataProviderFactory();

		// when
		PseDataProviderBaseInterface psaDataProvider = pseDataProviderFactory
				.createPsaDataProvider(PseDataProviderFactory.PROVIDER_PHISIX);

		// then
		Assertions.assertNotNull(psaDataProvider);
	}

	@Test
	@DisplayName("PsaDataProviderFactoryTest.psaDataProviderFactoryException()")
	void psaDataProviderFactoryException() {
		// given
		PseDataProviderFactory pseDataProviderFactory = new PseDataProviderFactory();

		// when and then
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> pseDataProviderFactory.createPsaDataProvider("Dummy"));
	}
}
