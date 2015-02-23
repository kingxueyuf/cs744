package com.patient.controller;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.patient.data.Patient;

@Controller
public class PatientController {

	@RequestMapping("/patient/list")
	@Secured(value = { "ROLE_PHYSICIAN" })
	public @ResponseBody List<Patient> clientDocList(ModelMap model,
			@RequestParam(value = "sloid", required = true) int sloid) {
		
		return list;
	}
}
