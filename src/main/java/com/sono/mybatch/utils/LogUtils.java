package com.sono.mybatch.utils;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LogUtils {
	public void getCalledAPIFirstLog(String methodName, String... parameters) {
		log.info("Method " + methodName + " is Called.Requested Parameters are : {}", parameters);
	}
}
