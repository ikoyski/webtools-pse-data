package com.ikoyski.webtoolspsedata.psedata;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ikoyski.webtoolspsedata.dto.PseDataResponse;
import com.ikoyski.webtoolspsedata.dto.Stock;

@SpringBootTest
class PseDataResponseTest {

	@Test
	@DisplayName("PsaDataResponseTest.psaDataResponseSuccess()")
	void psaDataResponseSuccess() {
		// given
		final String NAME = "Bank of the Philippine Islands";
		final String CURRENCY = "PHP";
		final Double AMOUNT = 131.00;
		final Double PERCENT_CHANGE = 2.34;
		final Integer VOLUME = 4220720;
		final String SYMBOL = "BPI";
		final String AS_OF = "2025-02-13T00:00:00+08:00";

		// when
		PseDataResponse pseDataResponse = new PseDataResponse();
		pseDataResponse.setStock(new ArrayList<Stock>());
		pseDataResponse.getStock().add(new Stock());
		pseDataResponse.getStock().get(0).setName(NAME);
		pseDataResponse.getStock().get(0).setPrice(new Stock.Price());
		pseDataResponse.getStock().get(0).getPrice().setCurrency(CURRENCY);
		pseDataResponse.getStock().get(0).getPrice().setAmount(AMOUNT);
		pseDataResponse.getStock().get(0).setPercentChange(PERCENT_CHANGE);
		pseDataResponse.getStock().get(0).setVolume(VOLUME);
		pseDataResponse.getStock().get(0).setSymbol(SYMBOL);
		pseDataResponse.setAsOf(AS_OF);

		// then
		Assertions.assertEquals(pseDataResponse.getStock().get(0).getName(), NAME);
		Assertions.assertEquals(pseDataResponse.getStock().get(0).getPrice().getCurrency(), CURRENCY);
		Assertions.assertEquals(pseDataResponse.getStock().get(0).getPrice().getAmount(), AMOUNT);
		Assertions.assertEquals(pseDataResponse.getStock().get(0).getPercentChange(), PERCENT_CHANGE);
		Assertions.assertEquals(pseDataResponse.getStock().get(0).getVolume(), VOLUME);
		Assertions.assertEquals(pseDataResponse.getStock().get(0).getSymbol(), SYMBOL);
		Assertions.assertEquals(pseDataResponse.getAsOf(), AS_OF);
	}
}
