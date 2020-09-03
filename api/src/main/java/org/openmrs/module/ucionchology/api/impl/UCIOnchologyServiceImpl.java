/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.ucionchology.api.impl;

import java.util.Date;
import java.util.List;

import org.openmrs.Patient;
import org.openmrs.api.APIException;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.module.ucionchology.api.dao.UCIOnchologyDao;
import org.openmrs.module.ucionchology.models.Action;
import org.openmrs.module.ucionchology.models.DayDrugDosage;
import org.openmrs.module.ucionchology.models.ProtocalDiagnosis;
import org.openmrs.module.ucionchology.models.PatientProtocol;
import org.openmrs.module.ucionchology.models.Phase;
import org.openmrs.module.ucionchology.models.Protocol;
import org.openmrs.module.ucionchology.models.StageDay;
import org.springframework.beans.factory.annotation.Autowired;

public class UCIOnchologyServiceImpl extends BaseOpenmrsService implements UCIOnchologyService {
	
	@Autowired
	UCIOnchologyDao dao;
	
	/**
	 * Injected in moduleApplicationContext.xml
	 */
	public void setDao(UCIOnchologyDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Protocol saveOrUpdateProtocal(Protocol protocal) throws APIException {
		
		return dao.saveOrUpdateProtocal(protocal);
	}
	
	@Override
	public Protocol getProtocalById(int protocalId) throws APIException {
		
		return dao.getProtocalById(protocalId);
	}
	
	@Override
	public List<Protocol> getAllProtocals() throws APIException {
		
		return dao.getAllProtocals();
	}
	
	@Override
	public void deleteProtocal(Protocol protocal) throws APIException {
		dao.deleteProtocal(protocal);
	}
	
	@Override
	public Phase saveOrUpdatePhase(Phase phase) throws APIException {
		return dao.saveOrUpdatePhase(phase);
	}
	
	@Override
	public Phase getPhaseById(int phaseId) throws APIException {
		return dao.getPhaseById(phaseId);
	}
	
	@Override
	public List<Phase> getAllphases() throws APIException {
		return dao.getAllphases();
	}
	
	@Override
	public void deletePhase(Phase phase) throws APIException {
		dao.deletePhase(phase);
		
	}
	
	@Override
	public StageDay saveOrUpdateStageDay(StageDay stageDay) throws APIException {
		return dao.saveOrUpdateStageDay(stageDay);
	}
	
	@Override
	public StageDay getStageDayById(int stageDayId) throws APIException {
		return dao.getStageDayById(stageDayId);
	}
	
	@Override
	public List<StageDay> getAllStageDay() throws APIException {
		return dao.getAllStageDay();
	}
	
	@Override
	public void deleteStageDay(StageDay stageDay) throws APIException {
		dao.deleteStageDay(stageDay);
		
	}
	
	@Override
	public DayDrugDosage saveOrUpdateDayDrugDosage(DayDrugDosage drugDayDose) throws APIException {
		return dao.saveOrUpdateDayDrugDosage(drugDayDose);
	}
	
	@Override
	public DayDrugDosage getDayDrugDosageById(int drugDayDoseId) throws APIException {
		return dao.getDayDrugDosageById(drugDayDoseId);
	}
	
	@Override
	public List<DayDrugDosage> getAllDayDrugDosage() throws APIException {
		return dao.getAllDayDrugDosage();
	}
	
	@Override
	public void deleteDayDrugDosage(DayDrugDosage drugDayDose) throws APIException {
		dao.deleteDayDrugDosage(drugDayDose);
		
	}
	
	@Override
	public PatientProtocol saveOrUpdatePatientProtocol(PatientProtocol patientProtocal) throws APIException {
		return dao.saveOrUpdatePatientProtocol(patientProtocal);
	}
	
	@Override
	public PatientProtocol getDayPatientProtocolById(int patientProtocalId) throws APIException {
		
		return dao.getDayPatientProtocolById(patientProtocalId);
	}
	
	@Override
	public List<PatientProtocol> getAllPatientProtocol() throws APIException {
		return dao.getAllPatientProtocol();
	}
	
	@Override
	public void deletePatientProtocol(PatientProtocol patientProtocal) throws APIException {
		dao.deletePatientProtocol(patientProtocal);
		
	}
	
	@Override
	public List<Patient> getPatienstByProtocal(Protocol protocal) throws APIException {
		return dao.getPatienstByProtocal(protocal);
	}
	
	@Override
	public List<Patient> getPatienstByDate(Date date) throws APIException {
		return dao.getPatienstByDate(date);
	}
	
	@Override
	public Protocol getPatientCurrentProtocal(int patientId) throws APIException {
		return dao.getPatientCurrentProtocal(patientId);
	}
	
	@Override
	public List<Phase> getPhasesByProtocol(int protocolId) throws APIException {
		return dao.getPhasesByProtocol(protocolId);
	}
	
	@Override
	public List<StageDay> getDaysByPhase(int phaseId) throws APIException {
		return dao.getDaysByPhase(phaseId);
	}
	
	@Override
	public Action saveOrUpdateAction(Action action) throws APIException {
		return dao.saveOrUpdateAction(action);
	}
	
	@Override
	public Action getActionsById(int actionId) throws APIException {
		return dao.getActionsById(actionId);
	}
	
	@Override
	public List<Action> getActions() throws APIException {
		return dao.getActions();
	}
	
	@Override
	public void deleteAction(Action action) throws APIException {
		dao.deleteAction(action);
	}
	
	@Override
	public ProtocalDiagnosis saveOrUpdateDiagnosis(ProtocalDiagnosis diagnosis) throws APIException {
		return dao.saveOrUpdateDiagnosis(diagnosis);
	}
	
	@Override
	public ProtocalDiagnosis getDiagnosisById(int diagnosisId) throws APIException {
		return dao.getDiagnosisById(diagnosisId);
	}
	
	@Override
	public List<ProtocalDiagnosis> getDiagnoses() throws APIException {
		return dao.getDiagnoses();
	}
	
	@Override
	public void deleteDiagnosis(ProtocalDiagnosis diagnosis) throws APIException {
		dao.deleteDiagnosis(diagnosis);
	}
	
	/**
	 * Injected in moduleApplicationContext.xml
	 */
	
}
