package com.relation_transcription_treatment.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "	relation_transcription_treatment")
public class TreatmentRelation {
	@Id
	@Column(name = "relation_id")
	@GeneratedValue
	private int relation_id;

	@Column(name = "transcription_id")
	private int transcription_id;
	@Column(name = "treatment_id")
	private int treatment_id;
	@Column(name = "treatment_name")
	private String treatment_name;
	@Column(name = "treatment_operator_id")
	private int treatment_operator_id;
	@Column(name = "treatment_operator_name")
	private String treatment_operator_name;
	@Column(name = "treatment_operator_type")
	private String treatment_operator_type;
	
	public int getRelation_id() {
		return relation_id;
	}
	public void setRelation_id(int relation_id) {
		this.relation_id = relation_id;
	}
	public int getTranscription_id() {
		return transcription_id;
	}
	public void setTranscription_id(int transcription_id) {
		this.transcription_id = transcription_id;
	}
	public int getTreatment_id() {
		return treatment_id;
	}
	public void setTreatment_id(int treatment_id) {
		this.treatment_id = treatment_id;
	}
	public String getTreatment_name() {
		return treatment_name;
	}
	public void setTreatment_name(String treatment_name) {
		this.treatment_name = treatment_name;
	}
	public int getTreatment_operator_id() {
		return treatment_operator_id;
	}
	public void setTreatment_operator_id(int treatment_operator_id) {
		this.treatment_operator_id = treatment_operator_id;
	}
	public String getTreatment_operator_name() {
		return treatment_operator_name;
	}
	public void setTreatment_operator_name(String treatment_operator_name) {
		this.treatment_operator_name = treatment_operator_name;
	}
	public String getTreatment_operator_type() {
		return treatment_operator_type;
	}
	public void setTreatment_operator_type(String treatment_operator_type) {
		this.treatment_operator_type = treatment_operator_type;
	}
	
	
}
