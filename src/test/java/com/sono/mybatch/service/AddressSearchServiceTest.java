package com.sono.mybatch.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
class AddressSearchServiceTest {
	@Autowired
	AddressSearchService addressSearchService;

	@Test
	void testAddressSearchByPostalCodeBlank() {
		try {
			var result = addressSearchService.getAddressByPostalCode("");
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().matches(".*Postal Code Invalid."));
		}
	}

	@Test
	void testAddressSearchByPostalCodeNull() {
		try {
			var result = addressSearchService.getAddressByPostalCode(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().matches(".*Postal Code Invalid."));
		}
	}

	@Test
	void testAddressSearchByPostalCodeWithoutHyphen() {
		try {
			var result = addressSearchService.getAddressByPostalCode("0010010");
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().matches(".*Postal Code Invalid."));
		}
	}

	@Test
	void testAddressSearchByPostalCodeWithZenkakuHyphen() {
		try {
			var result = addressSearchService.getAddressByPostalCode("001ー0010");
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().matches(".*Postal Code Invalid."));
		}
	}

	@Test
	void testAddressSearchByPostalCodeThreeHyphen() {
		try {
			var result = addressSearchService.getAddressByPostalCode("-001-0010-");
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().matches(".*Postal Code Invalid."));
		}
	}

	@Test
	void testAddressSearchByPostalCodeHyphenDifferentPlace() {
		try {
			var result = addressSearchService.getAddressByPostalCode("-0010010");
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().matches(".*Postal Code Invalid."));
		}
	}

	@Test
	void testAddressSearchByPostalCodeOnlyHyphen() {
		try {
			var result = addressSearchService.getAddressByPostalCode("-");
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().matches(".*Postal Code Invalid."));
		}
	}

	@Test
	void testAddressSearchByPostalCodeOneHyphenFour() {
		try {
			var result = addressSearchService.getAddressByPostalCode("1-0010");
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().matches(".*Postal Code Invalid."));
		}
	}

	@Test
	void testAddressSearchByPostalCodeThreeHyphenTwo() {
		try {
			var result = addressSearchService.getAddressByPostalCode("001-00");
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().matches(".*Postal Code Invalid."));
		}
	}

	@Test
	void testAddressSearchByPostalCodeNotExists() {
		assertEquals(0, addressSearchService.getAddressByPostalCode("000-0000").size());
	}

	@Test
	void testAddressSearchByPostalCodeZenkaku() {
		assertEquals(0, addressSearchService.getAddressByPostalCode("１１０-００１０").size());
	}

	@Test
	void testAddressSearchByPostalCodeFound() {
		var result = addressSearchService.getAddressByPostalCode("001-0010");
		assertEquals(result.size(), 1);
		assertEquals("001-0010", result.get(0).getZip());
		assertEquals("北海道", result.get(0).getKenName());
		assertEquals("札幌市北区", result.get(0).getCityName());
		assertEquals("北十条西", result.get(0).getTownName());
		assertEquals("１丁目", result.get(0).getBlockName());
	}

	@Test
	void testAddressSearchByPostalCodeFoundMany() {
		var result = addressSearchService.getAddressByPostalCode("921-8046");
		assertEquals(result.size(), 1);
		assertEquals("921-8046", result.get(0).getZip());
		assertEquals("石川県", result.get(0).getKenName());
		assertEquals("金沢市", result.get(0).getCityName());
		assertEquals("大桑町", result.get(0).getTownName());
		assertEquals("ア", result.get(0).getBlockName());
	}

	@Test
	void testGetAllKen() {
		var result = addressSearchService.getAllKen();
		assertEquals(47, result.size());
		assertEquals(null, result.get(0).getZip());
		assertEquals(null, result.get(0).getTownName());
		assertEquals(null, result.get(0).getTownId());
		assertEquals(null, result.get(0).getCityName());
		assertEquals(null, result.get(0).getCityId());
		assertEquals("北海道", result.get(0).getKenName());
		assertEquals("埼玉県", result.get(10).getKenName());
		assertEquals("岐阜県", result.get(20).getKenName());
		assertEquals("鳥取県", result.get(30).getKenName());
		assertEquals("佐賀県", result.get(40).getKenName());
		assertEquals("沖縄県", result.get(46).getKenName());
		for (int i = 0; i < result.size(); i++) {
			assertEquals(String.valueOf(i + 1), result.get(i).getKenId());
		}
	}

	@Test
	void testGetCityOrTownInfoOrZipCodeByIdKen0City0Town0() {
		try {
			var result = addressSearchService.getCityOrTownInfoOrZipCodeById(null, null, null);
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().matches(".*Invalid Address Id."));
		}
	}

	@Test
	void testGetCityOrTownInfoOrZipCodeByIdKen1City0Town0NotFound() {
		var result = addressSearchService.getCityOrTownInfoOrZipCodeById("100", null, null);
		assertEquals(0, result.size());
	}

	@Test
	void testGetCityOrTownInfoOrZipCodeByIdKen1City0Town0Found() {
		var result = addressSearchService.getCityOrTownInfoOrZipCodeById("23", null, null);
		assertEquals(73, result.size());
		assertEquals(null, result.get(0).getZip());
		assertEquals("23", result.get(0).getKenId());
		assertEquals("愛知県", result.get(0).getKenName());
		assertEquals("23101", result.get(0).getCityId());
		assertEquals("名古屋市千種区", result.get(0).getCityName());
		assertEquals(null, result.get(0).getTownId());
		assertEquals(null, result.get(0).getTownName());
		assertEquals(null, result.get(0).getConcatAddress());
	}

	@Test
	void testGetCityOrTownInfoOrZipCodeByIdKen1City1Town0Found() {
		var result = addressSearchService.getCityOrTownInfoOrZipCodeById("23", "23101", null);
		assertEquals(73, result.size());
		assertEquals(null, result.get(0).getZip());
		assertEquals("23", result.get(0).getKenId());
		assertEquals("愛知県", result.get(0).getKenName());
		assertEquals("23101", result.get(0).getCityId());
		assertEquals("名古屋市千種区", result.get(0).getCityName());
		assertEquals(null, result.get(0).getTownId());
		assertEquals(null, result.get(0).getTownName());
		assertEquals(null, result.get(0).getConcatAddress());

	}

	@Test
	void testGetCityOrTownInfoOrZipCodeByIdKen1City0Town1Found() {
		var result = addressSearchService.getCityOrTownInfoOrZipCodeById("23", null, "231010001");
		assertEquals(73, result.size());
		assertEquals(null, result.get(0).getZip());
		assertEquals("23", result.get(0).getKenId());
		assertEquals("愛知県", result.get(0).getKenName());
		assertEquals("23101", result.get(0).getCityId());
		assertEquals("名古屋市千種区", result.get(0).getCityName());
		assertEquals(null, result.get(0).getTownId());
		assertEquals(null, result.get(0).getTownName());
		assertEquals(null, result.get(0).getConcatAddress());

	}

	@Test
	void testGetCityOrTownInfoOrZipCodeByIdKen1City1Town1Found() {
		var result = addressSearchService.getCityOrTownInfoOrZipCodeById("23", "23101", "231010001");
		assertEquals(73, result.size());
		assertEquals(null, result.get(0).getZip());
		assertEquals("23", result.get(0).getKenId());
		assertEquals("愛知県", result.get(0).getKenName());
		assertEquals("23101", result.get(0).getCityId());
		assertEquals("名古屋市千種区", result.get(0).getCityName());
		assertEquals(null, result.get(0).getTownId());
		assertEquals(null, result.get(0).getTownName());
		assertEquals(null, result.get(0).getConcatAddress());

	}

	@Test
	void testGetCityOrTownInfoOrZipCodeByIdKen0City1Town1Found() {
		var result = addressSearchService.getCityOrTownInfoOrZipCodeById(null, "23101", "231010001");
		assertEquals(120, result.size());
		assertEquals(null, result.get(0).getZip());
		assertEquals("23", result.get(0).getKenId());
		assertEquals("愛知県", result.get(0).getKenName());
		assertEquals("23101", result.get(0).getCityId());
		assertEquals("名古屋市千種区", result.get(0).getCityName());
		assertEquals("231010000", result.get(0).getTownId());
		assertEquals("", result.get(0).getTownName());
		assertEquals(null, result.get(0).getConcatAddress());

	}

	@Test
	void testGetCityOrTownInfoOrZipCodeByIdKen0City1Town0Found() {
		var result = addressSearchService.getCityOrTownInfoOrZipCodeById(null, "23101", null);
		assertEquals(120, result.size());
		assertEquals(null, result.get(0).getZip());
		assertEquals("23", result.get(0).getKenId());
		assertEquals("愛知県", result.get(0).getKenName());
		assertEquals("23101", result.get(0).getCityId());
		assertEquals("名古屋市千種区", result.get(0).getCityName());
		assertEquals("231010000", result.get(0).getTownId());
		assertEquals("", result.get(0).getTownName());
		assertEquals(null, result.get(0).getConcatAddress());

	}

	@Test
	void testGetCityOrTownInfoOrZipCodeByIdKen0City0Town1Found() {
		var result = addressSearchService.getCityOrTownInfoOrZipCodeById(null, null, "231010001");
		assertEquals(2, result.size());
		assertEquals("464-0852", result.get(0).getZip());
		assertEquals("23", result.get(0).getKenId());
		assertEquals("愛知県", result.get(0).getKenName());
		assertEquals("23101", result.get(0).getCityId());
		assertEquals("名古屋市千種区", result.get(0).getCityName());
		assertEquals("231010001", result.get(0).getTownId());
		assertEquals("青柳町", result.get(0).getTownName());
		assertEquals("愛知県名古屋市千種区青柳町", result.get(0).getConcatAddress());
		assertEquals("464-8641", result.get(1).getZip());
		assertEquals("23", result.get(1).getKenId());
		assertEquals("愛知県", result.get(1).getKenName());
		assertEquals("23101", result.get(1).getCityId());
		assertEquals("名古屋市千種区", result.get(1).getCityName());
		assertEquals("231010001", result.get(1).getTownId());
		assertEquals("青柳町", result.get(1).getTownName());
		assertEquals("愛知県名古屋市千種区青柳町５丁目６", result.get(1).getConcatAddress());
	}

}
