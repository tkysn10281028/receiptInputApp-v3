package com.sono.mybatch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sono.mybatch.dto.ItemInfoSearchResultDto;
import com.sono.mybatch.model.ItemInfoSearchResultModel;
import com.sono.mybatch.repository.SearchRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SearchResultService {
	@Autowired
	SearchRepository searchRepository;

	public List<ItemInfoSearchResultModel> getResultBySearchWord(String searchWord) {
		var searchResultModelList = searchRepository.getResultBySearchWord(searchWord);
		// 検索結果が取得できない場合は検索条件を変えて再検索
		if (searchResultModelList.size() == 0) {
			return searchRepository.getResultForSearchBySearchWord(searchWord);
		} else {
			return searchResultModelList;
		}
	}

	public List<ItemInfoSearchResultDto> getCategories() {
		var list = new ArrayList<ItemInfoSearchResultDto>();
		searchRepository.getCategories().forEach((category) -> {
//			list.add(beanMapper.map(category, ItemInfoSearchResultDto.class));
		});
		return list;
	}
}