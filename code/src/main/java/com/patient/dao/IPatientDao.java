package com.patient.dao;

import java.util.List;

import com.patient.data.Patient;

public interface IPatientDao {
	public List<Patient> find();
}
