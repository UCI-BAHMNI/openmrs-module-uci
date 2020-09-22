package org.openmrs.module.ucionchology.models;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;

@Entity
@Table(name = "p_patient_protocal")
public class PatientProtocol {
	
	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Basic
	@Column(nullable = false)
	private int patientId;
	
	@ManyToOne
	@JoinColumn(name = "protocal_id", nullable = false)
	private Protocol protocol3;
	
	@Basic
	@Column
	private Date dateStarted;
	
	@Basic
	@Column
	private Date dateStopped;
	
	public Date getDateStarted() {
		return dateStarted;
	}
	
	public void setDateStarted(Date dateStarted) {
		this.dateStarted = dateStarted;
	}
	
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
	
	public Protocol getProtocol3() {
		return protocol3;
	}
	
	public void setProtocol3(Protocol protocol3) {
		this.protocol3 = protocol3;
	}
	
	public Date getDateStopped() {
		return dateStopped;
	}
	
	public void setDateStopped(Date dateStopped) {
		this.dateStopped = dateStopped;
	}
	
}
