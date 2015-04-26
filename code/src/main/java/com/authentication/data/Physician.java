package com.authentication.data;

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

@Entity
@Table(name = "physician")
public class Physician implements Serializable {
	@Id
	@Column(name = "physician_id")
	private int physician_id;

	@Column(name = "physician_name")
	private String physician_name;

	@Column(name = "physician_gender")
	private String physician_gender;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "physician_birthday")
	private Date physician_birthday;

	@Column(name = "account")
	private String account;

	@Column(name = "password")
	private String password;

	@Column(name = "SSN")
	private String ssn;

	@Column(name = "specialty")
	private String specialty;

	public Physician() {
		System.out.println("new a Physician");
	}

	public int getPhysician_id() {
		return physician_id;
	}

	public void setPhysician_id(int physician_id) {
		this.physician_id = physician_id;
		System.out.println(physician_id);
	}

	public String getPhysician_name() {
		return physician_name;
	}

	public void setPhysician_name(String physician_name) {
		this.physician_name = physician_name;
		System.out.println(physician_name);
	}

	public String getPhysician_gender() {
		return physician_gender;
	}

	public void setPhysician_gender(String physician_gender) {
		this.physician_gender = physician_gender;
		System.out.println(physician_gender);
	}

	public Date getPhysician_birthday() {
		return physician_birthday;
	}

	public void setPhysician_birthday(String physician_birthday) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(physician_birthday);
		Date date = null;
		try {
			date = formatter.parse(physician_birthday);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.physician_birthday = date;
		System.out.println(physician_birthday);
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
		System.out.println(account);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		System.out.println(password);
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
		System.out.println(ssn);
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
		System.out.println(specialty);
	}

}