package com.physician.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.authentication.data.Physician;
import com.drug.data.Drug;
import com.physician.service.PhysicianService;

@Controller
public class PhysicianController {

	@Autowired
	private PhysicianService pService;

	@RequestMapping(value = "/physician/autocomplete", method = RequestMethod.GET)
	@Secured(value = { "ROLE_PHYSICIAN" })
	public @ResponseBody List<Physician> searchWithInput(
			@RequestParam(value = "input", required = true) String input) {
		List<Physician> list = pService.searchWithInput(input);
		return list;
	}

	@RequestMapping(value = "/physician/admin/add", method = RequestMethod.POST)
	public @ResponseBody String add(@RequestBody Physician physician) {
		return pService.save(physician);
	}
}
