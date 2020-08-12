package org.openmrs.module.ucionchology.fragment.controller;

import java.util.ArrayList;
import java.util.List;

import org.openmrs.Concept;
import org.openmrs.ConceptClass;
import org.openmrs.api.ConceptService;
import org.openmrs.api.context.Context;
import org.openmrs.ui.framework.fragment.FragmentModel;

public class DrugListFragmentController {
	
	ConceptService conceptService;
	
	public void controller(FragmentModel model) {
		
		conceptService = Context.getConceptService();
		
		ConceptClass drugClass = conceptService.getConceptClassByName("Drug");
		List<Concept> concepts = conceptService.getConceptsByClass(drugClass);
		
		List<String> names = new ArrayList<String>();
		for (Concept c : concepts) {
			names.add(c.getName().getName());
		}
		
		model.addAttribute("drugList", names);
	}
}
