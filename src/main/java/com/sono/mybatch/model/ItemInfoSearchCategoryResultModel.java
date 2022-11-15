package com.sono.mybatch.model;

import lombok.Data;

@Data
public class ItemInfoSearchCategoryResultModel {
	/**
	 * 大分類区分コード
	 */
	private String itemMajorDiv;
	/**
	 * 大分類名
	 */
	private String itemMajorName;
	/**
	 * 中分類区分コード
	 */
	private String itemMiddleDiv;
	/**
	 * 中分類名
	 */
	private String itemMiddleName;
	/**
	 * 小分類区分
	 */
	private String itemMinorDiv;
	/**
	 * 小分類名
	 */
	private String itemMinorName;
}
