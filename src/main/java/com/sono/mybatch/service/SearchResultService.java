package com.sono.mybatch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sono.mybatch.dto.ItemInfoSearchResultDto;

@Service
public class SearchResultService {
	public List<ItemInfoSearchResultDto> getResultBySearchWord(String searchWord) {
		// 渡された文字列でリポジトリを検索して結果を取得する

		// 取得できなかった場合には検索用商品名を検索する

		// 取得できなかった場合はサイズ0のリストを返却
		return null;
	}
}