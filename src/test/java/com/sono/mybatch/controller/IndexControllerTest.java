package com.sono.mybatch.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.sono.mybatch.repository.GenerateNonJwtRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@AutoConfigureMockMvc

class IndexControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	GenerateNonJwtRepository generateNonJwtRepository;

	private String tokenId = "";

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
				.andDo((result -> this.tokenId = result.getResponse().getHeader("Authorization")));
		assertTrue(StringUtils.contains(tokenId, "jwtid: "));
		this.tokenId = "";
	}

	@Test
	void testLogout() throws Exception {
		this.mockMvc.perform(get("/api/v1/logout"))
				.andDo((result -> this.tokenId = result.getResponse().getHeader("Authorization")))
				.andExpect(status().isOk()).andExpect(view().name("index"));
		try {
			generateNonJwtRepository.searchJwtTokenByJwtTokenId(this.tokenId);
			this.tokenId = "";
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().matches(".*Token Id Not Found."));
			this.tokenId = "";
		}
	}

}