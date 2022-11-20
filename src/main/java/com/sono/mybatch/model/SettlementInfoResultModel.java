package com.sono.mybatch.model;

import lombok.Data;

@Data
public class SettlementInfoResultModel {
	/**
	 * 決済情報枝番
	 */
	private Integer settlementInfoLoginBranch;
	/**
	 * カード会社ID
	 */
	private String cardCompanyCode;
	/**
	 * クレジットカード番号
	 */
	private String creditCardNo;
	/**
	 * セキュリティコード
	 */
	private String securityCode;
	/**
	 * 有効期限
	 */
	private String expireDate;
}
