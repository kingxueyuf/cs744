package com.patient_physician_relation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.patient_physician_relation.data.RelationPhysicianPatient;
import com.patient_physician_relation.service.PatientPhysicianRelationService;

@Controller
public class PatientPhysicianRelationController {

	@Autowired
	PatientPhysicianRelationService pService;

	@RequestMapping(value = "/patient", method = RequestMethod.GET)
	@Secured(value = { "ROLE_PHYSICIAN" })
	public @ResponseBody Map<String, List<RelationPhysicianPatient>> patient() {
		List<RelationPhysicianPatient> primary = pService
				.findPrimaryCaraPatient();
		List<RelationPhysicianPatient> temporary = pService
				.findTemporaryCaraPatient();
		HashMap<String, List<RelationPhysicianPatient>> map = new HashMap<String, List<RelationPhysicianPatient>>();
		map.put("primary", primary);
		map.put("temporary", temporary);
		return map;
	}

	@RequestMapping(value = "/relation/temporaryCare", method = RequestMethod.GET)
	@Secured(value = { "ROLE_PHYSICIAN" })
	public @ResponseBody List<RelationPhysicianPatient> findTemporaryCareByPatientId(
			@RequestParam(value = "patient_id", required = true) int patient_id) {

		List<RelationPhysicianPatient> temporary = pService
				.findTemporaryCaraByPatientId( patient_id);
		return temporary;
	}
}
