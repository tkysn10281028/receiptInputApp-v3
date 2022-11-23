package com.sono.mybatch.controller;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.sono.mybatch.security.JwtUtils;
import com.sono.mybatch.service.AddressSearchService;
import com.sono.mybatch.service.GenerateNonJwtService;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
@Slf4j
class AddressSearchControllerTest {
	@Autowired
	AddressSearchService addressSearchService;
	@Autowired
	MockMvc mockMvc;
	@Autowired
	JwtUtils jwtUtils;
	private String accessToken;
	@Autowired
	GenerateNonJwtService generateNonJwtService;

	@Test
	void testGetAddressByPostalCodeFound() throws Exception {
		this.mockMvc
				.perform(post("/api/v1/getAddressByPostalCode").param("postalCode", "001-0034")
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].zip").value("001-0034")).andExpect(jsonPath("$[0].kenName").value("北海道"))
				.andExpect(jsonPath("$[0].cityName").value("札幌市北区"))
				.andExpect(jsonPath("$[0].townName").value("北三十四条西")).andExpect(jsonPath("$[0].blockName").value(""));
	}

	@Test
	void testGetAddressByPostalCodeFoundMany() throws Exception {
		this.mockMvc
				.perform(post("/api/v1/getAddressByPostalCode").param("postalCode", "921-8046")
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].zip").value("921-8046")).andExpect(jsonPath("$[0].kenName").value("石川県"))
				.andExpect(jsonPath("$[0].cityName").value("金沢市")).andExpect(jsonPath("$[0].townName").value("大桑町"))
				.andExpect(jsonPath("$[0].blockName").value("ア"));
	}

	@Test
	void testGetAddressByPostalCodeNotFound() throws Exception {
		this.mockMvc
				.perform(post("/api/v1/getAddressByPostalCode").param("postalCode", "000-0000")
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$", hasSize(0)));
	}

	@Test
	void testGetAddressByPostalCodeBlank() throws Exception {
		this.mockMvc.perform(post("/api/v1/getAddressByPostalCode").param("postalCode", "")
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isBadRequest());
	}

	@Test
	void testGetAddressByPostalCodeNull() throws Exception {
		this.mockMvc.perform(post("/api/v1/getAddressByPostalCode").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isBadRequest());
	}

	@Test
	void testGetAddressByPostalCodeWithoutHyphen() throws Exception {
		this.mockMvc.perform(post("/api/v1/getAddressByPostalCode").param("postalCode", "0010010")
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isBadRequest());
	}

	@Test
	void testGetAddressByPostalCodeOnlyHyphen() throws Exception {
		this.mockMvc.perform(post("/api/v1/getAddressByPostalCode").param("postalCode", "-")
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isBadRequest());
	}

	@Test
	void testGetAddressByPostalCodeNotValidChar() throws Exception {
		this.mockMvc.perform(post("/api/v1/getAddressByPostalCode").param("postalCode", "1-1")
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isBadRequest());
	}

}
