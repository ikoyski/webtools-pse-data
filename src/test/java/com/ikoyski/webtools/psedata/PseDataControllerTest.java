package com.ikoyski.webtools.psedata;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.ikoyski.webtools.psedata.controller.PseDataController;
import com.ikoyski.webtools.psedata.service.PseDataService;

@SpringBootTest
@ActiveProfiles("test")
class PseDataControllerTest {

	@Autowired
	private PseDataController pseDataController;

	@MockitoBean
	private PseDataService pseDataService;
	
	@Test
	@DisplayName("PseDataControllerTest.stockSucces()")
	void getDataSucces() {
		// when
		pseDataController.stock();

		// then
		verify(pseDataService).stock();
	}

	@Test
	@DisplayName("PseDataControllerTest.stockSucces2()")
	void getDataSucces2() {
		// given
		final String SYMBOL = "BDO";

		// when
		pseDataController.stock(SYMBOL);

		// then
		verify(pseDataService).stock(SYMBOL);
	}

}
