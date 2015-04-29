package com.relation_prescription_drug.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "relation_prescription_drug")
public class PrescriptionDrugRelation {
	@Id
	@Column(name = "rpd_id")
	@GeneratedValue
	private int rpd_id;

	@Column(name = "prescription_id")
	private int prescription_id;
	@Column(name = "drug_id")
	private int drug_id;
	@Column(name = "drug_name_medical")
	private String drug_name_medical;
	@Column(name = "drug_name_commercial")
	private String drug_name_commercial;
	@Column(name = "drug_dose")
	private String drug_dose;
	@Column(name = "drug_price")
	private String drug_price;
	@Column(name = "amount")
	private String amount;
	@Column(name = "refill")
	private String refill;

	public int getRpd_id() {
		return rpd_id;
	}

	public void setRpd_id(int rpd_id) {
		this.rpd_id = rpd_id;
	}

	public int getPrescription_id() {
		return prescription_id;
	}

	public void setPrescription_id(int prescription_id) {
		this.prescription_id = prescription_id;
	}

	public int getDrug_id() {
		return drug_id;
	}

	public void setDrug_id(int drug_id) {
		this.drug_id = drug_id;
	}

	public String getDrug_name_medical() {
		return drug_name_medical;
	}

	public void setDrug_name_medical(String drug_name_medical) {
		this.drug_name_medical = drug_name_medical;
	}

	public String getDrug_name_commercial() {
		return drug_name_commercial;
	}

	public void setDrug_name_commercial(String drug_name_commercial) {
		this.drug_name_commercial = drug_name_commercial;
	}


	public String getDrug_dose() {
		return drug_dose;
	}

	public void setDrug_dose(String drug_dose) {
		this.drug_dose = drug_dose;
	}

	public String getDrug_price() {
		return drug_price;
	}

	public void setDrug_price(String drug_price) {
		this.drug_price = drug_price;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getRefill() {
		return refill;
	}

	public void setRefill(String refill) {
		this.refill = refill;
	}

}
