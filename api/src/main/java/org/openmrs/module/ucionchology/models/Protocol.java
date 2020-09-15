package org.openmrs.module.ucionchology.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
@Table(name = "p_protocal")
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
	
	@OneToMany(mappedBy = "protocol2")
	private Set<ProtocalDiagnosis> diagnoses;
	
	@OneToMany(mappedBy = "protocol1")
	private Set<Phase> phase;
	
	@Basic
	@Column
	private int numberOfPhases;
	
	@Basic
	@Column(columnDefinition = "BOOLEAN DEFAULT false")
	private boolean isCyclic;
	
	public List<Phase> getSortedPhases() {
		List<Phase> list = new ArrayList<Phase>();
		list = convertToList(getPhase());
		Collections.sort(list);
		return list;
	}
	
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
	
	public Set<ProtocalDiagnosis> getDiagnoses() {
		return diagnoses;
	}
	
	public void setDiagnoses(Set<ProtocalDiagnosis> diagnoses) {
		this.diagnoses = diagnoses;
	}
	
	public <T> List<T> convertToList(Set<T> set) {
		List<T> items = new ArrayList<T>();
		for (T e : set)
			items.add(e);
		return items;
	}
	
	public boolean isCyclic() {
		return isCyclic;
	}
	
	public void setCyclic(boolean isCyclic) {
		this.isCyclic = isCyclic;
	}
	
}
