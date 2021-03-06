package com.prescription.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "prescription")
public class Prescription {
	@Id
	@Column(name = "prescription_id")
	@GeneratedValue
	private int prescription_id;

	@Column(name = "transcription_id")
	private int transcription_id;
	@Column(name = "patient_id")
	private int patient_id;
	@Column(name = "patient_name")
	private String patient_name;
	@Column(name = "patient_ssn")
	private String patient_ssn;
	@Column(name = "physician_id")
	private int physician_id;
	@Column(name = "physician_name")
	private String physician_name;
	@Column(name = "physician_ssn")
	private String physician_ssn;
	@Column(name = "writer_id")
	private int writer_id;
	@Column(name = "writer_name")
	private String writer_name;
	@Column(name = "writer_ssn")
	private String writer_ssn;
	@Column(name = "writer_type")
	private String writer_type;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@Column(name = "create_date")
	private Date create_date;
	@Column(name = "content")
	private String content;

	public int getPrescription_id() {
		return prescription_id;
	}

	public void setPrescription_id(int prescription_id) {
		this.prescription_id = prescription_id;
	}

	public int getTranscription_id() {
		return transcription_id;
	}

	public void setTranscription_id(int transcription_id) {
		this.transcription_id = transcription_id;
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
	
	public int getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(int writer_id) {
		this.writer_id = writer_id;
	}

	public String getWriter_name() {
		return writer_name;
	}

	public void setWriter_name(String writer_name) {
		this.writer_name = writer_name;
	}

	public String getWriter_type() {
		return writer_type;
	}

	public void setWriter_type(String writer_type) {
		this.writer_type = writer_type;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPatient_ssn() {
		return patient_ssn;
	}

	public void setPatient_ssn(String patient_ssn) {
		this.patient_ssn = patient_ssn;
	}

	public String getPhysician_ssn() {
		return physician_ssn;
	}

	public void setPhysician_ssn(String physician_ssn) {
		this.physician_ssn = physician_ssn;
	}

	public String getWriter_ssn() {
		return writer_ssn;
	}

	public void setWriter_ssn(String writer_ssn) {
		this.writer_ssn = writer_ssn;
	}
	
}
