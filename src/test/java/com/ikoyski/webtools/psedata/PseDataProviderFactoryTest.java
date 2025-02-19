package com.ikoyski.webtools.psedata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ikoyski.webtools.psedata.provider.PseDataProviderBaseInterface;
import com.ikoyski.webtools.psedata.provider.PseDataProviderFactory;

@SpringBootTest
class PseDataProviderFactoryTest {

	@Test
	@DisplayName("PseDataProviderFactoryTest.pseDataProviderFactorySuccess()")
	void pseDataProviderFactorySuccess() {
		// given
		PseDataProviderFactory pseDataProviderFactory = new PseDataProviderFactory();

		// when
		PseDataProviderBaseInterface pseDataProvider = pseDataProviderFactory
				.createPseDataProvider(PseDataProviderFactory.PROVIDER_PHISIX);

		// then
		Assertions.assertNotNull(pseDataProvider);
	}

	@Test
	@DisplayName("PseDataProviderFactoryTest.pseDataProviderFactoryException()")
	void pseDataProviderFactoryException() {
		// given
		PseDataProviderFactory pseDataProviderFactory = new PseDataProviderFactory();

		// when and then
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> pseDataProviderFactory.createPseDataProvider("Dummy"));
	}
}
