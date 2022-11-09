package com.sono.mybatch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sono.mybatch.model.ItemInfoSearchResultModel;
import com.sono.mybatch.service.SearchResultService;
import com.sono.mybatch.utils.LogUtils;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SearchController {
	@Autowired
	LogUtils logUtils;

	@Autowired
	SearchResultService resultService;

	@RequestMapping(path = "/api/v1/getResultBySearchWord", method = RequestMethod.POST)
	public ResponseEntity<List<ItemInfoSearchResultModel>> getResultBySearchWord(
			@RequestParam(value = "searchWord", required = true) String searchWord) {
		logUtils.getCalledAPIFirstLog(Thread.currentThread().getStackTrace()[1].getMethodName(), searchWord);
		HttpHeaders headers = new HttpHeaders();
		var result = resultService.getResultBySearchWord(searchWord);
		log.info("Search Result : {}", result);
		return new ResponseEntity<List<ItemInfoSearchResultModel>>(result, headers, HttpStatus.OK);

	}
}
