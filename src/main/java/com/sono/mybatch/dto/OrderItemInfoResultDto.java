package com.sono.mybatch.dto;

import lombok.Data;

@Data
public class OrderItemInfoResultDto {
	/**
	 * 注文商品ID
	 */
	private String orderItemId;

	/**
	 * 商品名
	 */
	private String orderItemName;
	/**
	 * 注文商品価格
	 */
	private Integer orderItemPrice;
	/**
	 * 値引き区分
	 */
	private String discountDiv;
	/**
	 * 値引き金額
	 */
	private Integer discountMoney;
}
