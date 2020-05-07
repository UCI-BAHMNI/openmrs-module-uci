package org.openmrs.module.ucionchology.api;

import java.util.Locale;

import org.openmrs.Concept;
import org.openmrs.ConceptClass;
import org.openmrs.ConceptDatatype;
import org.openmrs.ConceptDescription;
import org.openmrs.ConceptName;
import org.openmrs.api.ConceptService;
import org.openmrs.api.context.Context;

public class CreateDiagnosisConcepts {
	
	public static Concept CreateConcept() {
		ConceptService service = Context.getConceptService();
		
		final String concept_name = "Working Cancer Diagnosis";
		final String cocept_source = "ICD-10-WHO";
		
		if (service.getConceptByName(concept_name) != null) {
			return null;
		}
		ConceptName name = new ConceptName(concept_name, Locale.ENGLISH);
		
		Concept concept = new Concept();
		concept.addName(name);
		concept.addDescription(new ConceptDescription("Diagnosis For all ICD-0-3 Concepts", null));
		
		ConceptClass concept_class = service.getConceptClassByName("ConvSet");
		ConceptDatatype dataType = service.getConceptDatatypeByName("N/A");
		concept.setDatatype(dataType);
		concept.setConceptClass(concept_class);
		
		for (int i = 0; i < 100; i++) {
			for (int x = 0; x < 10; x += 1) {
				String var = i + "." + x;
				StringBuffer code = new StringBuffer("C00");
				if (var.length() <= 3) {
					code.replace(2, 4, var);
				} else {
					code.replace(1, 4, var);
				}
				
				try {
					Concept icd = service.getConceptByMapping(code.toString(), cocept_source);
					if (icd != null) {
						
						concept.addSetMember(icd);
						;
					}
				}
				catch (Exception e) {
					
				}
			}
		}
		return service.saveConcept(concept);
	}
}
