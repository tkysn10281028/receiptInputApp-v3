package com.sono.mybatch.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sono.mybatch.model.ItemInfoSearchResultModel;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
class SearchResultServiceTest {
	@Autowired
	SearchResultService resultService;

	@Test
	void testGetResultBySearchWord() {
		List<ItemInfoSearchResultModel> result = resultService.getResultBySearchWord("12345");
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
		assertEquals(1.0, result.get(0).getItemDiscountRate());
	}

	@Test
	void testGetResultBySearchWordByItemNameForSearch() {
		List<ItemInfoSearchResultModel> result = resultService.getResultBySearchWord("ｲ");
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
		assertEquals(1.0, result.get(0).getItemDiscountRate());
	}

	@Test
	void testGetResultBySearchWordByItemNameNotFound() {
		List<ItemInfoSearchResultModel> result = resultService.getResultBySearchWord("unknown");
		assertEquals(0, result.size());
	}

}
