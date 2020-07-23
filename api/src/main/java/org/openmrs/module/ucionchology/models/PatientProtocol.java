package org.openmrs.module.ucionchology.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.openmrs.BaseOpenmrsData;

import javax.persistence.Entity;

@Entity
@Table(name = "patient_protocal")
public class PatientProtocol {
	
	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Basic
	@Column(nullable = false)
	private int patientId;
	
	@Basic
	@Column(nullable = false)
	private int protocalId;
	
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
	
	public int getProtocalId() {
		return protocalId;
	}
	
	public void setProtocalId(int protocalId) {
		this.protocalId = protocalId;
	}
	
}
