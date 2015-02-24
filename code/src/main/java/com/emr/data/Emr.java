package com.emr.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emr")
public class Emr {
	@Id
	@Column(name = "emr_id")
	@GeneratedValue
	private int emr_id;

	@Column(name = "patient_id")
	private int patient_id;

	@Column(name = "patient_name")
	private String patient_name;

	public int getEmr_id() {
		return emr_id;
	}

	public void setEmr_id(int emr_id) {
		this.emr_id = emr_id;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

}