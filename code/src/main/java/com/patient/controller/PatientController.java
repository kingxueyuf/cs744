package com.patient.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.patient.data.Patient;
import com.patient.service.PatientService;

@Controller
public class PatientController {

	@Autowired
	PatientService pService;

	@RequestMapping("/patient/list")
	@Secured(value = { "ROLE_PHYSICIAN" })
	public @ResponseBody Map<String, List<Patient>> patient() {
		List<Patient> primary = pService.findPrimaryCaraPatient();
		List<Patient> temporary = pService.findTemporaryCaraPatient();
		HashMap<String, List<Patient>> map = new HashMap<String, List<Patient>>();
		map.put("primary", primary);
		map.put("temporary", temporary);
		return map;
	}
}
