package com.sono.mybatch.model;

import lombok.Data;

@Data
public class ItemInfoSearchResultModel {

	/**
	 * 商品ID
	 */
	private String itemId;
	/**
	 * 商品名
	 */
	private String itemName;

	/**
	 * 商品価格
	 */
	private Integer itemPrice;

	/**
	 * 商品大分類区分
	 */
	private String itemMajorDiv;

	/**
	 * 商品大分類名
	 */
	private String itemMajorName;

	/**
	 * 商品中分類区分
	 */
	private String itemMiddleDiv;
	/**
	 * 商品中分類名
	 */
	private String itemMiddleName;
	/**
	 * 商品小分類区分
	 */
	private String itemMinorDiv;
	/**
	 * 商品小分類名
	 */
	private String itemMinorName;
	/**
	 * 値下げ比率
	 */
	private Double itemDiscountRate;

}
