package com.sono.mybatch.testrepository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderConfirmRepositoryForTest {
	/**
	 * ログインデータテストデータ挿入
	 */
	public void insertTestDataLoginInfo();

	/**
	 * ログインデータ削除
	 */
	public void deleteTestDataLoginInfo();

	/**
	 * テストデータ挿入住所
	 */
	public void insertTestDataDestinationInfo();

	/**
	 * テストデータ削除住所
	 */
	public void deleteTestDataDestinationInfo();

	/**
	 * テストデータ挿入決済情報
	 */
	public void insertTestDataSettlementInfo();

	/**
	 * テストデータ削除決済情報
	 */
	public void deleteTestDataSettlementInfo();

	/**
	 * テストデータ挿入注文商品情報
	 */
	public void insertTestDataOrderItemInfo();

	/**
	 * テストデータ削除注文商品情報
	 */
	public void deleteTestDataOrderItemInfo();
}
