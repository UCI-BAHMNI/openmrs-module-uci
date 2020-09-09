package org.openmrs.module.ucionchology.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "p_diagnosis_table")
public class ProtocalDiagnosis {
	
	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Basic
	@Column(length = 255, nullable = false)
	private String diagnosis;
	
	@ManyToOne
	@JoinColumn(name = "protocal_id", nullable = false)
	private Protocol protocol2;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDiagnosis() {
		return diagnosis;
	}
	
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	
	public Protocol getProtocol2() {
		return protocol2;
	}
	
	public void setProtocol2(Protocol protocol2) {
		this.protocol2 = protocol2;
	}
}
