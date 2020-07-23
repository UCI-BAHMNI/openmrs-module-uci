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
@Table(name = "protocal")
public class Protocol extends BaseOpenmrsData {
	
	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Basic
	@Column(length = 255, nullable = false)
	private String protocalName;
	
	@Basic
	@Column(length = 255, nullable = false)
	private String diagnosis;
	
	@OneToMany
	@JoinColumn(name = "phase_id" ,nullable = false)
	private Phase phase ;
	
	
	
	public String getProtocalName() {
		return protocalName;
	}

	
	public void setProtocalName(String protocalName) {
		this.protocalName = protocalName;
	}

	
	public String getDiagnosis() {
		return diagnosis;
	}

	
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	
	public Phase getPhase() {
		return phase;
	}

	
	public void setPhase(Phase phase) {
		this.phase = phase;
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
