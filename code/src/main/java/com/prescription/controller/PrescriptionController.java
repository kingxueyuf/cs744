package com.prescription.controller;

import java.util.ArrayList;
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
import com.emr.service.EmrService;
import com.medical_staff.service.MedicalStaffService;
import com.patient.data.Patient;
import com.patient.service.PatientService;
import com.physician.service.PhysicianService;
import com.prescription.data.Prescription;
import com.prescription.data.PrescriptionForPharmacy;
import com.prescription.service.PrescriptionService;
import com.relation_prescription_drug.data.PrescriptionDrugRelation;
import com.relation_prescription_drug.service.PrescriptionDrugService;
import com.transcription.data.Transcription;
import com.transcription.service.TranscriptionService;

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
	@Autowired
	PrescriptionDrugService pdService;
	@Autowired
	EmrService emrService;
	@Autowired
	TranscriptionService transService;

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
		p.setPatient_ssn(patient.getSsn());
		if (CustomUserDetailsService.isMedicalStaff()) {
			MedicalStaff ms = msService
					.getMedicalstaffById(CustomUserDetailsService
							.currentUserDetails().getUserId());
			Physician physician = physicianService.getPhysicianById(ms
					.getPhysician_id());
			p.setPhysician_id(physician.getPhysician_id());
			p.setPhysician_name(physician.getPhysician_name());
			p.setPhysician_ssn(physician.getSsn());
			p.setCreate_date(new Date());
			p.setContent("");
			p.setWriter_id(ms.getMsid());
			p.setWriter_name(ms.getMs_name());
			p.setWriter_ssn(ms.getSsn());
			p.setWriter_type(ConstantValue.MEDICAL_STAFF);
		} else if (CustomUserDetailsService.isPhysician()) {
			Physician physician = physicianService.currentPhysician();
			p.setPhysician_id(physician.getPhysician_id());
			p.setPhysician_name(physician.getPhysician_name());
			p.setPhysician_ssn(physician.getSsn());
			p.setCreate_date(new Date());
			p.setContent("");
			p.setWriter_id(physician.getPhysician_id());
			p.setWriter_name(physician.getPhysician_name());
			p.setWriter_ssn(physician.getSsn());
			p.setWriter_type(ConstantValue.PHYSICIAN);
		}
		return pService.save(p);
	}

	@RequestMapping(value = "/prescription/pharmacy/check", method = RequestMethod.GET)
	public @ResponseBody List<PrescriptionForPharmacy> check(
			@RequestParam(value = "physician_ssn", required = true) String physician_ssn,
			@RequestParam(value = "patient_ssn", required = true) String patient_ssn,
			@RequestParam(value = "create_date", required = true) String create_date) {
		List<PrescriptionForPharmacy> pfpList = new ArrayList<PrescriptionForPharmacy>();
		List<Prescription> prescriptionList = pService.getByPrescriptionId(
				physician_ssn, patient_ssn, create_date);
		for (Prescription prescription : prescriptionList) {
			PrescriptionForPharmacy pfp = new PrescriptionForPharmacy();
			List<PrescriptionDrugRelation> list = pdService
					.getByPrescriptionId(prescription.getPrescription_id());
			Transcription trans = transService.getTranscriptionById(prescription.getTranscription_id());
			prescription.setContent(trans.getContent());
			pfp.setPrescription(prescription);
			pfp.setPatient(patientService.getPatientById(prescription
					.getPatient_id()));
			pfp.setEmr(emrService.getEmrByPatientId(prescription.getPatient_id()));
			pfp.setPhysician(physicianService.getPhysicianById(prescription
					.getPhysician_id()));
			pfp.setPrescriptionDrugList(list);
			pfpList.add(pfp);
		}
		return pfpList;
	}
}
