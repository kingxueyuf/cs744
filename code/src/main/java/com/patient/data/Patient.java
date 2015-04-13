package com.patient.data;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Han Chen
 *
 *         Feb 26, 2015
 */
@Entity
@Table(name = "patient")
public class Patient implements Serializable {
	@Id
	@Column(name = "patient_id")
	private int patient_id;
	@Column(name = "patient_name")
	private String patient_name;
	@Column(name = "patient_gender")
	private String patient_gender;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "patient_birthday")
	private Date patient_birthday;

	@Column(name = "patient_age")
	private int patient_age;

	@Column(name = "SSN")
	private String ssn;

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
		System.out.println(patient_id);
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
		System.out.println(patient_name);
	}

	public String getPatient_gender() {
		return patient_gender;
	}

	public void setPatient_gender(String patient_gender) {
		this.patient_gender = patient_gender;
		System.out.println(patient_gender);
	}

	public int getPatient_age() {
		return patient_age;
	}

	public void setPatient_age(int patient_age) {
		this.patient_age = patient_age;
		System.out.println(patient_age);
	}

	public String getSSN() {
		return ssn;
	}

	public void setSSN(String ssn) {
		this.ssn = ssn;
		System.out.println("ssn=" + ssn);
	}

	/**
	 * @return the patient_birthday
	 */
	public Date getPatient_birthday() {
		return patient_birthday;
	}

	/**
	 * @param patient_birthday
	 *            the patient_birthday to set
	 */
	public void setPatient_birthday(String patient_birthday) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(patient_birthday);
		Date date = null;
		try {
			date = formatter.parse(patient_birthday);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.patient_birthday = date;
	}

}