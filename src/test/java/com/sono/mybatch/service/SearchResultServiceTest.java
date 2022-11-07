package com.sono.mybatch.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
class SearchResultServiceTest {
	@MockBean
	SearchResultService resultService;

	@Test
	void testGetResultBySearchWord() {
		var result = resultService.getResultBySearchWord("12345");
		assertEquals(1, result.size());
		assertEquals("i0000007", result.get(0).getItemId());
		assertEquals("12345", result.get(0).getItemName());
		assertEquals(1100, result.get(0).getItemPrice());
		assertEquals("000", result.get(0).getItemMajorDiv());
		assertEquals("大分類テスト用", result.get(0).getItemMajorName());
		assertEquals("000", result.get(0).getItemMiddleDiv());
		assertEquals("中分類テスト用", result.get(0).getItemMiddleName());
		assertEquals("000", result.get(0).getItemMinorDiv());
		assertEquals("小分類テスト用", result.get(0).getItemMinorName());
		assertEquals("id000", result.get(0).getItemDiscountDiv());
		assertEquals(1.0, result.get(0).getItemDiscountRate());
	}

	@Test
	void testGetResultBySearchWordByItemNameForSearch() {
		var result = resultService.getResultBySearchWord("ｲ");
		assertEquals(1, result.size());
		assertEquals("i0000013", result.get(0).getItemId());
		assertEquals("98765", result.get(0).getItemName());
		assertEquals(1600, result.get(0).getItemPrice());
		assertEquals("000", result.get(0).getItemMajorDiv());
		assertEquals("大分類テスト用", result.get(0).getItemMajorName());
		assertEquals("000", result.get(0).getItemMiddleDiv());
		assertEquals("中分類テスト用", result.get(0).getItemMiddleName());
		assertEquals("000", result.get(0).getItemMinorDiv());
		assertEquals("小分類テスト用", result.get(0).getItemMinorName());
		assertEquals("id000", result.get(0).getItemDiscountDiv());
		assertEquals(1.0, result.get(0).getItemDiscountRate());
	}

	@Test
	void testGetResultBySearchWordByItemNameNotFound() {
		var result = resultService.getResultBySearchWord("unknown");
		assertEquals(0, result.size());
	}

}
