package com.ikoyski.webtoolspsedata.psedata;

import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.ikoyski.webtoolspsedata.dto.PseDataResponse;
import com.ikoyski.webtoolspsedata.dto.Stock;
import com.ikoyski.webtoolspsedata.provider.PseDataProviderBaseInterface;
import com.ikoyski.webtoolspsedata.service.PseDataService;

@SpringBootTest
@ActiveProfiles("test")
class PseDataServiceTest {

	@Autowired
	private PseDataService pseDataService;

	@MockBean
	PseDataProviderBaseInterface psaDataProvider;

	@Test
	@DisplayName("PsaDataServiceTest.getPsaDataSuccess()")
	void getPsaDataSuccess() {
		// given
		final String SYMBOL = "ABC";
		final String NAME = "Dummy Bank";
		PseDataResponse pseDataResponse = new PseDataResponse();
		pseDataResponse.setStock(new ArrayList<Stock>());
		pseDataResponse.getStock().get(0).setName(NAME);
		doReturn(pseDataResponse).when(psaDataProvider).getData(SYMBOL);

		// when
		PseDataResponse pseDataResponse2 = pseDataService.getData(SYMBOL);

		// then
		Assertions.assertEquals(pseDataResponse2.getStock().get(0).getName(), NAME);
	}

}
