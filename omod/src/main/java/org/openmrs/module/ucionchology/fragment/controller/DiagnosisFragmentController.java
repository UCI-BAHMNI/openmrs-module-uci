/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.ucionchology.fragment.controller;

import java.util.ArrayList;
import java.util.List;

import org.openmrs.Concept;
import org.openmrs.ConceptMap;
import org.openmrs.api.ConceptService;
import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.UCIOnchologyConstants;
import org.openmrs.ui.framework.fragment.FragmentModel;

/**
 *  * Controller for a fragment that shows all users  
 */
public class DiagnosisFragmentController {
	
	ConceptService conceptService;
	
	public void controller(FragmentModel model) {
		
		conceptService = Context.getConceptService();
		
		List<Concept> concepts = conceptService.getConceptByName(UCIOnchologyConstants.DIAGNOSIS_CONCEPT_SET_NAME)
		        .getSetMembers();
		
		List<String> names = new ArrayList<String>();
		for (Concept c : concepts) {
			for (ConceptMap map : c.getConceptMappings()) {
				if (map.getConceptReferenceTerm().getConceptSource() == conceptService
				        .getConceptSourceByName(UCIOnchologyConstants.DIAGNOSIS_CONCEPT_SOURCE)) {
					String code = map.getConceptReferenceTerm().getCode();
					names.add(code + " - " + c.getName().getName());
				}
			}
			
		}
		
		model.addAttribute("diagnoses", names);
	}
	
}
