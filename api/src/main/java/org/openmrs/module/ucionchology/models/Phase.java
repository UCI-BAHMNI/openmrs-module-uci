package org.openmrs.module.ucionchology.models;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.openmrs.BaseOpenmrsData;

@Entity
@Table(name = "phase_table")
public class Phase extends BaseOpenmrsData {
	
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
	private String phaseName;
	
	@OneToMany(mappedBy = "phase")
	private Set<StageDay> stageDay;
	
	@ManyToOne
	@JoinColumn(name = "protocal_id", nullable = false)
	private Protocol protocol1;
	
	@Basic
	@Column
	private int numberOfDays;
	
	@Basic
	@Column
	private int phase_order;
	
	// check boneMarrowRemisson 
	
	public Protocol getProtocol1() {
		return protocol1;
	}
	
	public void setProtocol1(Protocol protocol1) {
		this.protocol1 = protocol1;
	}
	
	public int getNumberOfDays() {
		return numberOfDays;
	}
	
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	
	public int getOrder() {
		return phase_order;
	}
	
	public void setOrder(int order) {
		this.phase_order = order;
	}
	
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
	
	public Set<StageDay> getStageDay() {
		return stageDay;
	}
	
	public void setStageDay(Set<StageDay> stageDay) {
		this.stageDay = stageDay;
	}
	
}
