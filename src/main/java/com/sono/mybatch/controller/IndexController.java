package com.sono.mybatch.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String getIndex(HttpServletRequest req) {
		return "index";
	}
}
