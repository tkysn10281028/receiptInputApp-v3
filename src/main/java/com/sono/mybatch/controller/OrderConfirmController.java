package com.sono.mybatch.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sono.mybatch.dto.ItemListDtoForOrderConfirmDto;

@RestController
public class OrderConfirmController {
	@RequestMapping(path = "/api/v1/getPersonalInfoByAuthentication", method = RequestMethod.POST)
	public ResponseEntity<String> getPersonalInfoByAuthentication(
			@RequestParam("itemList") List<ItemListDtoForOrderConfirmDto> itemList) {
		return null;
	}
}
