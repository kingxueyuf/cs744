package com.transcription.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication.data.MedicalStaff;
import com.authentication.data.Physician;
import com.authentication.service.CustomUserDetailsService;
import com.constant.ConstantValue;
import com.medical_staff.service.MedicalStaffService;
import com.patient.data.Patient;
import com.patient.service.PatientService;
import com.physician.service.PhysicianService;
import com.transcription.dao.TranscriptionDao;
import com.transcription.data.Transcription;

@Service
public class TranscriptionService {

	@Autowired
	TranscriptionDao transcriptionDao;

	@Autowired
	PatientService pService;

	@Autowired
	PhysicianService physicianService;

	@Autowired
	MedicalStaffService msService;

	public List<Transcription> getTranscriptionsByEmrId(int emrId) {
		List<Transcription> list = transcriptionDao
				.findTranscriptionsByEmrId(emrId);
		return list;
	}

	public Transcription getTranscriptionById(int transcription_id) {
		Transcription transcription = transcriptionDao
				.findTranscriptionById(transcription_id);
		return transcription;
	}

	public Integer create(int emrId, int patientId) {
		// TODO Auto-generated method stub
		Transcription transcription = new Transcription();
		transcription.setEmr_id(emrId);
		transcription.setPatient_id(patientId);
		Patient p = pService.getPatientById(patientId);
		transcription.setPatient_ssn(p.getSSN());
		transcription.setPatient_name(p.getPatient_name());
		transcription.setAbstraction("");
		transcription.setContent("");
		if (CustomUserDetailsService.isMedicalStaff()) {
			MedicalStaff ms = msService
					.getMedicalstaffById(CustomUserDetailsService
							.currentUserDetails().getUserId());
			Physician phsician = physicianService.getPhysicianById(ms
					.getPhysician_id());
			transcription.setPhysician_id(phsician.getPhysician_id());
			transcription.setPhysician_name(phsician.getPhysician_name());
			transcription.setWriter_id(ms.getMsid());
			transcription.setWriter_name(ms.getMs_name());
			transcription.setWriter_type(ConstantValue.MEDICAL_STAFF);
		} else if (CustomUserDetailsService.isPhysician()) {
			Physician currentPhysician = physicianService.currentPhysician();
			transcription.setPhysician_id(currentPhysician.getPhysician_id());
			transcription
					.setPhysician_name(currentPhysician.getPhysician_name());
			transcription.setWriter_id(currentPhysician.getPhysician_id());
			transcription.setWriter_name(currentPhysician.getAccount());
			transcription.setWriter_type(ConstantValue.PHYSICIAN);
		}
		Date date = new Date();
		transcription.setCreate_date(date);
		return transcriptionDao.create(transcription);
	}

	public void update(int transcriptionId, String content, String abstraction) {
		// TODO Auto-generated method stub
		transcriptionDao.update(transcriptionId, content, abstraction);
	}

}
