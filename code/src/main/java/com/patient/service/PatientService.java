package com.patient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.dao.PatientDao;
import com.patient.data.Patient;
@Service
public class PatientService {
	@Autowired
	PatientDao pDao;
	public Patient getPatientById(int patientId){
		Patient patient = pDao.findPatientByPatientId(patientId);
		return patient;
	}
}
 