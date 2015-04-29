package com.physician.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.authentication.data.Physician;
import com.drug.data.Drug;
import com.patient.data.Patient;
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
		System.out.println("here");
		return pService.save(physician);
	}
	
	@RequestMapping(value = "/physician/admin/delete", method = RequestMethod.GET)
	public @ResponseBody String delete(
			@RequestParam(value = "physicianId", required = true) int physicianId) {
		return pService.delete(physicianId);
	}
	
	@RequestMapping(value = "/physician/admin/edit", method = RequestMethod.GET)
	public @ResponseBody String edit(
			@RequestBody Physician physician) {
		return pService.update(physician);
	}
}
