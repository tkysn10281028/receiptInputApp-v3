package com.sono.mybatch.loginhandler;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.sono.mybatch.repository.GenerateNonJwtRepository;
import com.sono.mybatch.security.JwtUtils;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	GenerateNonJwtRepository generateNonJwtRepository;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth)
			throws IOException, ServletException {
		log.info("login success");
		var tokenId = UUID.randomUUID().toString().replaceAll("-", "");
		log.info("UUID : {}", tokenId);
		var token = jwtUtils.generateAccessToken(auth.getName());
		log.info("json web token : {}", token);
		generateNonJwtRepository.generateNonJwtToken(tokenId, token);
	}
}
