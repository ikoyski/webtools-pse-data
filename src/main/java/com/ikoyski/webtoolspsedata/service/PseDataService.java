package com.ikoyski.webtoolspsedata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikoyski.webtoolspsedata.dto.PseDataResponse;
import com.ikoyski.webtoolspsedata.provider.PseDataProviderBaseInterface;
import com.ikoyski.webtoolspsedata.provider.PseDataProviderFactory;

@Service
public class PseDataService {

	@Autowired
	private PseDataProviderFactory pseDataProviderFactory;
	
	public PseDataResponse stock() {
		PseDataProviderBaseInterface psaProviderProvider = pseDataProviderFactory.createPsaDataProvider();
		return psaProviderProvider.stock();
	}

	public PseDataResponse stock(String symbol) {
		PseDataProviderBaseInterface psaProviderProvider = pseDataProviderFactory.createPsaDataProvider();
		return psaProviderProvider.stock(symbol);
	}

}
