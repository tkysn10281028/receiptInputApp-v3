package com.sono.mybatch.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sono.mybatch.dto.ItemInfoSearchResultDto;
import com.sono.mybatch.service.SearchResultService;
import com.sono.mybatch.utils.LogUtils;

@RestController
public class SearchController {
	@Autowired
	LogUtils logUtils;

	@Autowired
	SearchResultService resultService;

	@RequestMapping(path = "/api/v1/getResultBySearchWord", method = RequestMethod.POST)
	public ResponseEntity<List<ItemInfoSearchResultDto>> getResultBySearchWord(
			@RequestParam(value = "searchWord", required = true) String searchWord) {
		logUtils.getCalledAPIFirstLog(Thread.currentThread().getStackTrace()[1].getMethodName(), searchWord);

		HttpHeaders headers = new HttpHeaders();
//		dto for test
		var list = new ArrayList<ItemInfoSearchResultDto>();
		list.add(new ItemInfoSearchResultDto("i00000", "", 0, "", "", "", "", "", "", "", 0.0));
//		dto for test end
		return new ResponseEntity<List<ItemInfoSearchResultDto>>(list, headers, HttpStatus.OK);
	}
}
