package com.sono.mybatch.dto;

import java.util.List;

import lombok.Data;

@Data
public class PersonalInfoByAuthenticationResultDto {
	/**
	 * ログインID
	 */
	private String loginId;
	/**
	 * 住所情報リスト
	 */
	private List<DestinationInfoResultDto> destinationInfoResultDtos;
	/**
	 * 決済情報リスト
	 */
	private List<SettlementInfoResultDto> settlementInfoResultDtos;
	/**
	 * 注文商品情報リスト
	 */
	private List<OrderItemInfoResultDto> orderItemInfoResultDtos;

}
