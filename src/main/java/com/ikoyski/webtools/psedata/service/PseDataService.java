package com.ikoyski.webtools.psedata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikoyski.webtools.psedata.dto.PseDataResponse;
import com.ikoyski.webtools.psedata.provider.PseDataProviderBaseInterface;
import com.ikoyski.webtools.psedata.provider.PseDataProviderFactory;

@Service
public class PseDataService {

	@Autowired
	private PseDataProviderFactory pseDataProviderFactory;
	
	public PseDataResponse stock() {
		PseDataProviderBaseInterface psaProviderProvider = pseDataProviderFactory.createPseDataProvider();
		return psaProviderProvider.stock();
	}

	public PseDataResponse stock(String symbol) {
		PseDataProviderBaseInterface psaProviderProvider = pseDataProviderFactory.createPseDataProvider();
		return psaProviderProvider.stock(symbol);
	}

}
