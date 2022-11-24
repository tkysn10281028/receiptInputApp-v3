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

	@Test
	void testGetAllKen() throws Exception {
		this.mockMvc.perform(post("/api/v1/getAllKen").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$", hasSize(47)))
				.andExpect(jsonPath("$[0].zip").isEmpty()).andExpect(jsonPath("$[0].cityId").isEmpty())
				.andExpect(jsonPath("$[0].townName").isEmpty()).andExpect(jsonPath("$[0].townId").isEmpty())
				.andExpect(jsonPath("$[0].kenId").value(1)).andExpect(jsonPath("$[0].kenName").value("北海道"));
	}

	@Test
	void getAddressByIdKenId1CityId0TownId0() throws Exception {
		this.mockMvc
				.perform(post("/api/v1/getAddressById").param("kenId", "23")
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$", hasSize(73)))
				.andExpect(jsonPath("$[24].zip").isEmpty()).andExpect(jsonPath("$[24].kenId").value(23))
				.andExpect(jsonPath("$[24].kenName").value("愛知県")).andExpect(jsonPath("$[24].cityId").value(23209))
				.andExpect(jsonPath("$[24].cityName").value("碧南市")).andExpect(jsonPath("$[24].townName").isEmpty())
				.andExpect(jsonPath("$[24].townId").isEmpty()).andExpect(jsonPath("$[24].concatAddress").isEmpty());
	}

	@Test
	void getAddressByIdKenId1CityId1TownId0() throws Exception {
		this.mockMvc
				.perform(post("/api/v1/getAddressById").param("kenId", "23").param("cityId", "23102")
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$", hasSize(73)))
				.andExpect(jsonPath("$[24].zip").isEmpty()).andExpect(jsonPath("$[24].kenId").value(23))
				.andExpect(jsonPath("$[24].kenName").value("愛知県")).andExpect(jsonPath("$[24].cityId").value(23209))
				.andExpect(jsonPath("$[24].cityName").value("碧南市")).andExpect(jsonPath("$[24].townName").isEmpty())
				.andExpect(jsonPath("$[24].townId").isEmpty()).andExpect(jsonPath("$[24].concatAddress").isEmpty());
	}

	@Test
	void getAddressByIdKenId1CityId0TownId1() throws Exception {
		this.mockMvc
				.perform(post("/api/v1/getAddressById").param("kenId", "23").param("townId", "231020001")
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$", hasSize(73)))
				.andExpect(jsonPath("$[24].zip").isEmpty()).andExpect(jsonPath("$[24].kenId").value(23))
				.andExpect(jsonPath("$[24].kenName").value("愛知県")).andExpect(jsonPath("$[24].cityId").value(23209))
				.andExpect(jsonPath("$[24].cityName").value("碧南市")).andExpect(jsonPath("$[0].townName").isEmpty())
				.andExpect(jsonPath("$[0].townId").isEmpty()).andExpect(jsonPath("$[24].concatAddress").isEmpty());
	}

	@Test
	void getAddressByIdKenId1CityId1TownId1() throws Exception {
		this.mockMvc
				.perform(post("/api/v1/getAddressById").param("kenId", "23").param("cityId", "23102")
						.param("townId", "231020001").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$", hasSize(73)))
				.andExpect(jsonPath("$[24].zip").isEmpty()).andExpect(jsonPath("$[24].kenId").value(23))
				.andExpect(jsonPath("$[24].kenName").value("愛知県")).andExpect(jsonPath("$[24].cityId").value(23209))
				.andExpect(jsonPath("$[24].cityName").value("碧南市")).andExpect(jsonPath("$[24].townName").isEmpty())
				.andExpect(jsonPath("$[24].townId").isEmpty()).andExpect(jsonPath("$[24].concatAddress").isEmpty());
	}

	@Test
	void getAddressByIdKenId0CityId1TownId1() throws Exception {
		this.mockMvc
				.perform(post("/api/v1/getAddressById").param("cityId", "23102").param("townId", "231020001")
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$", hasSize(43)))
				.andExpect(jsonPath("$[24].zip").isEmpty()).andExpect(jsonPath("$[24].kenId").value(23))
				.andExpect(jsonPath("$[24].kenName").value("愛知県")).andExpect(jsonPath("$[24].cityId").value(23102))
				.andExpect(jsonPath("$[24].cityName").value("名古屋市東区")).andExpect(jsonPath("$[24].townName").value("徳川"))
				.andExpect(jsonPath("$[24].townId").value("231020024"))
				.andExpect(jsonPath("$[24].concatAddress").isEmpty());
	}

	@Test
	void getAddressByIdKenId0CityId1TownId0() throws Exception {
		this.mockMvc
				.perform(post("/api/v1/getAddressById").param("cityId", "23102")
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$", hasSize(43)))
				.andExpect(jsonPath("$[24].zip").isEmpty()).andExpect(jsonPath("$[24].kenId").value(23))
				.andExpect(jsonPath("$[24].kenName").value("愛知県")).andExpect(jsonPath("$[24].cityId").value(23102))
				.andExpect(jsonPath("$[24].cityName").value("名古屋市東区")).andExpect(jsonPath("$[24].townName").value("徳川"))
				.andExpect(jsonPath("$[24].townId").value("231020024"))
				.andExpect(jsonPath("$[24].concatAddress").isEmpty());
	}

	@Test
	void getAddressByIdKenId0CityId0TownId1() throws Exception {
		this.mockMvc
				.perform(post("/api/v1/getAddressById").param("townId", "231020005")
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$", hasSize(10)))
				.andExpect(jsonPath("$[6].zip").value("461-8555")).andExpect(jsonPath("$[6].kenId").value(23))
				.andExpect(jsonPath("$[6].kenName").value("愛知県")).andExpect(jsonPath("$[6].cityId").value(23102))
				.andExpect(jsonPath("$[6].cityName").value("名古屋市東区")).andExpect(jsonPath("$[6].townName").value("泉"))
				.andExpect(jsonPath("$[6].townId").value("231020005"))
				.andExpect(jsonPath("$[6].concatAddress").value("愛知県名古屋市東区泉３丁目４－３"));
	}

	@Test
	void getAddressByIdKenId0CityId0TownId0() throws Exception {
		this.mockMvc.perform(post("/api/v1/getAddressById").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isBadRequest());
	}

}
