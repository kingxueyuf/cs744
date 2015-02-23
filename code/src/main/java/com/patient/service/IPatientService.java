package com.patient.service;

import java.util.List;

import com.patient.data.Patient;

public interface IPatientService {
	public List<Patient> findPrimaryCaraPatient();

	public List<Patient> findTemporaryCaraPatient();
}
