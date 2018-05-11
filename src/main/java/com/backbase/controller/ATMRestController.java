package com.backbase.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backbase.model.ATMAddress;
import com.backbase.service.ATMService;

@RestController
public class ATMRestController {

	@Autowired
	ATMService atmService;

	@GetMapping("/atms")
	public List<ATMAddress> getCustomers(@RequestParam String city,
			HttpServletRequest req, HttpServletResponse resp) {

		ArrayList<ATMAddress> atMsByCity = null;
		try {

			atMsByCity = atmService.getATMsByCity(city);

		} catch (Exception e) {
			resp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

		}
		resp.setStatus(HttpStatus.OK.value());
		return atMsByCity;
	}
}