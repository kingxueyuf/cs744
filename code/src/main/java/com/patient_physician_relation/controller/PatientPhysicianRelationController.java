package com.patient_physician_relation.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.constant.ConstantValue;
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
				.findTemporaryCaraByPatientId(patient_id);
		return temporary;
	}

	@RequestMapping(value = "/relation/admin", method = RequestMethod.GET)
	public @ResponseBody List<RelationPhysicianPatient> makeAppointment(
			@RequestParam(value = "patient_id", required = true) int patient_id) {

		List<RelationPhysicianPatient> list = pService
				.findPhysicianCanMakeAppointment(patient_id);
		return list;
	}

	@RequestMapping(value = "/relation/admin/add", method = RequestMethod.GET)
	public @ResponseBody String add(
			@RequestParam(value = "patient_id", required = true) int patient_id,
			@RequestParam(value = "patient_name", required = true) String patient_name,
			@RequestParam(value = "patient_gender", required = true) String patient_gender,
			@RequestParam(value = "patient_birthday", required = true) String patient_birthday,
			@RequestParam(value = "physician_id", required = true) int physician_id,
			@RequestParam(value = "physician_name", required = true) String physician_name) {

		RelationPhysicianPatient rpp = new RelationPhysicianPatient();
		rpp.setPhysician_id(physician_id);
		rpp.setPhysician_name(physician_name);
		rpp.setPatient_id(patient_id);
		rpp.setPatient_name(patient_name);
		rpp.setPatient_gender(patient_gender);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = format.parse(patient_birthday);
			rpp.setPatient_birthday(date);
			rpp.setPrimary_physician_id(physician_id);
			rpp.setPrimary_physician_name(physician_name);
			rpp.setAccess_right("11");
			rpp.setRelation_type(ConstantValue.PRIMARY_CARE_RELATION);
			return pService.save(rpp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failure";
		}
	}
}
