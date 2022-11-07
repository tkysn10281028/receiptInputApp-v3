package com.sono.mybatch;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sono.mybatch.controller.IndexController;

@SpringBootTest
class ReceiptInputWebApplicationTests {
	@Autowired
	IndexController controller;

	@Test
	void contextLoads() {
		assertNotNull(controller);
	}

}
