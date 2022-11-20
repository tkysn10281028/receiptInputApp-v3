package com.sono.mybatch.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sono.mybatch.dto.PersonalInfoByAuthenticationResultDto;

@RestController
public class OrderConfirmController {
	@RequestMapping(path = "/api/v1/getPersonalInfoByAuthentication", method = RequestMethod.POST)
	public ResponseEntity<PersonalInfoByAuthenticationResultDto> getPersonalInfoByAuthentication(Authentication auth) {
		return null;
	}
}
