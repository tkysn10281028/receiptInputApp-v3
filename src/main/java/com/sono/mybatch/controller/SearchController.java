package com.sono.mybatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sono.mybatch.service.SearchResultService;
import com.sono.mybatch.utils.LogUtils;

@RestController
public class SearchController {
	@Autowired
	LogUtils logUtils;

	@Autowired
	SearchResultService resultService;

	@RequestMapping("/api/v1/getResultBySearchWord")
	public void getResultBySearchWord(@RequestParam("searchWord") String searchWord) {
		logUtils.getCalledAPIFirstLog(Thread.currentThread().getStackTrace()[1].getMethodName(), searchWord);

	}
}
