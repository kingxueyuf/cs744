package com.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication.data.Physician;
import com.patient.dao.PatientDao;
import com.patient.data.Patient;
import com.physician.service.PhysicianService;

@Service
public class PatientService implements IPatientService {

	@Autowired
	PhysicianService pService;
	@Autowired
	PatientDao patientDao;

	Physician currentPhysician;

	public List<Patient> findPrimaryCaraPatient() {
		// TODO Auto-generated method stub
		List<Patient> patients = patientDao.find();
		return null;
	}

	@Override
	public List<Patient> findTemporaryCaraPatient() {
		// TODO Auto-generated method stub
		List<Patient> patients = patientDao.find();
		return null;
	}

	private Physician getCurrentPhysician() {
		if (currentPhysician == null) {
			currentPhysician = pService.currentPhysician();
		}
		return currentPhysician;
	}

}
