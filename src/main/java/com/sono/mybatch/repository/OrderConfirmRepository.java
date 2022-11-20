package com.sono.mybatch.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sono.mybatch.model.DestinationInfoResultModel;
import com.sono.mybatch.model.OrderItemInfoResultModel;
import com.sono.mybatch.model.SettlementInfoResultModel;

@Mapper
public interface OrderConfirmRepository {
	public String getLoginIdByEmailAddress(String emailAddress);

	public List<DestinationInfoResultModel> getDestinationInfoByLoginId(@Param("loginId") String loginId);

	public List<SettlementInfoResultModel> getSettlementInfoByLoginId(@Param("loginId") String loginId);

	public List<OrderItemInfoResultModel> getOrderItemInfoByLoginId(@Param("loginId") String loginId);

}
