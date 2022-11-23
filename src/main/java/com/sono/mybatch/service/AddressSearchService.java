package com.sono.mybatch.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.dozermapper.core.Mapper;
import com.sono.mybatch.dto.AddressSearchResultByPostalCodeDto;
import com.sono.mybatch.repository.AddressSearchRepository;

@Service
public class AddressSearchService {
	@Autowired
	AddressSearchRepository addressSearchRepository;
	@Autowired
	Mapper beanMapper;

	public List<AddressSearchResultByPostalCodeDto> getAddressByPostalCode(String postalCode) {
		if (StringUtils.isNotEmpty(postalCode) && StringUtils.countMatches(postalCode, "-") == 1
				&& postalCode.split("-").length == 2 && postalCode.split("-")[0].length() == 3
				&& postalCode.split("-")[1].length() == 4) {
			return addressSearchRepository.getAddressByPostalCode(postalCode).stream().map((bean) -> {
				return beanMapper.map(bean, AddressSearchResultByPostalCodeDto.class);
			}).collect(Collectors.toList());
		} else {
			throw new IllegalArgumentException("Postal Code Invalid.");
		}

	}

//	public List<AddressSearchResultByAddressDto> getAllKen() {
//
//	}
}
