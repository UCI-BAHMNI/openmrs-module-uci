package org.openmrs.module.ucionchology.models;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.openmrs.BaseOpenmrsData;

@Entity
@Table(name = "p_drug_dosage")
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
	private float dosageValue;
	
	@Basic
	@Column(nullable = false)
	private String dosageRoute;
	
	@Basic
	@Column(nullable = false)
	private String dosageFrequence;
	
	@Basic
	@Column
	private float maxDoseValue;
	
	@Basic
	@Column(length = 1000)
	private String instructions;
	
	@ManyToMany(mappedBy = "dosage")
	private Set<StageDay> stageDays;
	
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
	
	public float getDosageValue() {
		return dosageValue;
	}
	
	public void setDosageValue(float dosageValue) {
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
	
	public float getMaxDoseValue() {
		return maxDoseValue;
	}
	
	public void setMaxDoseValue(float maxDoseValue) {
		this.maxDoseValue = maxDoseValue;
	}
	
	public Set<StageDay> getStageDays() {
		return stageDays;
	}
	
	public void setStageDays(Set<StageDay> stageDays) {
		this.stageDays = stageDays;
	}
	
	public String getInstructions() {
		return instructions;
	}
	
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	
}
