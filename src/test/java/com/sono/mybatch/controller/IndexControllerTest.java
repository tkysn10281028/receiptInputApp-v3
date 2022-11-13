package com.sono.mybatch.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.sono.mybatch.repository.GenerateNonJwtRepository;
import com.sono.mybatch.service.GenerateNonJwtService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
class IndexControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	GenerateNonJwtRepository generateNonJwtRepository;
	@Autowired
	GenerateNonJwtService generateNonJwtService;

	private String tokenId = "";

	@AfterAll
	public void deleteDataAfterClass() throws Exception {
		generateNonJwtRepository.deleteInsertedJwtTokenId();
	}

	@Test
	void testgetIndex() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
	}

	@Test
	void testLoginPostIndex() throws Exception {
		this.mockMvc.perform(post("/").param("emailaddress", "tkysn1028@gmail.com").param("password", "testpass"))
				.andExpect(status().isOk());
	}

	@Test
	void testLoginPostIndexCheckAuthorizationHeader() throws Exception {
		this.mockMvc.perform(post("/").param("emailaddress", "tkysn1028@gmail.com").param("password", "testpass"))
				.andDo((result -> this.tokenId = result.getResponse().getHeader(HttpHeaders.AUTHORIZATION)));
		assertTrue(StringUtils.contains(tokenId, "jwtid: "));
		this.tokenId = "";
	}

	@Test
	void testLogout() throws Exception {

		this.mockMvc.perform(post("/").param("emailaddress", "tkysn1028@gmail.com").param("password", "testpass"))
				.andDo((result -> this.tokenId = result.getResponse().getHeader(HttpHeaders.AUTHORIZATION)));
		this.mockMvc.perform(post("/api/v1/deleteTokenIdForLogOut").header(HttpHeaders.AUTHORIZATION, this.tokenId))
				.andExpect(status().is3xxRedirection());
		try {
			generateNonJwtService.searchJwtTokenByJwtId(this.tokenId);
			this.tokenId = "";
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().matches(".*Cannot Find Jwt Token"));
			this.tokenId = "";
		}
	}

}