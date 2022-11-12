package com.sono.mybatch.service;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sono.mybatch.repository.GenerateNonJwtRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GenerateNonJwtService {
	@Autowired
	GenerateNonJwtRepository generateNonJwtRepository;

	public String generateNonJwtToken(String token) {
		var tokenId = UUID.randomUUID().toString();
		generateNonJwtRepository.generateNonJwtToken(tokenId, token);
		log.info("Successfully inserted token : {}, and token Id : {}", token, tokenId);
		return tokenId;
	}

	public String searchJwtTokenByJwtId(String jwtId) {
		var token = generateNonJwtRepository.searchJwtTokenByJwtTokenId(jwtId);
		if (StringUtils.isEmpty(token)) {
			throw new IllegalArgumentException("Cannot Find Jwt Token");
		}
		return token;
	}

	public void deleteJwtTokenId(String tokenId) {
		generateNonJwtRepository.deleteJwtTokenId(tokenId);
		log.info("Successfully Deleted tokenId : {}", tokenId);
	}
}
