package com.prescription.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.authentication.data.MedicalStaff;
import com.authentication.data.Physician;
import com.authentication.service.CustomUserDetailsService;
import com.constant.ConstantValue;
import com.medical_staff.service.MedicalStaffService;
import com.patient.data.Patient;
import com.patient.service.PatientService;
import com.physician.service.PhysicianService;
import com.prescription.data.Prescription;
import com.prescription.service.PrescriptionService;

@Controller
public class PrescriptionController {

	@Autowired
	PrescriptionService pService;
	@Autowired
	PatientService patientService;
	@Autowired
	PhysicianService physicianService;
	@Autowired
	MedicalStaffService msService;

	@RequestMapping(value = "/prescription/list", method = RequestMethod.GET)
	@Secured(value = { "ROLE_PHYSICIAN" })
	public @ResponseBody List<Prescription> list(
			@RequestParam(value = "transcription_id", required = true) int transcriptionId) {
		return pService.getByTranscriptionId(transcriptionId);
	}

	@RequestMapping(value = "/prescription/add", method = RequestMethod.GET)
	@Secured(value = { "ROLE_PHYSICIAN" })
	public @ResponseBody String add(
			@RequestParam(value = "transcriptionId", required = true) int transcriptionId,
			@RequestParam(value = "patientId", required = true) int patientId) {

		Prescription p = new Prescription();
		p.setTranscription_id(transcriptionId);
		p.setPatient_id(patientId);
		Patient patient = patientService.getPatientById(patientId);
		p.setPatient_name(patient.getPatient_name());
		if (CustomUserDetailsService.isMedicalStaff()) {
			MedicalStaff ms = msService
					.getMedicalstaffById(CustomUserDetailsService
							.currentUserDetails().getUserId());
			Physician physician = physicianService.getPhysicianById(ms.getPhysician_id());
			p.setPhysician_id(physician.getPhysicianId());
			p.setPhysician_name(physician.getPhysicianName());
			p.setCreate_date(new Date());
			p.setContent("");
			p.setWriter_id(ms.getMsid());
			p.setWriter_name(ms.getMs_name());
			p.setWriter_type(ConstantValue.MEDICAL_STAFF);
		} else if (CustomUserDetailsService.isPhysician()) {
			Physician physician = physicianService.currentPhysician();
			p.setPhysician_id(physician.getPhysicianId());
			p.setPhysician_name(physician.getPhysicianName());
			p.setCreate_date(new Date());
			p.setContent("");
			p.setWriter_id(physician.getPhysicianId());
			p.setWriter_name(physician.getPhysicianName());
			p.setWriter_type(ConstantValue.PHYSICIAN);
		}
		return pService.save(p);
	}
}
