package org.openmrs.module.ucionchology.models;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "p_action")
public class Action {
	
	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Basic
	@Column(length = 255, nullable = false)
	private String actionName;
	
	@Basic
	@Column(length = 1000)
	private String description;
	
	@ManyToMany(mappedBy = "dayActions")
	private Set<StageDay> stageDays;
	
	@Basic
	@Column(columnDefinition = "BOOLEAN DEFAULT false")
	private Boolean voided;
	
	@Basic
	@Column(nullable = true)
	private Integer cycleNumber;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getActionName() {
		return actionName;
	}
	
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<StageDay> getStageDays() {
		return stageDays;
	}
	
	public void setStageDays(Set<StageDay> stageDays) {
		this.stageDays = stageDays;
	}
	
	public Boolean getVoided() {
		return voided;
	}
	
	public void setVoided(Boolean voided) {
		this.voided = voided;
	}
	
	public Integer getCycleNumber() {
		return cycleNumber;
	}
	
	public void setCycleNumber(Integer cycleNumber) {
		this.cycleNumber = cycleNumber;
	}
	
}
