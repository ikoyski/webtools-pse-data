package com.ikoyski.webtools.psedata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.ikoyski.webtools.psedata.dto.PseDataResponse;
import com.ikoyski.webtools.psedata.service.PseDataService;

@SpringBootTest
@ActiveProfiles("test")
class PseDataServiceTest {

	@Autowired
	private PseDataService pseDataService;

	@Test
	@DisplayName("PseDataServiceTest.getPseDataSuccess()")
	void getPseDataSuccess() {
		// given
		final String NAME = "Ayala Corporation Non-Voting Perpetual Preferred A Shares";

		// when
		PseDataResponse pseDataResponse = pseDataService.stock();

		// then
		Assertions.assertEquals(pseDataResponse.getStock().get(0).getName(), NAME);
	}

	@Test
	@DisplayName("PseDataServiceTest.getPseDataSuccess2()")
	void getPseDataSuccess2() {
		// given
		final String SYMBOL = "BPI";
		final String NAME = "Bank of the Philippine Islands";

		// when
		PseDataResponse pseDataResponse = pseDataService.stock(SYMBOL);

		// then
		Assertions.assertEquals(pseDataResponse.getStock().get(0).getName(), NAME);
	}

}
