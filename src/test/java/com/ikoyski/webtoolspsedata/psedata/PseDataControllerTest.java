package com.ikoyski.webtoolspsedata.psedata;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ikoyski.webtoolspsedata.controller.PseDataController;
import com.ikoyski.webtoolspsedata.service.PseDataService;

@SpringBootTest
class PseDataControllerTest {

	@Autowired
	private PseDataController pseDataController;

	@MockBean
	private PseDataService pseDataService;
	
	@Test
	@DisplayName("PsaDataControllerTest.stockSucces()")
	void getDataSucces() {
		// when
		pseDataController.stock();

		// then
		verify(pseDataService).stock();
	}

	@Test
	@DisplayName("PsaDataControllerTest.stockSucces2()")
	void getDataSucces2() {
		// given
		final String SYMBOL = "BDO";

		// when
		pseDataController.stock(SYMBOL);

		// then
		verify(pseDataService).stock(SYMBOL);
	}

}
