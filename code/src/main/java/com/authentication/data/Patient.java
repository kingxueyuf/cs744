package com.authentication.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {
	@Id
	@Column(name = "patient_id")
	@GeneratedValue
	private String patientId;

	@Column(name = "patient_name")
	private String patientName;

	@Column(name = "patient_gender")
	private String patientGender;

	@Column(name = "patient_birthday")
	private String patientBirthday;

	@Column(name = "patient_age")
	private String patientAge;

	/**
	 * @return the patientId
	 */
	public String getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return the patientName
	 */
	public String getPatientName() {
		return patientName;
	}

	/**
	 * @param patientName the patientName to set
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	/**
	 * @return the patientGender
	 */
	public String getPatientGender() {
		return patientGender;
	}

	/**
	 * @param patientGender the patientGender to set
	 */
	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

	/**
	 * @return the patientBirthday
	 */
	public String getPatientBirthday() {
		return patientBirthday;
	}

	/**
	 * @param patientBirthday the patientBirthday to set
	 */
	public void setPatientBirthday(String patientBirthday) {
		this.patientBirthday = patientBirthday;
	}

	/**
	 * @return the patientAge
	 */
	public String getPatientAge() {
		return patientAge;
	}

	/**
	 * @param patientAge the patientAge to set
	 */
	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}
	
	
}
