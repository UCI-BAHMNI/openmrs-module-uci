package org.openmrs.module.ucionchology.models;

import org.openmrs.BaseOpenmrsData;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Entity;

@Entity
@Table(name = "drug_dozage")
public class DayDruDozage extends BaseOpenmrsData {

	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	
	@Basic
	@Column(length = 255, nullable = false)
	private String dozeName;
	
	@Basic
	@Column(length = 255, nullable = false)
	private String units;
	
	@Basic
	@Column(nullable = false)
	private int value;
	
	@Basic
	@Column
	private int age;
	
	@Basic
	@Column
	private int weight;  
	
	
	@Basic
	@Column
	private int pltCount; 
	
	@Basic
	@Column
	private String hivStatus;
	
		
	public String getDozeName() {
		return dozeName;
	}

	
	public void setDozeName(String dozeName) {
		this.dozeName = dozeName;
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

	
	public int getAge() {
		return age;
	}

	
	public void setAge(int age) {
		this.age = age;
	}

	
	public int getWeight() {
		return weight;
	}

	
	public void setWeight(int weight) {
		this.weight = weight;
	}

	
	public int getPltCount() {
		return pltCount;
	}

	
	public void setPltCount(int pltCount) {
		this.pltCount = pltCount;
	}

	
	public String getHivStatus() {
		return hivStatus;
	}

	
	public void setHivStatus(String hivStatus) {
		this.hivStatus = hivStatus;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
		
	}
	
}
