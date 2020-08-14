package org.openmrs.module.ucionchology.models;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.openmrs.BaseOpenmrsData;

@Entity
@Table(name = "protocal")
public class Protocol extends BaseOpenmrsData {
	
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
	private String protocalName;
	
	@Basic
	@Column(length = 255, nullable = false)
	private String diagnosis;
	
	@OneToMany(mappedBy = "protocol1")
	private Set<Phase> phase;
	
	@Basic
	@Column
	private int numberOfPhases;
	
	public int getNumberOfPhases() {
		return numberOfPhases;
	}
	
	public void setNumberOfPhases(int numberOfPhases) {
		this.numberOfPhases = numberOfPhases;
	}
	
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
	
	@Override
	public Integer getId() {
		return id;
	}
	
	@Override
	public void setId(Integer id) {
		this.id = id;
		
	}
	
	public Set<Phase> getPhase() {
		return phase;
	}
	
	public void setPhase(Set<Phase> phase) {
		this.phase = phase;
	}
	
}
