package com.sono.mybatch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sono.mybatch.dto.PersonalInfoByAuthenticationResultDto;
import com.sono.mybatch.service.OrderConfirmService;

@RestController
public class OrderConfirmController {
	@Autowired
	OrderConfirmService confirmService;

	@RequestMapping(path = "/api/v1/getPersonalInfoByAuthentication", method = RequestMethod.POST)
	public ResponseEntity<List<PersonalInfoByAuthenticationResultDto>> getPersonalInfoByAuthentication(
			Authentication auth) {
		String emailAddress = auth.getName();
		var personalInfo = confirmService.getPersonalInfoByAuthentication(emailAddress);
		return new ResponseEntity<List<PersonalInfoByAuthenticationResultDto>>(personalInfo, new HttpHeaders(),
				HttpStatus.OK);
	}
}
