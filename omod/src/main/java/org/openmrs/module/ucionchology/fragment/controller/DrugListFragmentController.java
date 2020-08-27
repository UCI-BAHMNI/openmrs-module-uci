package org.openmrs.module.ucionchology.fragment.controller;

import java.util.ArrayList;
import java.util.List;

import org.openmrs.Concept;
import org.openmrs.ConceptClass;
import org.openmrs.api.ConceptService;
import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.UCIOnchologyConstants;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

public class DrugListFragmentController {
	
	ConceptService conceptService;
	
	public void controller(PageModel model, @RequestParam(required = true, value = "phaseId") Integer phaseId) {
		
		conceptService = Context.getConceptService();
		
		ConceptClass drugClass = conceptService.getConceptClassByName(UCIOnchologyConstants.CONCEPT_CLASS_DRUG);
		List<Concept> concepts = conceptService.getConceptsByClass(drugClass);
		List<String> drugNames = new ArrayList<String>();
		for (Concept c : concepts) {
			drugNames.add(c.getName().getName());
		}
		
		model.addAttribute("drugList", drugNames);
		
		ConceptClass unitsClass = conceptService.getConceptClassByName(UCIOnchologyConstants.CONCEPT_CLASS_UNITS);
		List<Concept> unitsConcepts = conceptService.getConceptsByClass(unitsClass);
		List<String> unitsNames = new ArrayList<String>();
		for (Concept c : unitsConcepts) {
			unitsNames.add(c.getName().getName());
		}
		
		model.addAttribute("unitsList", unitsNames);
		
		List<Concept> routeConcepts = conceptService.getConcept(UCIOnchologyConstants.CONCEPT_ID_ROUTES).getSetMembers();
		
		List<String> routes = new ArrayList<String>();
		for (Concept c : routeConcepts) {
			routes.add(c.getName().getName());
		}
		
		model.addAttribute("routesList", routes);
		
		ConceptClass frequenceClass = conceptService
		        .getConceptClassByName(UCIOnchologyConstants.CONCEPT_CLASS_DRUG_FREQUENCE);
		List<Concept> frequenceConcepts = conceptService.getConceptsByClass(frequenceClass);
		List<String> frequenceList = new ArrayList<String>();
		for (Concept c : frequenceConcepts) {
			frequenceList.add(c.getName().getName());
		}
		
		model.addAttribute("frequecyList", frequenceList);
		
		UCIOnchologyService onchlogyService = Context.getService(UCIOnchologyService.class);
		
		model.addAttribute("phaseDays", onchlogyService.getDaysByPhase(phaseId));

		model.addAttribute("phase", onchlogyService.getPhaseById(phaseId));

	}
	
}
