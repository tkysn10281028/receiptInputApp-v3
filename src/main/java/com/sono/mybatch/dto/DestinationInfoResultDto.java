package com.sono.mybatch.dto;

import lombok.Data;

@Data
public class DestinationInfoResultDto {
	/**
	 * 住所情報枝番
	 */
	private Integer destinationInfoLoginBranch;
	/**
	 * 住所情報メールアドレス
	 */
	private String destinationEmailAddress;
	/**
	 * 住所情報宛先名
	 */
	private String destinationName;
	/**
	 * 住所情報電話番号
	 */
	private String destinationTelNo;
	/**
	 * 住所情報郵便番号
	 */
	private String destinationPostalCode;
	/**
	 * 住所情報県
	 */
	private String destinationPrefecture;
	/**
	 * 住所情報市町村
	 */
	private String destinationCity;
	/**
	 * 住所情報町丁
	 */
	private String destinationTown;
	/**
	 * 住所情報町丁No
	 */
	private String destinationTownNo;
	/**
	 * 住所情報建物名
	 */
	private String destinationBuilding;
	/**
	 * 住所情報部屋番号
	 */
	private String destinationRoomNo;
	/**
	 * 個人情報宛先名
	 */
	private String personalName;
	/**
	 * 個人情報電話番号
	 */
	private String personalTelNo;
	/**
	 * 個人情報郵便番号
	 */
	private String personalPostalCode;
	/**
	 * 個人情報県
	 */
	private String personalPrefecture;
	/**
	 * 個人情報市町村
	 */
	private String personalCity;
	/**
	 * 個人情報町丁
	 */
	private String personalTown;
	/**
	 * 個人情報町丁No
	 */
	private String personalTownNo;
	/**
	 * 個人情報建物名
	 */
	private String personalBuilding;
	/**
	 * 個人情報部屋番号
	 */
	private String personalRoomNo;

}
