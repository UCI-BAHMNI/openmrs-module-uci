/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.ucionchology.api;

import java.util.Date;
import java.util.List;

import org.openmrs.Patient;
import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.ucionchology.models.DayDrugDosage;
import org.openmrs.module.ucionchology.models.PatientProtocol;
import org.openmrs.module.ucionchology.models.Phase;
import org.openmrs.module.ucionchology.models.Protocol;
import org.openmrs.module.ucionchology.models.StageDay;
import org.springframework.transaction.annotation.Transactional;

/**
 * The main service of this module, which is exposed for other modules. See
 * moduleApplicationContext.xml on how it is wired up.
 */
public interface UCIOnchologyService extends OpenmrsService {
	
	// methods to work on a Protocal
	@Transactional
	public Protocol saveOrUpdateProtocal(Protocol protocal) throws APIException;
	
	@Transactional
	public Protocol getProtocalById(int protocalId) throws APIException;
	
	@Transactional
	List<Protocol> getAllProtocals() throws APIException;
	
	@Transactional
	public void deleteProtocal(Protocol protocal) throws APIException;
	
	@Transactional
	public Protocol voidProtocal(Protocol protocal) throws APIException;
	
	// methods to work on a Phase
	@Transactional
	public Phase saveOrUpdatePhase(Phase phase) throws APIException;
	
	@Transactional
	public Phase getPhaseById(int phaseId) throws APIException;
	
	@Transactional
	public List<Phase> getAllphases() throws APIException;
	
	@Transactional
	public void deletePhase(Phase phase) throws APIException;
	
	@Transactional
	public Phase voidPhase(Phase phase) throws APIException;
	
	// methods to work on a stageDay
	
	@Transactional
	public StageDay saveOrUpdateStageDay(StageDay phase) throws APIException;
	
	@Transactional
	public StageDay getStageDayById(StageDay phase) throws APIException;
	
	@Transactional
	public List<StageDay> getAllStageDay() throws APIException;
	
	@Transactional
	public void deleteStageDay(StageDay phase) throws APIException;
	
	@Transactional
	public StageDay voidStageDay(StageDay phase) throws APIException;
	
	// methods to work on a dayDrugDosage
	@Transactional
	public DayDrugDosage saveOrUpdateDayDrugDosage(DayDrugDosage phase) throws APIException;
	
	@Transactional
	public DayDrugDosage getDayDrugDosageById(DayDrugDosage phase) throws APIException;
	
	@Transactional
	public List<DayDrugDosage> getAllDayDrugDosage() throws APIException;
	
	@Transactional
	public void deleteDayDrugDosage(DayDrugDosage phase) throws APIException;
	
	@Transactional
	public DayDrugDosage voidDayDrugDosage(DayDrugDosage phase) throws APIException;
	
	// methods to work on a patientProtocal
	@Transactional
	public PatientProtocol saveOrUpdatePatientProtocol(PatientProtocol phase) throws APIException;
	
	@Transactional
	public PatientProtocol getDayPatientProtocolById(PatientProtocol phase) throws APIException;
	
	@Transactional
	public List<PatientProtocol> getAllPatientProtocol() throws APIException;
	
	@Transactional
	public void deletePatientProtocol(PatientProtocol phase) throws APIException;
	
	@Transactional
	public PatientProtocol voidPatientProtocol(PatientProtocol phase) throws APIException;
	
	// methods to work on Protocal
	@Transactional
	public List<Patient> getPatienstByProtocal(PatientProtocol phase) throws APIException;
	
	@Transactional
	public List<Patient> getPatienstByDate(Date date) throws APIException;
	
	public Protocol getPatientCurrentProtocal(Patient patient) throws APIException;
	
}
