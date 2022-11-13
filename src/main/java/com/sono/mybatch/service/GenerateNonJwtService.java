package com.sono.mybatch.service;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sono.mybatch.repository.GenerateNonJwtRepository;
import com.sono.mybatch.security.JwtUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GenerateNonJwtService {
	@Autowired
	GenerateNonJwtRepository generateNonJwtRepository;

	@Autowired
	JwtUtils jwtUtils;

	public String generateNonJwtToken(String token, String emailAddress) {
		if (token == null) {
			throw new IllegalArgumentException("Not valid Token.");
		}
		if (emailAddress == null) {
			throw new IllegalArgumentException("User Authentication Is Invalid.");
		}
		var tokenId = "jwtid: ".concat(StringUtils.replace(UUID.randomUUID().toString(), "-", ""));
		generateNonJwtRepository.generateNonJwtToken(jwtUtils.removeJwtIdBearer(tokenId), token, emailAddress);
		log.info("Successfully inserted token : {}, and token Id : {}", token, tokenId);
		return tokenId;
	}

	public String searchJwtTokenByJwtId(String jwtId) {
		if (StringUtils.isEmpty(jwtId)) {
			throw new IllegalArgumentException("Not valid Jwt Id.");
		}
		if (!StringUtils.contains(jwtId, "jwtid: ")) {
			throw new IllegalArgumentException("No Bearer Found For Jwt Id.");
		}

		var token = generateNonJwtRepository.searchJwtTokenByJwtTokenId(jwtUtils.removeJwtIdBearer(jwtId));
		if (token == null) {
			throw new IllegalArgumentException("Cannot Find Jwt Token");
		}
		return token;
	}

	public void deleteJwtTokenId(String tokenId) {
		generateNonJwtRepository.deleteJwtTokenId(jwtUtils.removeJwtIdBearer(tokenId));
		log.info("Successfully Deleted tokenId : {}", tokenId);
	}

	public void deleteJwtTokenIdByEmailAddress(String emailAddress) {
		if (emailAddress == null) {
			throw new IllegalArgumentException("User Authentication Is Invalid.");
		}
		generateNonJwtRepository.deleteInsertedJwtTokenIdByEmailAddress(emailAddress);
	}
}
