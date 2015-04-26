package com.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.authentication.data.Physician;
import com.patient.data.Patient;
import com.patient.service.PatientService;

@Controller
public class PatientController {
	@Autowired
	private PatientService pService;

	@RequestMapping(value = "/patient/admin/add", method = RequestMethod.POST)
	public @ResponseBody String addPatientFromAdmin(
			@RequestBody Patient patient) {
		System.out.println(patient.getPatient_id() + " "
				+ patient.getPatient_name() + " "
				+ patient.getPatient_birthday());
		return pService.save(patient);
	}
	
	@RequestMapping(value = "/patient/admin/delete", method = RequestMethod.GET)
	public @ResponseBody String deletePatientFromAdmin(
			@RequestParam(value = "patientId", required = true) int patientId) {
		return pService.delete(patientId);
	}
}
