package com.ikoyski.webtoolspsedata.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ikoyski.webtoolspsedata.dto.PseDataResponse;
import com.ikoyski.webtoolspsedata.service.PseDataService;

@RestController
public class PseDataController {

	private final PseDataService pseDataService;

	public PseDataController(PseDataService pseDataService) {
		this.pseDataService = pseDataService;
	}
	
	@GetMapping(path = "api/v1/getData")
	@Cacheable(value = "getData", key = "#data")
	public PseDataResponse getData() {
		return pseDataService.getData();
	}

	@GetMapping(path = "api/v1/getData/{symbol}")
	@Cacheable(value = "getData", key = "#symbol")
	public PseDataResponse getData(@PathVariable("symbol") String symbol) {
		return pseDataService.getData(symbol);
	}

}
