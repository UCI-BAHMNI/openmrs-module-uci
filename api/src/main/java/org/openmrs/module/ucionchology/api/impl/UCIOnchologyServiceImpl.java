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
import org.openmrs.api.UserService;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.module.ucionchology.api.dao.UCIOnchologyDao;
import org.openmrs.module.ucionchology.models.DayDrugDosage;
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
	public Protocol voidProtocal(Protocol protocal) throws APIException {
		return dao.voidProtocal(protocal);
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
	public Phase voidPhase(Phase phase) throws APIException {
		return dao.voidPhase(phase);
	}

	@Override
	public StageDay saveOrUpdateStageDay(StageDay stageDay) throws APIException {
		return dao.saveOrUpdateStageDay(stageDay);
	}

	@Override
	public StageDay getStageDayById(StageDay phase) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StageDay> getAllStageDay() throws APIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStageDay(StageDay phase) throws APIException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StageDay voidStageDay(StageDay phase) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DayDrugDosage saveOrUpdateDayDrugDosage(DayDrugDosage phase) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DayDrugDosage getDayDrugDosageById(DayDrugDosage phase) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DayDrugDosage> getAllDayDrugDosage() throws APIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDayDrugDosage(DayDrugDosage phase) throws APIException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DayDrugDosage voidDayDrugDosage(DayDrugDosage phase) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PatientProtocol saveOrUpdatePatientProtocol(PatientProtocol phase) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PatientProtocol getDayPatientProtocolById(PatientProtocol phase) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PatientProtocol> getAllPatientProtocol() throws APIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePatientProtocol(PatientProtocol phase) throws APIException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PatientProtocol voidPatientProtocol(PatientProtocol phase) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> getPatienstByProtocal(PatientProtocol phase) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> getPatienstByDate(Date date) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Protocol getPatientCurrentProtocal(Patient patient) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Injected in moduleApplicationContext.xml
	 */
	
}
