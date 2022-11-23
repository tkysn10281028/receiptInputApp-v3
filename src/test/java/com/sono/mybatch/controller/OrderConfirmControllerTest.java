package com.sono.mybatch.controller;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.sono.mybatch.security.JwtUtils;
import com.sono.mybatch.service.GenerateNonJwtService;
import com.sono.mybatch.service.OrderConfirmService;
import com.sono.mybatch.testrepository.OrderConfirmRepositoryForTest;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
@Slf4j
class OrderConfirmControllerTest {
	private String accessToken = "";
	@Autowired
	OrderConfirmRepositoryForTest confirmRepositoryForTest;
	@Autowired
	MockMvc mockMvc;
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	GenerateNonJwtService generateNonJwtService;
	@Autowired
	OrderConfirmService confirmService;

	@BeforeAll
	public void insertTestLoginData() {
		confirmRepositoryForTest.deleteTestDataLoginInfo();
		confirmRepositoryForTest.deleteTestDataDestinationInfo();
		confirmRepositoryForTest.deleteTestDataSettlementInfo();
		confirmRepositoryForTest.deleteTestDataOrderItemInfo();
		confirmRepositoryForTest.insertTestDataLoginInfo();
		this.accessToken += jwtUtils.generateAccessToken("test@test.com");
		log.info("access token for OrderConfirmControllerTest: {}", this.accessToken);
	}

	@AfterAll
	public void deleteAllTestData() {
		confirmRepositoryForTest.deleteTestDataLoginInfo();
		confirmRepositoryForTest.deleteTestDataDestinationInfo();
		confirmRepositoryForTest.deleteTestDataSettlementInfo();
		confirmRepositoryForTest.deleteTestDataOrderItemInfo();
	}

	@Test
	void testGetPersonalInfoByAuthenticationDestination2Settlement2OrderItem4() throws Exception {
		confirmRepositoryForTest.deleteTestDataDestinationInfo();
		confirmRepositoryForTest.deleteTestDataSettlementInfo();
		confirmRepositoryForTest.deleteTestDataOrderItemInfo();
		confirmRepositoryForTest.insertTestDataDestinationInfo();
		confirmRepositoryForTest.insertTestDataSettlementInfo();
		confirmRepositoryForTest.insertTestDataOrderItemInfo();
		this.mockMvc

				.perform(post("/api/v1/getPersonalInfoByAuthentication").header("Authorization", this.accessToken)
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(status().isOk()).andExpect(jsonPath("$").isArray())
				.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].loginId").value("L000"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].destinationInfoLoginBranch").value(1))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].destinationEmailAddress").value("test@test.com"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].destinationName").value("testname"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].destinationTelNo").value("00000000000"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].destinationPostalCode").value("0000000"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].destinationPrefecture").value("PREFECTURE"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].destinationCity").value("CITY"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].destinationTown").value("TOWN"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].destinationTownNo").value("0-0-0"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].destinationBuilding").value("BUILDING"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].destinationRoomNo").value("ROOMNO"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].personalName").value("test"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].personalTelNo").value("00000000000"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].personalPostalCode").value("0000000"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].personalPrefecture").value("PREFECTURE"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].personalCity").value("CITY"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].personalTown").value("TOWN"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].personalTownNo").value("0-0-0"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].personalBuilding").value("BUILDING"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].personalRoomNo").value("ROOMNO"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].destinationInfoLoginBranch").value(2))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].destinationEmailAddress").value("あいえうお"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].destinationName").value("名前"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].destinationTelNo").value("00000000000"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].destinationPostalCode").value("0000000"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].destinationPrefecture").value("県"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].destinationCity").value("市"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].destinationTown").value("町"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].destinationTownNo").value("0000000"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].destinationBuilding").value("建物"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].destinationRoomNo").value("部屋"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].personalName").value("名前"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].personalTelNo").value("00000000000"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].personalPostalCode").value("０００００００"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].personalPrefecture").value("県"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].personalCity").value("市"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].personalTown").value("町"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].personalTownNo").value("００００"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].personalBuilding").value("建物"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].personalRoomNo").value("部屋番号"))
				.andExpect(jsonPath("$[0].settlementInfoResultDtos[0].settlementInfoLoginBranch").value(1))
				.andExpect(jsonPath("$[0].settlementInfoResultDtos[0].cardCompanyId").value("C000"))
				.andExpect(jsonPath("$[0].settlementInfoResultDtos[0].creditCardNo").value("000000000000000000000"))
				.andExpect(jsonPath("$[0].settlementInfoResultDtos[0].securityCode").value("0000"))
				.andExpect(jsonPath("$[0].settlementInfoResultDtos[0].expireDate").value("202304"))
				.andExpect(jsonPath("$[0].settlementInfoResultDtos[1].settlementInfoLoginBranch").value(2))
				.andExpect(jsonPath("$[0].settlementInfoResultDtos[1].cardCompanyId").value("C000"))
				.andExpect(jsonPath("$[0].settlementInfoResultDtos[1].creditCardNo").value("9999999999999999999999"))
				.andExpect(jsonPath("$[0].settlementInfoResultDtos[1].securityCode").value("9999"))
				.andExpect(jsonPath("$[0].settlementInfoResultDtos[1].expireDate").value("999999"))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[0].orderItemId").value("i0000001"))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[0].orderItemPrice").value(500))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[0].discountDiv").value("d000"))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[0].discountMoney").value(0))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[1].orderItemId").value("i0000002"))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[1].orderItemPrice").value(600))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[1].discountDiv").value("d000"))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[1].discountMoney").value(0))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[2].orderItemId").value("i0000003"))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[2].orderItemPrice").value(700))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[2].discountDiv").value("d000"))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[2].discountMoney").value(0))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[3].orderItemId").value("i0000004"))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[3].orderItemPrice").value(800))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[3].discountDiv").value("d000"))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[3].discountMoney").value(0));

	}

	@Test
	void testGetPersonalInfoByAuthenticationUsingJwtId() throws Exception {
		confirmRepositoryForTest.deleteTestDataDestinationInfo();
		confirmRepositoryForTest.deleteTestDataSettlementInfo();
		confirmRepositoryForTest.deleteTestDataOrderItemInfo();
		confirmRepositoryForTest.insertTestDataDestinationInfo();
		confirmRepositoryForTest.insertTestDataSettlementInfo();
		confirmRepositoryForTest.insertTestDataOrderItemInfo();
		String tokenId = generateNonJwtService.generateNonJwtToken(this.accessToken, "test@test.com");
		this.mockMvc
				.perform(post("/api/v1/getPersonalInfoByAuthentication").header("Authorization", tokenId)
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(status().isOk()).andExpect(jsonPath("$").isArray())
				.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].loginId").value("L000"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].destinationInfoLoginBranch").value(1))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].destinationEmailAddress").value("test@test.com"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].destinationName").value("testname"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].destinationTelNo").value("00000000000"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].destinationPostalCode").value("0000000"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].destinationPrefecture").value("PREFECTURE"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].destinationCity").value("CITY"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].destinationTown").value("TOWN"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].destinationTownNo").value("0-0-0"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].destinationBuilding").value("BUILDING"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].destinationRoomNo").value("ROOMNO"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].personalName").value("test"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].personalTelNo").value("00000000000"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].personalPostalCode").value("0000000"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].personalPrefecture").value("PREFECTURE"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].personalCity").value("CITY"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].personalTown").value("TOWN"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].personalTownNo").value("0-0-0"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].personalBuilding").value("BUILDING"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[0].personalRoomNo").value("ROOMNO"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].destinationInfoLoginBranch").value(2))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].destinationEmailAddress").value("あいえうお"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].destinationName").value("名前"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].destinationTelNo").value("00000000000"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].destinationPostalCode").value("0000000"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].destinationPrefecture").value("県"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].destinationCity").value("市"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].destinationTown").value("町"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].destinationTownNo").value("0000000"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].destinationBuilding").value("建物"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].destinationRoomNo").value("部屋"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].personalName").value("名前"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].personalTelNo").value("00000000000"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].personalPostalCode").value("０００００００"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].personalPrefecture").value("県"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].personalCity").value("市"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].personalTown").value("町"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].personalTownNo").value("００００"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].personalBuilding").value("建物"))
				.andExpect(jsonPath("$[0].destinationInfoResultDtos[1].personalRoomNo").value("部屋番号"))
				.andExpect(jsonPath("$[0].settlementInfoResultDtos[0].settlementInfoLoginBranch").value(1))
				.andExpect(jsonPath("$[0].settlementInfoResultDtos[0].cardCompanyId").value("C000"))
				.andExpect(jsonPath("$[0].settlementInfoResultDtos[0].creditCardNo").value("000000000000000000000"))
				.andExpect(jsonPath("$[0].settlementInfoResultDtos[0].securityCode").value("0000"))
				.andExpect(jsonPath("$[0].settlementInfoResultDtos[0].expireDate").value("202304"))
				.andExpect(jsonPath("$[0].settlementInfoResultDtos[1].settlementInfoLoginBranch").value(2))
				.andExpect(jsonPath("$[0].settlementInfoResultDtos[1].cardCompanyId").value("C000"))
				.andExpect(jsonPath("$[0].settlementInfoResultDtos[1].creditCardNo").value("9999999999999999999999"))
				.andExpect(jsonPath("$[0].settlementInfoResultDtos[1].securityCode").value("9999"))
				.andExpect(jsonPath("$[0].settlementInfoResultDtos[1].expireDate").value("999999"))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[0].orderItemId").value("i0000001"))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[0].orderItemPrice").value(500))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[0].discountDiv").value("d000"))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[0].discountMoney").value(0))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[1].orderItemId").value("i0000002"))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[1].orderItemPrice").value(600))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[1].discountDiv").value("d000"))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[1].discountMoney").value(0))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[2].orderItemId").value("i0000003"))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[2].orderItemPrice").value(700))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[2].discountDiv").value("d000"))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[2].discountMoney").value(0))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[3].orderItemId").value("i0000004"))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[3].orderItemPrice").value(800))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[3].discountDiv").value("d000"))
				.andExpect(jsonPath("$[0].orderItemInfoResultDtos[3].discountMoney").value(0));
	}
}
