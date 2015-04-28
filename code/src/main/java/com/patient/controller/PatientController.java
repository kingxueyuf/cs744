package com.patient.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.constant.ConstantValue;
import com.patient.data.Patient;
import com.patient.service.PatientService;
import com.patient_physician_relation.data.RelationPhysicianPatient;
import com.patient_physician_relation.service.PatientPhysicianRelationService;
import com.physician.service.PhysicianService;

@Controller
public class PatientController {
	@Autowired
	private PatientService pService;
	@Autowired
	private PhysicianService physicianService;
	@Autowired
	private PatientPhysicianRelationService pprService;
	
	@RequestMapping(value = "/patient/admin/add", method = RequestMethod.POST)
	public @ResponseBody String addPatientFromAdmin(@RequestBody Patient patient) {
		System.out.println(patient.getPatient_id() + " "
				+ patient.getPatient_name() + " "
				+ patient.getPatient_birthday());
		Physician physician = physicianService.getPhysicianBySSN(patient
				.getPhysician_ssn());
		if (pService.save(patient).equals("success")) {
			RelationPhysicianPatient rpp = new RelationPhysicianPatient();
			rpp.setPhysician_id(physician.getPhysician_id());
			rpp.setPhysician_name(physician.getPhysician_name());
			rpp.setPatient_id(patient.getPatient_id());
			rpp.setPatient_name(patient.getPatient_name());
			rpp.setPatient_gender(patient.getPatient_gender());
			rpp.setPatient_birthday(patient.getPatient_birthday());
			rpp.setPrimary_physician_id(physician.getPhysician_id());
			rpp.setPrimary_physician_name(physician.getPhysician_name());
			rpp.setAccess_right("11");
			rpp.setRelation_type(ConstantValue.PRIMARY_CARE_RELATION);
			return pprService.save(rpp);
//			return "success";
		} else {
			return "failure";
		}
	}

	@RequestMapping(value = "/patient/admin/delete", method = RequestMethod.GET)
	public @ResponseBody String deletePatientFromAdmin(
			@RequestParam(value = "patientId", required = true) int patientId) {
		return pService.delete(patientId);
	}
}
