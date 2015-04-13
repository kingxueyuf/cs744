package com.prescription.data;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.authentication.data.Physician;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.patient.data.Patient;
import com.relation_prescription_drug.data.PrescriptionDrugRelation;

public class PrescriptionForPharmacy {

	private Prescription prescription;
	private Patient patient;
	private Physician physician;
	private List<PrescriptionDrugRelation> prescriptionDrugList;

	
	public Patient getsPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Physician getPhysician() {
		return physician;
	}

	public void setPhysician(Physician physician) {
		this.physician = physician;
	}

	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public List<PrescriptionDrugRelation> getPrescriptionDrugList() {
		return prescriptionDrugList;
	}

	public void setPrescriptionDrugList(
			List<PrescriptionDrugRelation> prescriptionDrugList) {
		this.prescriptionDrugList = prescriptionDrugList;
	}

}
