package com.emr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emr.data.Emr;
import com.emr.service.EmrService;
import com.patient.data.Patient;
import com.patient.service.PatientService;

@Controller
public class EmrController {
	@Autowired
	EmrService eService;
	@Autowired
	PatientService pService;

	@RequestMapping(value = "/emr/check", method = RequestMethod.GET)
	@Secured(value = { "ROLE_PHYSICIAN" })
	public @ResponseBody Map<String, String> patient(
			@RequestParam(value = "patientId", required = true) int patientId) {
		HashMap<String, String> map = new HashMap<String, String>();
		Emr emr = eService.getEmrByPatientId(patientId);
		if (emr != null) {
			map.put("hasEmr", "true");
			map.put("emrId", emr.getEmr_id() + "");
		} else {
			map.put("hasEmr", "false");
		}
		return map;
	}
	
	@RequestMapping(value = "/emr/create", method = RequestMethod.GET)
	@Secured(value = {"ROLE_PHYSICIAN"})
	public @ResponseBody String creatEmr(
			@RequestParam(value = "patientId", required=true) int patientId,
			@RequestParam(value = "race") String race,
			@RequestParam(value = "occupation") String occupation,
			@RequestParam(value = "address") String address,
			@RequestParam(value = "height") String height,
			@RequestParam(value = "weight") String weight,
			@RequestParam(value = "blood_group") String blood_group,
			@RequestParam(value = "vaccinations") String vaccinations,
			@RequestParam(value = "diabetes") String diabetes,
			@RequestParam(value = "allergies") String allergies){
		Patient patient = pService.getPatientById(patientId);
		Emr emr = new Emr(patientId, patient.getPatient_name(), patient.getPatient_birthday(),
										race, occupation, address, height, weight, blood_group, vaccinations,
										diabetes, allergies);
		eService.createNewEmr(emr);
		return "Creating has been done.";
	}
}
