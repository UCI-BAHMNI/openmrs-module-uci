package org.openmrs.module.ucionchology.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	private int drugId ;
    
	@Basic
	@Column(length = 255, nullable = false)
	private String doseName;
	
	@Basic
	@Column(length = 255, nullable = false)
	private String units;
	
	@Basic
	@Column(nullable = false)
	private int value;
	
		
	
	public int getDrugId() {
		return drugId;
	}


	public void setDrugId(int drugId) {
		this.drugId = drugId;
	}


	public String getDoseName() {
		return doseName;
	}


	
	public void setDoseName(String doseName) {
		this.doseName = doseName;
	}


	
	public String getUnits() {
		return units;
	}

	
	public void setUnits(String units) {
		this.units = units;
	}

	
	public int getValue() {
		return value;
	}

	
	public void setValue(int value) {
		this.value = value;
	}

	
	@Override
	public Integer getId() {
		
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
		
	}
    
}
