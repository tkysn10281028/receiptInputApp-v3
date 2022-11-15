package com.sono.mybatch.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchCategoryController {

	@RequestMapping(path = "/api/v1/getAllCategory", method = RequestMethod.GET)
	public ResponseEntity<String> getAllCategory() {
		return null;
	}
}