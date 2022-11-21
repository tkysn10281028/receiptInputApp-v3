package com.sono.mybatch.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import com.github.dozermapper.core.Mapper;
import com.sono.mybatch.dto.DestinationInfoResultDto;
import com.sono.mybatch.dto.OrderItemInfoResultDto;
import com.sono.mybatch.dto.PersonalInfoByAuthenticationResultDto;
import com.sono.mybatch.dto.SettlementInfoResultDto;
import com.sono.mybatch.repository.OrderConfirmRepository;

@Service
public class OrderConfirmService {
	@Autowired
	OrderConfirmRepository confirmRepository;

	@Autowired
	Mapper beanMapper;

	public List<PersonalInfoByAuthenticationResultDto> getPersonalInfoByAuthentication(String emailAddress) {
		var loginId = getLoginIdByEmailAddress(emailAddress);
		var output = new PersonalInfoByAuthenticationResultDto();
		output.setLoginId(loginId);
		output.setDestinationInfoResultDtos(
				confirmRepository.getDestinationInfoByLoginId(loginId).stream().map((destination) -> {
					return beanMapper.map(destination, DestinationInfoResultDto.class);
				}).collect(Collectors.toList()));
		output.setSettlementInfoResultDtos(
				confirmRepository.getSettlementInfoByLoginId(loginId).stream().map((settlement) -> {
					return beanMapper.map(settlement, SettlementInfoResultDto.class);
				}).collect(Collectors.toList()));
		output.setOrderItemInfoResultDtos(
				confirmRepository.getOrderItemInfoByLoginId(loginId).stream().map((orderItem) -> {
					return beanMapper.map(orderItem, OrderItemInfoResultDto.class);
				}).collect(Collectors.toList()));
		var outputList = new ArrayList<PersonalInfoByAuthenticationResultDto>();
		outputList.add(output);
		return outputList;
	}

	public String getLoginIdByEmailAddress(String emailAddress) {
		if (StringUtils.isEmpty(emailAddress)) {
			return null;
		}
		return confirmRepository.getLoginIdByEmailAddress(emailAddress);
	}
}
