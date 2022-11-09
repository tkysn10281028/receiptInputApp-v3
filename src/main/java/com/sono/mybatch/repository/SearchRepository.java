package com.sono.mybatch.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sono.mybatch.model.ItemInfoSearchResultModel;

@Mapper
public interface SearchRepository {
	/**
	 * 検索API 通常パターン
	 * 
	 * @param searchWord
	 * @return
	 */
	public List<ItemInfoSearchResultModel> getResultBySearchWord(@Param("searchWord") String searchWord);

	/**
	 * 検索API 再検索
	 * 
	 * @param searchWord
	 * @return
	 */
	public List<ItemInfoSearchResultModel> getResultForSearchBySearchWord(@Param("searchWord") String searchWord);
}
