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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;
import org.openmrs.BaseOpenmrsData;

@Entity
@Table(name = "p_phase_table")
public class Phase extends BaseOpenmrsData implements Comparable<Phase> {
	
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
	@Where(clause = "voided = 'false'")
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
	
	public List<StageDay> getSortedDays() {
		List<StageDay> list = new ArrayList<StageDay>();
		if (getStageDay() != null && getStageDay().size() > 0) {
			list = convertToList(getStageDay());
			Collections.sort(list);
		}
		return list;
	}
	
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
	
	public <T> List<T> convertToList(Set<T> set) {
		List<T> items = new ArrayList<T>();
		for (T e : set)
			items.add(e);
		return items;
	}
	
	@Override
	public int compareTo(Phase phase) {
		return new Integer(this.getOrder()).compareTo(new Integer(phase.getOrder()));
	}
}
