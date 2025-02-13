package com.ikoyski.webtoolspsedata.dto;

import java.util.List;

public class PseDataResponse {

	List<Stock> stock;
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
