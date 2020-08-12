package org.openmrs.module.ucionchology.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient_drug_value")
public class PatientDrugDosage {
	
	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Basic
	@Column(nullable = false)
	private int patientId;
	
	@Basic
	@Column(nullable = false)
	private int dayDrugDosageValue;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public int getPatientId() {
		return patientId;
	}
	
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	public int getDayDrugDosageValue() {
		return dayDrugDosageValue;
	}
	
	public void setDayDrugDosageValue(int dayDrugDosageValue) {
		this.dayDrugDosageValue = dayDrugDosageValue;
	}
	
}
