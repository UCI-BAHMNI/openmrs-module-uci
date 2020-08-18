package org.openmrs.module.ucionchology.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.openmrs.BaseOpenmrsData;

@Entity
@Table(name = "drug_dosage")
public class DayDrugDosage extends BaseOpenmrsData {
	
	// check patient age , weight , plt count ,hiv status
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Basic
	@Column(length = 255, nullable = false)
	private String drugName;
	
	@Basic
	@Column(length = 255, nullable = false)
	private String units;
	
	@Basic
	@Column(nullable = false)
	private int dosageValue;
	
	@Basic
	@Column(nullable = false)
	private String dosageRoute;
	
	@Basic
	@Column(nullable = false)
	private String dosageFrequence;
	
	@Basic
	@Column
	private int maxDoseValue;
	
	@ManyToOne
	@JoinColumn(name = "stageDay_id", nullable = false)
	private StageDay stageDay;
	
	public StageDay getStageDay() {
		return stageDay;
	}
	
	public void setStageDay(StageDay stageDay) {
		this.stageDay = stageDay;
	}
	
	public String getUnits() {
		return units;
	}
	
	public void setUnits(String units) {
		this.units = units;
	}
	
	public String getDrugName() {
		return drugName;
	}
	
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	
	public int getDosageValue() {
		return dosageValue;
	}
	
	public void setDosageValue(int dosageValue) {
		this.dosageValue = dosageValue;
	}
	
	public String getDosageFrequence() {
		return dosageFrequence;
	}
	
	public void setDosageFrequence(String dosageFrequence) {
		this.dosageFrequence = dosageFrequence;
	}
	
	@Override
	public Integer getId() {
		
		return id;
	}
	
	@Override
	public void setId(Integer id) {
		this.id = id;
		
	}
	
	public String getDosageRoute() {
		return dosageRoute;
	}
	
	public void setDosageRoute(String dosageRoute) {
		this.dosageRoute = dosageRoute;
	}
	
	public int getMaxDoseValue() {
		return maxDoseValue;
	}
	
	public void setMaxDoseValue(int maxDoseValue) {
		this.maxDoseValue = maxDoseValue;
	}
	
}
