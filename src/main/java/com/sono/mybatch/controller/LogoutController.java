package com.sono.mybatch.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sono.mybatch.service.GenerateNonJwtService;

@RestController
public class LogoutController {
	@Autowired
	GenerateNonJwtService generateNonJwtService;

	@RequestMapping(method = RequestMethod.POST, path = "/api/v1/deleteTokenIdForLogOut")
	public void deleteTokenIdForLogOut(HttpServletRequest request, HttpServletResponse response) throws IOException {

		var tokenId = request.getHeader(HttpHeaders.AUTHORIZATION);
		generateNonJwtService.deleteJwtTokenId(tokenId);
		response.sendRedirect("/api/v1/logout");
	}
}
