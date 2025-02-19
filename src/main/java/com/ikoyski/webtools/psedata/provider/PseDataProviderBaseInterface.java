package com.ikoyski.webtools.psedata.provider;

import com.ikoyski.webtools.psedata.dto.PseDataResponse;

public interface PseDataProviderBaseInterface {

	public static final String ERROR_INVALID_URI = "invalid uri";

	public PseDataResponse stock();

	public PseDataResponse stock(String symbol);

}
