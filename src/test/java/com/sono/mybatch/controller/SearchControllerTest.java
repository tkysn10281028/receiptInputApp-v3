package com.sono.mybatch.controller;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sono.mybatch.security.JwtUtils;
import com.sono.mybatch.service.SearchResultService;
import com.sono.mybatch.utils.LogUtils;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
@Slf4j
class SearchControllerTest {
	private String accessToken = "";
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	SearchResultService resultService;
	@MockBean
	LogUtils logUtils;
	@Autowired
	JwtUtils jwtUtils;

	@BeforeAll
	public void generateAccessToken() {
		this.accessToken += jwtUtils.generateAccessToken("tkysn1028@gmail.com");
		log.info("access token : {}", this.accessToken);
	}

	@Test
	void testGetResultBySearchWordByZero() throws JsonProcessingException, Exception {
		mockMvc.perform(post("/api/v1/getResultBySearchWord").param("searchWord", "0")
				.header("Authorization", this.accessToken).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].itemId").value("i0000001")).andExpect(jsonPath("$[0].itemName").value("0"))
				.andExpect(jsonPath("$[0].itemPrice").value(500)).andExpect(jsonPath("$[0].itemMajorDiv").value("000"))
				.andExpect(jsonPath("$[0].itemMajorName").value("大分類テスト用"))
				.andExpect(jsonPath("$[0].itemMiddleDiv").value("000"))
				.andExpect(jsonPath("$[0].itemMiddleName").value("中分類テスト用"))
				.andExpect(jsonPath("$[0].itemMinorDiv").value("000"))
				.andExpect(jsonPath("$[0].itemMinorName").value("大分類テスト用"))
				.andExpect(jsonPath("$[0].itemDiscountDiv").value("id000"))
				.andExpect(jsonPath("$[0].itemDiscountRate").value(1));
	}

	@Test
	void testGetResultBySearchWordByLowerA() throws JsonProcessingException, Exception {
		mockMvc.perform(post("/api/v1/getResultBySearchWord").param("searchWord", "a")
				.header("Authorization", this.accessToken).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].itemId").value("i0000002")).andExpect(jsonPath("$[0].itemName").value("a"))
				.andExpect(jsonPath("$[0].itemPrice").value(600));
	}

	@Test
	void testGetResultBySearchWordByUpperA() throws JsonProcessingException, Exception {
		mockMvc.perform(post("/api/v1/getResultBySearchWord").param("searchWord", "A")
				.header("Authorization", this.accessToken).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].itemId").value("i0000003")).andExpect(jsonPath("$[0].itemName").value("A"))
				.andExpect(jsonPath("$[0].itemPrice").value(700));
	}

	@Test
	void testGetResultBySearchWordByJapaneseA() throws JsonProcessingException, Exception {
		mockMvc.perform(post("/api/v1/getResultBySearchWord").param("searchWord", "あ")
				.header("Authorization", this.accessToken).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].itemId").value("i0000004")).andExpect(jsonPath("$[0].itemName").value("あ"))
				.andExpect(jsonPath("$[0].itemPrice").value(800));
	}

	@Test
	void testGetResultBySearchWordByJapaneseAKatakana() throws JsonProcessingException, Exception {
		mockMvc.perform(post("/api/v1/getResultBySearchWord").param("searchWord", "ア")
				.header("Authorization", this.accessToken).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].itemId").value("i0000005")).andExpect(jsonPath("$[0].itemName").value("ア"))
				.andExpect(jsonPath("$[0].itemPrice").value(900));
	}

	@Test
	void testGetResultBySearchWordByJapaneseAKatakanaLower() throws JsonProcessingException, Exception {
		mockMvc.perform(post("/api/v1/getResultBySearchWord").param("searchWord", "ｱ")
				.header("Authorization", this.accessToken).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].itemId").value("i0000006")).andExpect(jsonPath("$[0].itemName").value("ｱ"))
				.andExpect(jsonPath("$[0].itemPrice").value(1000));
	}

	@Test
	void testGetResultBySearchWordToFiveChar() throws JsonProcessingException, Exception {
		mockMvc.perform(post("/api/v1/getResultBySearchWord").param("searchWord", "1")
				.header("Authorization", this.accessToken).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].itemId").value("i0000007"))
				.andExpect(jsonPath("$[0].itemName").value("12345")).andExpect(jsonPath("$[0].itemPrice").value(1100));
	}

	@Test
	void testGetResultBySearchWordToFiveCharTwoResults() throws JsonProcessingException, Exception {
		mockMvc.perform(post("/api/v1/getResultBySearchWord").param("searchWord", "2")
				.header("Authorization", this.accessToken).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].itemId").value("i0000007"))
				.andExpect(jsonPath("$[0].itemName").value("12345")).andExpect(jsonPath("$[0].itemPrice").value(1100))
				.andExpect(jsonPath("$[1].itemId").value("i0000008"))
				.andExpect(jsonPath("$[1].itemName").value("23456")).andExpect(jsonPath("$[1].itemPrice").value(1200));
	}

	@Test
	void testGetResultByTwoCharSearchWordToFiveCharTopSearch() throws JsonProcessingException, Exception {
		mockMvc.perform(post("/api/v1/getResultBySearchWord").param("searchWord", "12")
				.header("Authorization", this.accessToken).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].itemId").value("i0000007"))
				.andExpect(jsonPath("$[0].itemName").value("12345")).andExpect(jsonPath("$[0].itemPrice").value(1100));
	}

	@Test
	void testGetResultByTwoCharSearchWordToFiveCharMiddleSearch() throws JsonProcessingException, Exception {
		mockMvc.perform(post("/api/v1/getResultBySearchWord").param("searchWord", "34")
				.header("Authorization", this.accessToken).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$", hasSize(3)))
				.andExpect(jsonPath("$[0].itemId").value("i0000007"))
				.andExpect(jsonPath("$[0].itemName").value("12345")).andExpect(jsonPath("$[0].itemPrice").value(1100))
				.andExpect(jsonPath("$[1].itemId").value("i0000008"))
				.andExpect(jsonPath("$[1].itemName").value("23456")).andExpect(jsonPath("$[1].itemPrice").value(1200))
				.andExpect(jsonPath("$[2].itemId").value("i0000009"))
				.andExpect(jsonPath("$[2].itemName").value("34567")).andExpect(jsonPath("$[2].itemPrice").value(1300));
	}

	@Test
	void testGetResultByTwoCharSearchWordToFiveCharLastSearch() throws JsonProcessingException, Exception {
		mockMvc.perform(post("/api/v1/getResultBySearchWord").param("searchWord", "89")
				.header("Authorization", this.accessToken).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].itemId").value("i0000012"))
				.andExpect(jsonPath("$[0].itemName").value("56789")).andExpect(jsonPath("$[0].itemPrice").value(1500));
	}

	@Test
	void testGetResultByFoundByItemNameForSearchPattern() throws JsonProcessingException, Exception {
		mockMvc.perform(post("/api/v1/getResultBySearchWord").param("searchWord", "ｲ")
				.header("Authorization", this.accessToken).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].itemId").value("i0000013"))
				.andExpect(jsonPath("$[0].itemName").value("ｱｲｳｴｵ")).andExpect(jsonPath("$[0].itemPrice").value(1600));
	}

	@Test
	void testGetResultByNotFoundPattern() throws JsonProcessingException, Exception {
		mockMvc.perform(post("/api/v1/getResultBySearchWord").param("searchWord", "ｶ")
				.header("Authorization", this.accessToken).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$", hasSize(0)));
	}

}
