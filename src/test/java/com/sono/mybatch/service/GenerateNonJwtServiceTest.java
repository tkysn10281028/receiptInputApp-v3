package com.sono.mybatch.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sono.mybatch.repository.GenerateNonJwtRepository;
import com.sono.mybatch.security.JwtUtils;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
class GenerateNonJwtServiceTest {
	@Autowired
	GenerateNonJwtService generateNonJwtService;

	@Autowired
	GenerateNonJwtRepository generateNonJwtRepository;

	@Autowired
	JwtUtils jwtUtils;

	@BeforeAll
	public void insertTestDataBeforeAll() {
		var result1 = generateNonJwtService.generateNonJwtToken("", "tkysn1028@gmail.com");
		jwtTokenIdList.add(result1);
		var result2 = generateNonJwtService.generateNonJwtToken(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0a3lzbjEwMjhAZ21haWwuY29tIiwiaXNzIjoiY29tLnNvbm8ubXliYXRjaCIsImlhdCI6MTY2NzcxOTczOCwiZXhwIjoxNjY4MzI0NTM4fQ.ISCX9j6isOda5LgTD6hAkMgpo1ijYCZ0_zRez1xNlvg",
				"tkysn1028@gmail.com");
		jwtTokenIdList.add(result2);
		var result3 = generateNonJwtService.generateNonJwtToken(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0a3lzbjEwMjhAZ21haWwuY29tIiwiaXNzIjoiY29tLnNvbm8ubXliYXRjaCIsImlhdCI6MTY2ODA4NTEyNiwiZXhwIjoxNjY4Njg5OTI2fQ.X57wfgrH4W9orrRc-EZftqWspTlUi0aC0UoP6sgatT0",
				"tkysn1028@gmail.com");
		jwtTokenIdList.add(result3);
		var result4 = generateNonJwtService.generateNonJwtToken(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0a3lzbjEwMjhAZ21haWwuY29tIiwiaXNzIjoiY29tLnNvbm8ubXliYXRjaCIsImlhdCI6MTY2ODA4NTEyNywiZXhwIjoxNjY4Njg5OTI3fQ.QqUbrXmPKQIETjId95y8Ccot1gs_vAiyPqqd3zCF5O0",
				"tkysn1028@gmail.com");
		jwtTokenIdList.add(result4);
	}

	@AfterAll
	public void deleteTestDataAfterAll() {
		generateNonJwtRepository.deleteInsertedJwtTokenId();
	}

	private List<String> jwtTokenIdList = new ArrayList<>();

	@Test
	void testGenerateNonJwtTokenByBlank() {
		assertEquals("",
				generateNonJwtRepository.searchJwtTokenByJwtTokenId(jwtUtils.removeJwtIdBearer(jwtTokenIdList.get(0))));
	}

	@Test
	void testGenerateNonJwtTokenByNull() {
		try {
			var result = generateNonJwtService.generateNonJwtToken(null, "tkysn1028@gmail.com");
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().matches(".*Not valid Token."));
		}
	}

	@Test
	void testGenerateNonJwtTokenByCorrectJwtToken1() {
		assertEquals(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0a3lzbjEwMjhAZ21haWwuY29tIiwiaXNzIjoiY29tLnNvbm8ubXliYXRjaCIsImlhdCI6MTY2NzcxOTczOCwiZXhwIjoxNjY4MzI0NTM4fQ.ISCX9j6isOda5LgTD6hAkMgpo1ijYCZ0_zRez1xNlvg",
				generateNonJwtRepository.searchJwtTokenByJwtTokenId(jwtUtils.removeJwtIdBearer(jwtTokenIdList.get(1))));
	}

	@Test
	void testGenerateNonJwtTokenByCorrectJwtToken2() {
		assertEquals(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0a3lzbjEwMjhAZ21haWwuY29tIiwiaXNzIjoiY29tLnNvbm8ubXliYXRjaCIsImlhdCI6MTY2ODA4NTEyNiwiZXhwIjoxNjY4Njg5OTI2fQ.X57wfgrH4W9orrRc-EZftqWspTlUi0aC0UoP6sgatT0",
				generateNonJwtRepository.searchJwtTokenByJwtTokenId(jwtUtils.removeJwtIdBearer(jwtTokenIdList.get(2))));
	}

	@Test
	void testGenerateNonJwtTokenByCorrectJwtToken3() {
		assertEquals(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0a3lzbjEwMjhAZ21haWwuY29tIiwiaXNzIjoiY29tLnNvbm8ubXliYXRjaCIsImlhdCI6MTY2ODA4NTEyNywiZXhwIjoxNjY4Njg5OTI3fQ.QqUbrXmPKQIETjId95y8Ccot1gs_vAiyPqqd3zCF5O0",
				generateNonJwtRepository.searchJwtTokenByJwtTokenId(jwtUtils.removeJwtIdBearer(jwtTokenIdList.get(3))));
	}

	@Test
	void testGenerateNonJwtTokenTestDifference() {
		assertTrue(!(jwtTokenIdList.get(0).equals(jwtTokenIdList.get(1)))
				&& !(jwtTokenIdList.get(0).equals(jwtTokenIdList.get(2)))
				&& !(jwtTokenIdList.get(0).equals(jwtTokenIdList.get(3)))
				&& !(jwtTokenIdList.get(1).equals(jwtTokenIdList.get(2)))
				&& !(jwtTokenIdList.get(1).equals(jwtTokenIdList.get(3)))
				&& !(jwtTokenIdList.get(2).equals(jwtTokenIdList.get(3))));
	}

	@Test
	void testGenerateNonJwtTokenCheckContain() {
		assertTrue(StringUtils.contains(jwtTokenIdList.get(0), "jwtid: ")
				&& StringUtils.contains(jwtTokenIdList.get(1), "jwtid: ")
				&& StringUtils.contains(jwtTokenIdList.get(2), "jwtid: ")
				&& StringUtils.contains(jwtTokenIdList.get(3), "jwtid: "));
	}

	@Test
	void testSearchJwtTokenByJwtIdSearchByBlank() {
		try {
			generateNonJwtService.searchJwtTokenByJwtId("");
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().matches(".*Not valid Jwt Id."));
		}
	}

	@Test
	void testSearchJwtTokenByJwtIdSearchByNull() {
		try {
			generateNonJwtService.searchJwtTokenByJwtId(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().matches(".*Not valid Jwt Id."));
		}
	}

	@Test
	void testSearchJwtTokenByJwtIdSearchByNonBearer() {
		try {
			generateNonJwtService.searchJwtTokenByJwtId(StringUtils.replace(jwtTokenIdList.get(0), "jwtid: ", ""));
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().matches(".*No Bearer Found For Jwt Id."));
		}
	}

	@Test
	void testSearchJwtTokenByJwtIdSearchByCorrectJwtId1() {
		var result = generateNonJwtService.searchJwtTokenByJwtId(jwtTokenIdList.get(0));
		assertEquals("", result);
	}

	@Test
	void testSearchJwtTokenByJwtIdSearchByCorrectJwtId2() {
		var result = generateNonJwtService.searchJwtTokenByJwtId(jwtTokenIdList.get(1));
		assertEquals(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0a3lzbjEwMjhAZ21haWwuY29tIiwiaXNzIjoiY29tLnNvbm8ubXliYXRjaCIsImlhdCI6MTY2NzcxOTczOCwiZXhwIjoxNjY4MzI0NTM4fQ.ISCX9j6isOda5LgTD6hAkMgpo1ijYCZ0_zRez1xNlvg",
				result);
	}

	@Test
	void testSearchJwtTokenByJwtIdSearchByCorrectJwtId3() {
		var result = generateNonJwtService.searchJwtTokenByJwtId(jwtTokenIdList.get(2));
		assertEquals(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0a3lzbjEwMjhAZ21haWwuY29tIiwiaXNzIjoiY29tLnNvbm8ubXliYXRjaCIsImlhdCI6MTY2ODA4NTEyNiwiZXhwIjoxNjY4Njg5OTI2fQ.X57wfgrH4W9orrRc-EZftqWspTlUi0aC0UoP6sgatT0",
				result);
	}

	@Test
	void testSearchJwtTokenByJwtIdSearchByCorrectJwtId4() {
		var result = generateNonJwtService.searchJwtTokenByJwtId(jwtTokenIdList.get(3));
		assertEquals(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0a3lzbjEwMjhAZ21haWwuY29tIiwiaXNzIjoiY29tLnNvbm8ubXliYXRjaCIsImlhdCI6MTY2ODA4NTEyNywiZXhwIjoxNjY4Njg5OTI3fQ.QqUbrXmPKQIETjId95y8Ccot1gs_vAiyPqqd3zCF5O0",
				result);

	}

	@Test
	void testDeleteJwtToken1() {
		var result = generateNonJwtService.generateNonJwtToken("", "tkysn1028@gmail.com");
		generateNonJwtService.deleteJwtTokenId(result);
		assertEquals(null, generateNonJwtRepository.searchJwtTokenByJwtTokenId(jwtUtils.removeJwtIdBearer(result)));
	}

	@Test
	void testDeleteJwtToken2() {
		var result = generateNonJwtService.generateNonJwtToken(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0a3lzbjEwMjhAZ21haWwuY29tIiwiaXNzIjoiY29tLnNvbm8ubXliYXRjaCIsImlhdCI6MTY2ODA4NTEyNywiZXhwIjoxNjY4Njg5OTI3fQ.QqUbrXmPKQIETjId95y8Ccot1gs_vAiyPqqd3zCF5O0",
				"tkysn1028@gmail.com");
		generateNonJwtService.deleteJwtTokenId(result);
		assertEquals(null, generateNonJwtRepository.searchJwtTokenByJwtTokenId(jwtTokenIdList.get(1)));
	}

	@Test
	void testDeleteJwtTokenByEmailAddress() {
		var result = generateNonJwtService.generateNonJwtToken(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0a3lzbjEwMjhAZ21haWwuY29tIiwiaXNzIjoiY29tLnNvbm8ubXliYXRjaCIsImlhdCI6MTY2ODA4NTEyNywiZXhwIjoxNjY4Njg5OTI3fQ.QqUbrXmPKQIETjId95y8Ccot1gs_vAiyPqqd3zCF5O0",
				"test@test.com");
		generateNonJwtService.deleteJwtTokenIdByEmailAddress("test@test.com");
		assertEquals(null, generateNonJwtRepository.searchJwtTokenByJwtTokenId(result));
	}

	@Test
	void testDeleteJwtTokenByEmailAddressNullPattern() {
		try {

			var result = generateNonJwtService.generateNonJwtToken(
					"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0a3lzbjEwMjhAZ21haWwuY29tIiwiaXNzIjoiY29tLnNvbm8ubXliYXRjaCIsImlhdCI6MTY2ODA4NTEyNywiZXhwIjoxNjY4Njg5OTI3fQ.QqUbrXmPKQIETjId95y8Ccot1gs_vAiyPqqd3zCF5O0",
					null);
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().matches(".*User Authentication Is Invalid."));
		}
	}
}
