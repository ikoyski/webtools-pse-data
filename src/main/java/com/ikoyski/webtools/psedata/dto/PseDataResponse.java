package com.ikoyski.webtools.psedata.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PseDataResponse {

	List<Stock> stock;
	
	@JsonProperty("as_of")
	String asOf;

	public List<Stock> getStock() {
		return stock;
	}

	public void setStock(List<Stock> stock) {
		this.stock = stock;
	}

	public String getAsOf() {
		return asOf;
	}

	public void setAsOf(String asOf) {
		this.asOf = asOf;
	}

}
