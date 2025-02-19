package com.ikoyski.webtools.psedata;

import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.ikoyski.webtools.psedata.dto.PseDataResponse;
import com.ikoyski.webtools.psedata.dto.Stock;
import com.ikoyski.webtools.psedata.provider.PseDataProviderBaseInterface;
import com.ikoyski.webtools.psedata.service.PseDataService;

@SpringBootTest
@ActiveProfiles("test")
class PseDataServiceTest {

	@Autowired
	private PseDataService pseDataService;

	@MockitoBean
	PseDataProviderBaseInterface pseDataProvider;

	@Test
	@DisplayName("PseDataServiceTest.getPseDataSuccess()")
	void getPseDataSuccess() {
		// given
		final String NAME = "Ayala Corporation Non-Voting Perpetual Preferred A Shares";
		PseDataResponse pseDataResponse = new PseDataResponse();
		pseDataResponse.setStock(new ArrayList<Stock>());
		pseDataResponse.getStock().add(new Stock());
		pseDataResponse.getStock().get(0).setName(NAME);
		doReturn(pseDataResponse).when(pseDataProvider).stock();

		// when
		PseDataResponse pseDataResponse2 = pseDataService.stock();

		// then
		Assertions.assertEquals(pseDataResponse2.getStock().get(0).getName(), NAME);
	}

	@Test
	@DisplayName("PseDataServiceTest.getPseDataSuccess2()")
	void getPseDataSuccess2() {
		// given
		final String SYMBOL = "BPI";
		final String NAME = "Bank of the Philippine Islands";
		PseDataResponse pseDataResponse = new PseDataResponse();
		pseDataResponse.setStock(new ArrayList<Stock>());
		pseDataResponse.getStock().add(new Stock());
		pseDataResponse.getStock().get(0).setName(NAME);
		doReturn(pseDataResponse).when(pseDataProvider).stock(SYMBOL);

		// when
		PseDataResponse pseDataResponse2 = pseDataService.stock(SYMBOL);

		// then
		Assertions.assertEquals(pseDataResponse2.getStock().get(0).getName(), NAME);
	}

}
