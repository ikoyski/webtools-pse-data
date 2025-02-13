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
	@DisplayName("IpLocationControllerTest.getDataSucces2()")
	void getDataSuccess() {
		// when
		pseDataController.getData();

		// then
		verify(pseDataService).getData();
	}

	@Test
	@DisplayName("IpLocationControllerTest.getDataSucces2()")
	void getDataSucces2() {
		// given
		final String symbol = "BDO";

		// when
		pseDataController.getData(symbol);

		// then
		verify(pseDataService).getData(symbol);
	}

}
