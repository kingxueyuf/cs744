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

import com.authentication.data.Physician;
import com.constant.ConstantValue;
import com.patient.data.Patient;
import com.patient.service.PatientService;
import com.patient_physician_relation.data.RelationPhysicianPatient;
import com.patient_physician_relation.service.PatientPhysicianRelationService;
import com.physician.service.PhysicianService;

@Controller
public class PatientPhysicianRelationController {

	@Autowired
	PatientPhysicianRelationService pService;
	@Autowired
	PhysicianService physicianService;
	@Autowired
	PatientService patientService;

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

	@RequestMapping(value = "/relation/addTemporary", method = RequestMethod.GET)
	@Secured(value = { "ROLE_PHYSICIAN" })
	public @ResponseBody String addTemporaryRelation(
			@RequestParam(value = "physician_id", required = true) int physician_id,
			@RequestParam(value = "physician_name", required = true) String physician_name,
			@RequestParam(value = "date", required = true) String date,
			@RequestParam(value = "patient_id", required = true) int patient_id) {
		Physician physician = physicianService.getPhysicianById(physician_id);
		Patient patient = patientService.getPatientById(patient_id);
		RelationPhysicianPatient rpp = new RelationPhysicianPatient();
		rpp.setPhysician_id(physician.getPhysician_id());
		rpp.setPhysician_name(physician.getPhysician_name());
		rpp.setPatient_id(patient.getPatient_id());
		rpp.setPatient_name(patient.getPatient_name());
		rpp.setPatient_gender(patient.getPatient_gender());
		rpp.setPatient_birthday(patient.getPatient_birthday());
		rpp.setRelation_type(ConstantValue.TEMPORARY_CARE_RELATION);
		rpp.setPrimary_physician_id(1);
		rpp.setPrimary_physician_name("none");
		rpp.setAccess_right("11");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date today_date = new Date();
		Date start_date;
		try {
			start_date = dateFormat.parse(dateFormat.format(today_date));
			rpp.setStart_date(start_date);
			rpp.setEnd_date(dateFormat.parse(date));
			return pService.save(rpp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failure";
	}

}
