package com.ikoyski.webtoolspsedata.provider;

import com.ikoyski.webtoolspsedata.dto.PseDataResponse;

public interface PseDataProviderBaseInterface {

	public static final String ERROR_INVALID_URI = "invalid uri";

	public PseDataResponse stock();

	public PseDataResponse stock(String symbol);

}
