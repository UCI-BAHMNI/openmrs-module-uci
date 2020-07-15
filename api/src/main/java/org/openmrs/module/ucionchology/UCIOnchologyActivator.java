/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.ucionchology;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Concept;
import org.openmrs.GlobalProperty;
import org.openmrs.api.AdministrationService;
import org.openmrs.api.ConceptService;
import org.openmrs.api.context.Context;
import org.openmrs.module.BaseModuleActivator;
import org.openmrs.module.ucionchology.api.CreateDiagnosisConcepts;
import org.openmrs.module.ucionchology.inntializer.ConceptsInitializer;
import org.openmrs.module.ucionchology.inntializer.HtmlFormsInitializer;
import org.openmrs.module.ucionchology.inntializer.Initializer;
import org.openmrs.module.appframework.service.AppFrameworkService;

/**
 * This class contains the logic that is run every time this module is either started or shutdown
 */
public class UCIOnchologyActivator extends BaseModuleActivator {
	
	HtmlFormsInitializer htmlFormsInitializer;
	
	AdministrationService adminService;
	
	ConceptService conceptService;
	
	private Log log = LogFactory.getLog(this.getClass());
	
	/**
	 * @see #started()
	 */
	public void started() {
		log.info("Started UCI Onchology");
		AppFrameworkService appFrameworkService = Context.getService(AppFrameworkService.class);
		
		try {
			appFrameworkService.disableApp("referenceapplication.registrationapp.registerPatient");
			appFrameworkService.disableApp("referenceapplication.vitals");
			
			for (Initializer initializer : getInitializers()) {
				initializer.started();
			}
			
			CreateDiagnosisConcepts.CreateWorkingDiagnosisConceptSet();
			CreateDiagnosisConcepts.CreateSymptomsConceptSet();
			CreateDiagnosisConcepts.ConvertMedicationConcept();
			CreateDiagnosisConcepts.CreateDiagnosisSetofSetsConcept();
			setConceptsSetGp();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private List<Initializer> getInitializers() {
		List<Initializer> l = new ArrayList<Initializer>();
		l.add(new ConceptsInitializer());
		l.add(new HtmlFormsInitializer(UCIOnchologyConstants.MODULE_ID));
		return l;
	}
	
	/**
	 * @see #shutdown()
	 */
	public void shutdown() {
		log.info("Shutdown UCI Onchology");
	}
	
	public void setConceptsSetGp() {
		adminService = Context.getAdministrationService();
		conceptService = Context.getConceptService();
		try {
			Concept diagnosisSet = conceptService.getConceptByName(UCIOnchologyConstants.DIAGNOSIS_CONCEPT_SET_OF_SETS);
			adminService.setGlobalProperty(UCIOnchologyConstants.DIAGNOSIS_SET_GP, diagnosisSet.getUuid());
		}
		catch (Exception e) {
			log.info("failed to set Concept_set Global Property");
		}
		
	}
	
}
