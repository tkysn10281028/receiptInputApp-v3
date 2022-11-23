package com.sono.mybatch.dto;

import lombok.Data;

@Data
public class AddressSearchResultByPostalCodeDto {
	/**
	 * 郵便番号
	 */
	private String zip;
	/**
	 * 都道府県名
	 */
	private String kenName;
	/**
	 * 市町村名
	 */
	private String cityName;
	/**
	 * 町丁名
	 */
	private String townName;
	/**
	 * 番地名
	 */
	private String blockName;
}
