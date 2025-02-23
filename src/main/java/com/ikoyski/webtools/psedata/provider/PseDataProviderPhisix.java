package com.ikoyski.webtools.psedata.provider;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ikoyski.webtools.psedata.dto.PseDataResponse;
import com.ikoyski.webtools.psedata.dto.Stock;
import com.ikoyski.webtools.psedata.dto.Stock.Price;

@Component
public class PseDataProviderPhisix implements PseDataProviderBaseInterface {

	@Value("${provider.phisix.baseUrl}")
	String BASE_URL;

	@Override
	public PseDataResponse stock() {
		return stock("");
	}

	@Override
	public PseDataResponse stock(String symbol) {
		PseDataResponse pseDataResponse = null;
		try {
			URI uri = new URI(BASE_URL + "/stocks/" + symbol.toUpperCase().trim() + ".json");
			RestTemplate restTemplate = new RestTemplate();
			pseDataResponse = responseAdapter(restTemplate.getForObject(uri.toURL().toString(), PhisixResponse.class));
		} catch (URISyntaxException | RestClientException | MalformedURLException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, PseDataProviderBaseInterface.ERROR_INVALID_URI,
					null);
		}
		return pseDataResponse;
	}

	private PseDataResponse responseAdapter(PhisixResponse response) {
		PseDataResponse pseDataResponse = new PseDataResponse();

		pseDataResponse.setStock(new ArrayList<Stock>());
		response.getStock().stream().forEach(phisixStock -> {
			Stock stock = new Stock();
			stock.setName(phisixStock.getName());
			stock.setPercentChange(phisixStock.getPercentChange());
			stock.setPrice(new Price());
			stock.getPrice().setAmount(phisixStock.getPrice().getAmount());
			stock.getPrice().setCurrency(phisixStock.getPrice().getCurrency());
			stock.setSymbol(phisixStock.getSymbol());
			stock.setVolume(phisixStock.getVolume());
			pseDataResponse.getStock().add(stock);
		});

		pseDataResponse.setAsOf(response.getAsOf());
		return pseDataResponse;
	}

	public static class PhisixResponse {

		List<PhisixStock> stock;

		@JsonProperty("as_of")
		String asOf;

		public List<PhisixStock> getStock() {
			return stock;
		}

		public void setStock(List<PhisixStock> stock) {
			this.stock = stock;
		}

		public String getAsOf() {
			return asOf;
		}

		public void setAsOf(String asOf) {
			this.asOf = asOf;
		}

	}

	public static class PhisixStock {

		String name;
		PhisixPrice price;

		@JsonProperty("percent_change")
		Double percentChange;
		Integer volume;
		String symbol;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public PhisixPrice getPrice() {
			return price;
		}

		public void setPrice(PhisixPrice price) {
			this.price = price;
		}

		public Double getPercentChange() {
			return percentChange;
		}

		public void setPercentChange(Double percentChange) {
			this.percentChange = percentChange;
		}

		public Integer getVolume() {
			return volume;
		}

		public void setVolume(Integer volume) {
			this.volume = volume;
		}

		public String getSymbol() {
			return symbol;
		}

		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}

		public static class PhisixPrice {

			String currency;
			Double amount;

			public String getCurrency() {
				return currency;
			}

			public void setCurrency(String currency) {
				this.currency = currency;
			}

			public Double getAmount() {
				return amount;
			}

			public void setAmount(Double amount) {
				this.amount = amount;
			}

		}

	}

}
