package com.authentication.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "medical_staff")
public class MedicalStaff {
	@Id
	@Column(name = "msid")
	private int msid;

	@Column(name = "ms_name")
	private String ms_name;
	
	@Column(name = "ms_account")
	private String ms_account;

	@Column(name = "password")
	private String password;

	@Column(name = "physician_id")
	private int physician_id;

	@Column(name = "physician_name")
	private String physician_name;

	@Column(name = "SSN")
	private String ssn;
	
	@Transient
	public String physician_ssn;
	
	public int getMsid() {
		return msid;
	}

	public void setMsid(int msid) {
		this.msid = msid;
	}

	public String getMs_name() {
		return ms_name;
	}
	
	public String getMs_account() {
		return ms_account;
	}

	public void setMs_account(String ms_account) {
		this.ms_account = ms_account;
	}

	public void setMs_name(String ms_name) {
		this.ms_name = ms_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhysician_id() {
		return physician_id;
	}

	public void setPhysician_id(int physician_id) {
		this.physician_id = physician_id;
	}

	public String getPhysician_name() {
		return physician_name;
	}

	public void setPhysician_name(String physician_name) {
		this.physician_name = physician_name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getPhysician_ssn() {
		return physician_ssn;
	}

	public void setPhysician_ssn(String physician_ssn) {
		this.physician_ssn = physician_ssn;
	}	
	
	
}