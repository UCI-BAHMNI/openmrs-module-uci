package org.openmrs.module.ucionchology.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.Drug;

@Entity
@Table(name = "stage_day")
public class StageDay extends BaseOpenmrsData {
	
	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Basic
	@Column
	private int dayNumber;
	
	@OneToMany
	@JoinColumn(name = "dosage_id", nullable = false)
	private DayDrugDosage dosage;
	
	public int getDayNumber() {
		return dayNumber;
	}
	
	public void setDayNumber(int dayNumber) {
		this.dayNumber = dayNumber;
	}
	
	@Override
	public Integer getId() {
		
		return id;
	}
	
	@Override
	public void setId(Integer id) {
		this.id = id;
		
	}
	
	public DayDrugDosage getDosage() {
		return dosage;
	}
	
	public void setDosage(DayDrugDosage dosage) {
		this.dosage = dosage;
	}
	
}
