package com.sono.mybatch.dto;

import lombok.Data;

/**
 * @author entakuya
 *
 */
/**
 * @author entakuya
 *
 */
@Data
public class ItemInfoSearchResultDto {

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
	 * 値下げ区分
	 */
	private String itemDiscountDiv;
	/**
	 * 値下げ比率
	 */
	private Double itemDiscountRate;

	/**
	 * @param itemId
	 * @param itemName
	 * @param itemPrice
	 * @param itemMajorDiv
	 * @param itemMajorName
	 * @param itemMiddleDiv
	 * @param itemMiddleName
	 * @param itemMinorDiv
	 * @param itemMinorName
	 * @param itemDiscountDiv
	 * @param itemDiscountRate テスト用コンストラクター
	 * 
	 */
	public ItemInfoSearchResultDto(String itemId, String itemName, Integer itemPrice, String itemMajorDiv,
			String itemMajorName, String itemMiddleDiv, String itemMiddleName, String itemMinorDiv,
			String itemMinorName, String itemDiscountDiv, Double itemDiscountRate) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemMajorDiv = itemMajorDiv;
		this.itemMiddleDiv = itemMiddleDiv;
		this.itemMajorName = itemMajorName;
		this.itemMiddleName = itemMiddleName;
		this.itemMinorDiv = itemMinorDiv;
		this.itemMinorName = itemMinorName;
		this.itemDiscountDiv = itemDiscountDiv;
		this.itemDiscountRate = itemDiscountRate;
	}

}
