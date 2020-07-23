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

@Entity
@Table(name = "phase")
public class Phase extends BaseOpenmrsData{
	
	// check boneMarrowRemisson 
	
	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Basic
	@Column(length = 255, nullable = false)
	private String phaseName;
	
	@OneToMany
	@JoinColumn(name = "satgeDay_id" ,nullable = false)
	private StageDay stageDay ;
	
	

	@Override
	public Integer getId() {
		
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
		
	}

	
	public String getPhaseName() {
		return phaseName;
	}

	
	public void setPhaseName(String phaseName) {
		this.phaseName = phaseName;
	}

	
	public StageDay getStageDay() {
		return stageDay;
	}

	
	public void setStageDay(StageDay stageDay) {
		this.stageDay = stageDay;
	}
	
	
}
