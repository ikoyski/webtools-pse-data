package com.ikoyski.webtools.psedata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ikoyski.webtools.psedata.provider.PseDataProviderBaseInterface;
import com.ikoyski.webtools.psedata.provider.PseDataProviderFactory;

@SpringBootTest
class PseDataProviderFactoryTest {

	@Autowired
	PseDataProviderFactory pseDataProviderFactory;

	@Test
	@DisplayName("PseDataProviderFactoryTest.pseDataProviderFactorySuccess()")
	void pseDataProviderFactorySuccess() {
		// when
		PseDataProviderBaseInterface pseDataProvider = pseDataProviderFactory.createPseDataProvider();

		// then
		Assertions.assertNotNull(pseDataProvider);
	}

	@Test
	@DisplayName("PseDataProviderFactoryTest.pseDataProviderFactoryException()")
	void pseDataProviderFactoryException() {
		// when and then
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> pseDataProviderFactory.createPseDataProvider("Dummy"));
	}
}
