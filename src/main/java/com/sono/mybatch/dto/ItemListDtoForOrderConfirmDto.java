package com.sono.mybatch.dto;

import lombok.Data;

/**
 * 注文確定情報APIの入力用DTO
 */
@Data
public class ItemListDtoForOrderConfirmDto {
	/**
	 * 商品ID
	 */
	private String itemId;
	/**
	 * 商品価格
	 */
	private Integer itemPrice;

	/**
	 * 値引き区分
	 */
	private String discountDiv;

	/**
	 * 値引き金額
	 */
	private Integer discountMoney;
}
