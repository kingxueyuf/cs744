package com.authentication.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "physician")
public class Physician {
	@Id
	@Column(name = "physician_id")
	@GeneratedValue
	private String physicianId;

	@Column(name = "physician_name")
	private String physicianName;

	@Column(name = "physician_gender")
	private String physicianGender;

	@Column(name = "physician_birthday")
	private String physicianBirthday;

	@Column(name = "password")
	private String password;

	public String getPhysicianId() {
		return physicianId;
	}

	public void setPhysicianId(String physicianId) {
		this.physicianId = physicianId;
	}

	public String getPhysicianName() {
		return physicianName;
	}

	public void setPhysicianName(String physicianName) {
		this.physicianName = physicianName;
	}

	public String getPhysicianGender() {
		return physicianGender;
	}

	public void setPhysicianGender(String physicianGender) {
		this.physicianGender = physicianGender;
	}

	public String getPhysicianBirthday() {
		return physicianBirthday;
	}

	public void setPhysicianBirthday(String physicianBirthday) {
		this.physicianBirthday = physicianBirthday;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}