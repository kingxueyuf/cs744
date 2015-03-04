package com.drug.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Jingbo Chu	
 *
 * Mar 4, 2015
 */
@Entity
@Table(name = "drug")
public class Drug {

	@Id
	@Column(name = "drug_id")
	@GeneratedValue
	private int drug_id;
	
	@Column( name = "drug_name")
	private String drug_name;
	
	@Column( name = "drug_term")
	private String drug_term;
	
	@Column( name = "drug_dispense")
	private String drug_dispense;
	
	public Drug(){
		
	}

	
	/**
	 * @param drug_id
	 * @param drug_name
	 * @param drug_term
	 * @param drug_dispense
	 */
	public Drug(int drug_id, String drug_name, String drug_term,
			String drug_dispense) {
		super();
		this.drug_id = drug_id;
		this.drug_name = drug_name;
		this.drug_term = drug_term;
		this.drug_dispense = drug_dispense;
	}


	/**
	 * @return the drug_id
	 */
	public int getDrug_id() {
		return drug_id;
	}

	/**
	 * @param drug_id the drug_id to set
	 */
	public void setDrug_id(int drug_id) {
		this.drug_id = drug_id;
	}

	/**
	 * @return the drug_name
	 */
	public String getDrug_name() {
		return drug_name;
	}

	/**
	 * @param drug_name the drug_name to set
	 */
	public void setDrug_name(String drug_name) {
		this.drug_name = drug_name;
	}

	/**
	 * @return the drug_term
	 */
	public String getDrug_term() {
		return drug_term;
	}

	/**
	 * @param drug_term the drug_term to set
	 */
	public void setDrug_term(String drug_term) {
		this.drug_term = drug_term;
	}

	/**
	 * @return the drug_dispense
	 */
	public String getDrug_dispense() {
		return drug_dispense;
	}

	/**
	 * @param drug_dispense the drug_dispense to set
	 */
	public void setDrug_dispense(String drug_dispense) {
		this.drug_dispense = drug_dispense;
	}
	
	
	
}
