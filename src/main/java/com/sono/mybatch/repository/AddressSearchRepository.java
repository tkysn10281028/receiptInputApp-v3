package com.sono.mybatch.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sono.mybatch.model.AddressSearchResultByAddressModel;
import com.sono.mybatch.model.AddressSearchResultByPostalCodeModel;

@Mapper
public interface AddressSearchRepository {
	public List<AddressSearchResultByPostalCodeModel> getAddressByPostalCode(@Param("postalCode") String postalCode);

	public List<AddressSearchResultByAddressModel> getAllKen();

	public List<AddressSearchResultByAddressModel> getAddressByKenId(@Param("kenId") String kenId);

	public List<AddressSearchResultByAddressModel> getAddressByCityId(@Param("cityId") String cityId);

	public List<AddressSearchResultByAddressModel> getAddressByTownId(@Param("townId") String townId);
}
