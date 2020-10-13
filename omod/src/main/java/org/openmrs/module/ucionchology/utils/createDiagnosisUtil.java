package org.openmrs.module.ucionchology.utils;

import java.util.ArrayList;
import java.util.List;

import org.openmrs.Concept;
import org.openmrs.api.ConceptService;
import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.UCIOnchologyConstants;

public class createDiagnosisUtil {
	
	public static List<String> createDiagnosesNames(String diagnosisCodes) {
		ConceptService service = Context.getConceptService();
		
		String array[] = diagnosisCodes.split("-", 2);
		String code = array[0].trim();
		
		List<String> diagnoses = new ArrayList<String>();
		
		try {
			List<Concept> concepts = service.getConceptsByMapping(code, UCIOnchologyConstants.DIAGNOSIS_CONCEPT_SOURCE,
			    false);
			for (Concept c1 : concepts) {
				if (c1 != null) {
					diagnoses.add(c1.getName().getName());
				}
			}
		}
		catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
		for (int x = 0; x < 10; x += 1) {
			String var = "." + x;
			StringBuffer code2 = new StringBuffer(code);
			if (var.length() <= 2) {
				code2.replace(3, 4, var);
			}
			
			try {
				List<Concept> concepts_2 = service.getConceptsByMapping(code2.toString(),
				    UCIOnchologyConstants.DIAGNOSIS_CONCEPT_SOURCE, false);
				for (Concept c2 : concepts_2) {
					if (c2 != null) {
						diagnoses.add(c2.getName().getName());
					}
				}
			}
			catch (Exception e) {
				
			}
		}
		
		return diagnoses;
	}
}
