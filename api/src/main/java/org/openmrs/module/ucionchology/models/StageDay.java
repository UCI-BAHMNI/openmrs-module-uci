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
@Table(name = "stage_day")
public class StageDay extends BaseOpenmrsData {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Basic
	@Column
	private int dayNumber;
	
	@OneToMany(mappedBy = "stageDay")
	private Set<DayDrugDosage> dosage;
	
	@ManyToOne
	@JoinColumn(name = "phase_id", nullable = false)
	private Phase phase;
	
	public Phase getPhase() {
		return phase;
	}
	
	public void setPhase(Phase phase) {
		this.phase = phase;
	}
	
	public Set<DayDrugDosage> getDosage() {
		return dosage;
	}
	
	public void setDosage(Set<DayDrugDosage> dosage) {
		this.dosage = dosage;
	}
	
	public int getDayNumber() {
		return dayNumber;
	}
	
	public void setDayNumber(int dayNumber) {
		this.dayNumber = dayNumber;
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
