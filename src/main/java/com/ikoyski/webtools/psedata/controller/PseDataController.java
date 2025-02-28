package com.ikoyski.webtools.psedata.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikoyski.webtools.psedata.dto.PseDataResponse;
import com.ikoyski.webtools.psedata.service.PseDataService;

@RestController
@RequestMapping("/pse-data")
public class PseDataController {

	private final PseDataService pseDataService;

	public PseDataController(PseDataService pseDataService) {
		this.pseDataService = pseDataService;
	}
	
	@GetMapping(path = "/v1")
	@Cacheable(value = "pse-data")
	public PseDataResponse stock() {
		return pseDataService.stock();
	}

	@GetMapping(path = "/v1/{symbol}")
	@Cacheable(value = "pse-data", key = "#symbol")
	public PseDataResponse stock(@PathVariable("symbol") String symbol) {
		return pseDataService.stock(symbol);
	}

}
