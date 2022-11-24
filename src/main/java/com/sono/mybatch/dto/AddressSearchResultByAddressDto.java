package com.sono.mybatch.dto;

import lombok.Data;

@Data
public class AddressSearchResultByAddressDto {
	/**
	 * 郵便番号
	 */
	private String zip;

	/**
	 * 都道府県ID
	 */
	private String kenId;
	/**
	 * 都道府県名
	 */
	private String kenName;
	/**
	 * 市町村ID
	 */
	private String cityId;
	/**
	 * 市町村名
	 */
	private String cityName;
	/**
	 * 町丁ID
	 */
	private String townId;
	/**
	 * 町丁名
	 */
	private String townName;
	/**
	 * 結合住所
	 */
	private String concatAddress;
}
