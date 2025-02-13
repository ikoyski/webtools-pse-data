package com.ikoyski.webtoolspsedata.provider;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.ikoyski.webtoolspsedata.dto.PseDataResponse;

public class PseDataProviderPhisix implements PseDataProviderBaseInterface {

	String BASE_ENDPOINT = "https://phisix-api3.appspot.com";

	@Override
	public PseDataResponse getData() {
		PseDataResponse pseDataResponse = null;
		try {
			URI uri = new URI(BASE_ENDPOINT + "/stocks.json");
			RestTemplate restTemplate = new RestTemplate();
			pseDataResponse = restTemplate.getForObject(uri.toURL().toString(), PseDataResponse.class);
		} catch (URISyntaxException | RestClientException | MalformedURLException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, PseDataProviderBaseInterface.ERROR_INVALID_URI,
					null);
		}
		return pseDataResponse;
	}

	@Override
	public PseDataResponse getData(String symbol) {
		PseDataResponse pseDataResponse = null;
		try {
			URI uri = new URI(BASE_ENDPOINT + "/stocks/" + symbol.toUpperCase() + ".json");
			RestTemplate restTemplate = new RestTemplate();
			pseDataResponse = restTemplate.getForObject(uri.toURL().toString(), PseDataResponse.class);
		} catch (URISyntaxException | RestClientException | MalformedURLException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, PseDataProviderBaseInterface.ERROR_INVALID_URI,
					null);
		}
		return pseDataResponse;
	}

}
