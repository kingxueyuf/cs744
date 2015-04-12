package com.prescription.data;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.relation_prescription_drug.data.PrescriptionDrugRelation;

public class PrescriptionForPharmacy {

	private Prescription prescription;
	private List<PrescriptionDrugRelation> prescriptionDrugList;


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
