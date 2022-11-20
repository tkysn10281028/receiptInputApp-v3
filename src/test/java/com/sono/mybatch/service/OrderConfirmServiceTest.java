package com.sono.mybatch.service;

import static org.junit.jupiter.api.Assertions.*;

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

import com.sono.mybatch.repository.OrderConfirmRepository;
import com.sono.mybatch.testrepository.OrderConfirmRepositoryForTest;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
class OrderConfirmServiceTest {
	@Autowired
	OrderConfirmRepositoryForTest confirmRepositoryForTest;
	@Autowired
	OrderConfirmRepository confirmRepository;

	@BeforeAll
	public void insertTestLoginData() {
		confirmRepositoryForTest.deleteTestDataLoginInfo();
		confirmRepositoryForTest.deleteTestDataDestinationInfo();
		confirmRepositoryForTest.deleteTestDataSettlementInfo();
		confirmRepositoryForTest.deleteTestDataOrderItemInfo();
		confirmRepositoryForTest.insertTestDataLoginInfo();
	}

	@AfterAll
	public void deleteAllTestData() {
		confirmRepositoryForTest.deleteTestDataLoginInfo();
		confirmRepositoryForTest.deleteTestDataDestinationInfo();
		confirmRepositoryForTest.deleteTestDataSettlementInfo();
		confirmRepositoryForTest.deleteTestDataOrderItemInfo();
	}

	@Test
	void testGetLoginIdByEmailAddress() {
		assertEquals("L000", confirmRepository.getLoginIdByEmailAddress("test@test.com"));
	}

	@Test
	void testGetLoginIdByEmailAddressBlank() {
		assertEquals(null, confirmRepository.getLoginIdByEmailAddress(""));
	}

	@Test
	void testGetPersonalInfoByAuthenticationDestination2Settlement2OrderItem4() {
		confirmRepositoryForTest.deleteTestDataDestinationInfo();
		confirmRepositoryForTest.deleteTestDataSettlementInfo();
		confirmRepositoryForTest.deleteTestDataOrderItemInfo();
		confirmRepositoryForTest.insertTestDataDestinationInfo();
		confirmRepositoryForTest.insertTestDataSettlementInfo();
		confirmRepositoryForTest.insertTestDataOrderItemInfo();
		assertEquals(2, confirmRepository.getDestinationInfoByLoginId("L000").size());
		assertEquals(2, confirmRepository.getSettlementInfoByLoginId("L000").size());
		assertEquals(4, confirmRepository.getOrderItemInfoByLoginId("L000").size());
		assertTrue(isDestinationExpected1());
		assertTrue(isDestinationExpected2());
		assertTrue(isSettlementInfoExpected1());
		assertTrue(isSettlementInfoExpected2());
		assertTrue(isOrderItemInfoExpected1());
		assertTrue(isOrderItemInfoExpected2());
		assertTrue(isOrderItemInfoExpected3());
		assertTrue(isOrderItemInfoExpected4());
	}

	@Test
	void testGetPersonalInfoByAuthenticationDestination0Settlement2OrderItem4() {
		confirmRepositoryForTest.deleteTestDataDestinationInfo();
		confirmRepositoryForTest.deleteTestDataSettlementInfo();
		confirmRepositoryForTest.deleteTestDataOrderItemInfo();
		confirmRepositoryForTest.insertTestDataSettlementInfo();
		confirmRepositoryForTest.insertTestDataOrderItemInfo();
		assertEquals(0, confirmRepository.getDestinationInfoByLoginId("L000").size());
		assertEquals(2, confirmRepository.getSettlementInfoByLoginId("L000").size());
		assertEquals(4, confirmRepository.getOrderItemInfoByLoginId("L000").size());
		assertTrue(isSettlementInfoExpected1());
		assertTrue(isSettlementInfoExpected2());
		assertTrue(isOrderItemInfoExpected1());
		assertTrue(isOrderItemInfoExpected2());
		assertTrue(isOrderItemInfoExpected3());
		assertTrue(isOrderItemInfoExpected4());
	}

	@Test
	void testGetPersonalInfoByAuthenticationDestination2Settlement0OrderItem4() {
		confirmRepositoryForTest.deleteTestDataDestinationInfo();
		confirmRepositoryForTest.deleteTestDataSettlementInfo();
		confirmRepositoryForTest.deleteTestDataOrderItemInfo();
		confirmRepositoryForTest.insertTestDataDestinationInfo();
		confirmRepositoryForTest.insertTestDataOrderItemInfo();
		assertEquals(2, confirmRepository.getDestinationInfoByLoginId("L000").size());
		assertEquals(0, confirmRepository.getSettlementInfoByLoginId("L000").size());
		assertEquals(4, confirmRepository.getOrderItemInfoByLoginId("L000").size());
		assertTrue(isDestinationExpected1());
		assertTrue(isDestinationExpected2());
		assertTrue(isOrderItemInfoExpected1());
		assertTrue(isOrderItemInfoExpected2());
		assertTrue(isOrderItemInfoExpected3());
		assertTrue(isOrderItemInfoExpected4());
	}

	@Test
	void testGetPersonalInfoByAuthenticationDestination2Settlement2OrderItem0() {
		confirmRepositoryForTest.deleteTestDataDestinationInfo();
		confirmRepositoryForTest.deleteTestDataSettlementInfo();
		confirmRepositoryForTest.deleteTestDataOrderItemInfo();
		confirmRepositoryForTest.insertTestDataDestinationInfo();
		confirmRepositoryForTest.insertTestDataSettlementInfo();
		assertEquals(2, confirmRepository.getDestinationInfoByLoginId("L000").size());
		assertEquals(2, confirmRepository.getSettlementInfoByLoginId("L000").size());
		assertEquals(0, confirmRepository.getOrderItemInfoByLoginId("L000").size());
		assertTrue(isDestinationExpected1());
		assertTrue(isDestinationExpected2());
		assertTrue(isSettlementInfoExpected1());
		assertTrue(isSettlementInfoExpected2());
	}

	@Test
	void testGetPersonalInfoByAuthenticationDestination0Settlement0OrderItem4() {
		confirmRepositoryForTest.deleteTestDataDestinationInfo();
		confirmRepositoryForTest.deleteTestDataSettlementInfo();
		confirmRepositoryForTest.deleteTestDataOrderItemInfo();
		confirmRepositoryForTest.insertTestDataOrderItemInfo();
		assertEquals(0, confirmRepository.getDestinationInfoByLoginId("L000").size());
		assertEquals(0, confirmRepository.getSettlementInfoByLoginId("L000").size());
		assertEquals(4, confirmRepository.getOrderItemInfoByLoginId("L000").size());
		assertTrue(isOrderItemInfoExpected1());
		assertTrue(isOrderItemInfoExpected2());
		assertTrue(isOrderItemInfoExpected3());
		assertTrue(isOrderItemInfoExpected4());

	}

	@Test
	void testGetPersonalInfoByAuthenticationDestination0Settlement2OrderItem0() {
		confirmRepositoryForTest.deleteTestDataDestinationInfo();
		confirmRepositoryForTest.deleteTestDataSettlementInfo();
		confirmRepositoryForTest.deleteTestDataOrderItemInfo();
		confirmRepositoryForTest.insertTestDataSettlementInfo();
		assertEquals(0, confirmRepository.getDestinationInfoByLoginId("L000").size());
		assertEquals(2, confirmRepository.getSettlementInfoByLoginId("L000").size());
		assertEquals(0, confirmRepository.getOrderItemInfoByLoginId("L000").size());
		assertTrue(isSettlementInfoExpected1());
		assertTrue(isSettlementInfoExpected2());

	}

	@Test
	void testGetPersonalInfoByAuthenticationDestination2Settlement0OrderItem0() {
		confirmRepositoryForTest.deleteTestDataDestinationInfo();
		confirmRepositoryForTest.deleteTestDataSettlementInfo();
		confirmRepositoryForTest.deleteTestDataOrderItemInfo();
		confirmRepositoryForTest.insertTestDataDestinationInfo();
		assertEquals(2, confirmRepository.getDestinationInfoByLoginId("L000").size());
		assertEquals(0, confirmRepository.getSettlementInfoByLoginId("L000").size());
		assertEquals(0, confirmRepository.getOrderItemInfoByLoginId("L000").size());
		assertTrue(isDestinationExpected1());
		assertTrue(isDestinationExpected2());

	}

	@Test
	void testGetPersonalInfoByAuthenticationDestination0Settlement0OrderItem0() {
		confirmRepositoryForTest.deleteTestDataDestinationInfo();
		confirmRepositoryForTest.deleteTestDataSettlementInfo();
		confirmRepositoryForTest.deleteTestDataOrderItemInfo();
		confirmRepositoryForTest.insertTestDataDestinationInfo();
		confirmRepositoryForTest.insertTestDataSettlementInfo();
		confirmRepositoryForTest.insertTestDataOrderItemInfo();
		confirmRepositoryForTest.deleteTestDataDestinationInfo();
		confirmRepositoryForTest.deleteTestDataSettlementInfo();
		confirmRepositoryForTest.deleteTestDataOrderItemInfo();
		assertEquals(0, confirmRepository.getDestinationInfoByLoginId("L000").size());
		assertEquals(0, confirmRepository.getSettlementInfoByLoginId("L000").size());
		assertEquals(0, confirmRepository.getOrderItemInfoByLoginId("L000").size());
	}

	private boolean isDestinationExpected1() {
		return confirmRepository.getDestinationInfoByLoginId("L000").get(0).getDestinationInfoLoginBranch() == 1
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(0).getDestinationEmailAddress()
						.equals("test@test.com")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(0).getDestinationName().equals("testname")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(0).getDestinationTelNo()
						.equals("00000000000")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(0).getDestinationPostalCode()
						.equals("0000000")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(0).getDestinationPrefecture()
						.equals("PREFECTURE")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(0).getDestinationCity().equals("CITY")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(0).getDestinationTown().equals("TOWN")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(0).getDestinationTownNo().equals("0-0-0")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(0).getDestinationBuilding()
						.equals("BUILDING")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(0).getDestinationRoomNo().equals("ROOMNO")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(0).getPersonalName().equals("test")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(0).getPersonalTelNo().equals("00000000000")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(0).getPersonalPostalCode()
						.equals("0000000")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(0).getPersonalPrefecture()
						.equals("PREFECTURE")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(0).getPersonalCity().equals("CITY")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(0).getPersonalTown().equals("TOWN")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(0).getPersonalTownNo().equals("0-0-0")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(0).getPersonalBuilding().equals("BUILDING")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(0).getPersonalRoomNo().equals("ROOMNO");

	}

	private boolean isDestinationExpected2() {
		return confirmRepository.getDestinationInfoByLoginId("L000").get(1).getDestinationInfoLoginBranch() == 2
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(1).getDestinationEmailAddress()
						.equals("あいえうお")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(1).getDestinationName().equals("名前")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(1).getDestinationTelNo()
						.equals("00000000000")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(1).getDestinationPostalCode()
						.equals("0000000")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(1).getDestinationPrefecture().equals("県")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(1).getDestinationCity().equals("市")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(1).getDestinationTown().equals("町")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(1).getDestinationTownNo().equals("0000000")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(1).getDestinationBuilding().equals("建物")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(1).getDestinationRoomNo().equals("部屋")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(1).getPersonalName().equals("名前")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(1).getPersonalTelNo().equals("00000000000")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(1).getPersonalPostalCode()
						.equals("０００００００")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(1).getPersonalPrefecture().equals("県")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(1).getPersonalCity().equals("市")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(1).getPersonalTown().equals("町")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(1).getPersonalTownNo().equals("００００")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(1).getPersonalBuilding().equals("建物")
				&& confirmRepository.getDestinationInfoByLoginId("L000").get(1).getPersonalRoomNo().equals("部屋番号");
	}

	private boolean isSettlementInfoExpected1() {
		return confirmRepository.getSettlementInfoByLoginId("L000").get(0).getSettlementInfoLoginBranch() == 1
				&& confirmRepository.getSettlementInfoByLoginId("L000").get(0).getCardCompanyCode().equals("C000")
				&& confirmRepository.getSettlementInfoByLoginId("L000").get(0).getCreditCardNo()
						.equals("000000000000000000000")
				&& confirmRepository.getSettlementInfoByLoginId("L000").get(0).getSecurityCode().equals("0000")
				&& confirmRepository.getSettlementInfoByLoginId("L000").get(0).getExpireDate().equals("202304");
	}

	private boolean isSettlementInfoExpected2() {
		return confirmRepository.getSettlementInfoByLoginId("L000").get(1).getSettlementInfoLoginBranch() == 2
				&& confirmRepository.getSettlementInfoByLoginId("L000").get(1).getCardCompanyCode().equals("C000")
				&& confirmRepository.getSettlementInfoByLoginId("L000").get(1).getCreditCardNo()
						.equals("9999999999999999999999")
				&& confirmRepository.getSettlementInfoByLoginId("L000").get(1).getSecurityCode().equals("9999")
				&& confirmRepository.getSettlementInfoByLoginId("L000").get(1).getExpireDate().equals("999999");
	}

	private boolean isOrderItemInfoExpected1() {
		return confirmRepository.getOrderItemInfoByLoginId("L000").get(0).getOrderItemId().equals("i0000001")
				&& confirmRepository.getOrderItemInfoByLoginId("L000").get(0).getOrderItemPrice() == 500
				&& confirmRepository.getOrderItemInfoByLoginId("L000").get(0).getDiscountDiv().equals("d000")
				&& confirmRepository.getOrderItemInfoByLoginId("L000").get(0).getDiscountMoney() == 0;
	}

	private boolean isOrderItemInfoExpected2() {
		return confirmRepository.getOrderItemInfoByLoginId("L000").get(1).getOrderItemId().equals("i0000002")
				&& confirmRepository.getOrderItemInfoByLoginId("L000").get(1).getOrderItemPrice() == 600
				&& confirmRepository.getOrderItemInfoByLoginId("L000").get(1).getDiscountDiv().equals("d000")
				&& confirmRepository.getOrderItemInfoByLoginId("L000").get(1).getDiscountMoney() == 0;
	}

	private boolean isOrderItemInfoExpected3() {
		return confirmRepository.getOrderItemInfoByLoginId("L000").get(2).getOrderItemId().equals("i0000003")
				&& confirmRepository.getOrderItemInfoByLoginId("L000").get(2).getOrderItemPrice() == 700
				&& confirmRepository.getOrderItemInfoByLoginId("L000").get(2).getDiscountDiv().equals("d000")
				&& confirmRepository.getOrderItemInfoByLoginId("L000").get(2).getDiscountMoney() == 0;
	}

	private boolean isOrderItemInfoExpected4() {
		return confirmRepository.getOrderItemInfoByLoginId("L000").get(3).getOrderItemId().equals("i0000004")
				&& confirmRepository.getOrderItemInfoByLoginId("L000").get(3).getOrderItemPrice() == 800
				&& confirmRepository.getOrderItemInfoByLoginId("L000").get(3).getDiscountDiv().equals("d000")
				&& confirmRepository.getOrderItemInfoByLoginId("L000").get(3).getDiscountMoney() == 0;
	}

}
