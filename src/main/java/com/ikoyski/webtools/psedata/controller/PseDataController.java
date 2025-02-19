package com.ikoyski.webtools.psedata.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ikoyski.webtools.psedata.dto.PseDataResponse;
import com.ikoyski.webtools.psedata.service.PseDataService;

@RestController
public class PseDataController {

	private final PseDataService pseDataService;

	public PseDataController(PseDataService pseDataService) {
		this.pseDataService = pseDataService;
	}
	
	@GetMapping(path = "api/v1/stock")
	@Cacheable(value = "stock")
	public PseDataResponse stock() {
		return pseDataService.stock();
	}

	@GetMapping(path = "api/v1/stock/{symbol}")
	@Cacheable(value = "stock", key = "#symbol")
	public PseDataResponse stock(@PathVariable("symbol") String symbol) {
		return pseDataService.stock(symbol);
	}

}
