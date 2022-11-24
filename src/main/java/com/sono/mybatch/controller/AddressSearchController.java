package com.sono.mybatch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sono.mybatch.dto.AddressSearchResultByAddressDto;
import com.sono.mybatch.dto.AddressSearchResultByPostalCodeDto;
import com.sono.mybatch.service.AddressSearchService;

@RestController
public class AddressSearchController {
	@Autowired
	AddressSearchService addressSearchService;

	@RequestMapping(path = "/api/v1/getAddressByPostalCode", method = RequestMethod.POST)
	public ResponseEntity<List<AddressSearchResultByPostalCodeDto>> getAddressByPostalCode(
			@RequestParam(value = "postalCode", required = false) String postalCode) {
		try {
			var list = addressSearchService.getAddressByPostalCode(postalCode);
			return new ResponseEntity<List<AddressSearchResultByPostalCodeDto>>(list, new HttpHeaders(), HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return new ResponseEntity<List<AddressSearchResultByPostalCodeDto>>(null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(path = "/api/v1/getAllKen", method = RequestMethod.POST)
	public List<AddressSearchResultByAddressDto> getAddressByKenId() {
		return addressSearchService.getAllKen();
	}

	@RequestMapping(path = "/api/v1/getAddressById", method = RequestMethod.POST)
	public ResponseEntity<List<AddressSearchResultByAddressDto>> getAddressById(
			@RequestParam(value = "kenId", required = false) String kenId,
			@RequestParam(value = "cityId", required = false) String cityId,
			@RequestParam(value = "townId", required = false) String townId) {
		try {
			var result = addressSearchService.getCityOrTownInfoOrZipCodeById(kenId, cityId, townId);
			return new ResponseEntity<List<AddressSearchResultByAddressDto>>(result, new HttpHeaders(), HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<List<AddressSearchResultByAddressDto>>(null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
	}
}
