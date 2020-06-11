package org.openmrs.module.ucionchology.api;

import java.util.Locale;

import org.openmrs.Concept;
import org.openmrs.ConceptAnswer;
import org.openmrs.ConceptClass;
import org.openmrs.ConceptDatatype;
import org.openmrs.ConceptDescription;
import org.openmrs.ConceptName;
import org.openmrs.api.AdministrationService;
import org.openmrs.api.ConceptService;
import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.UCIOnchologyConstants;

public class CreateDiagnosisConcepts {
	
	public static Concept CreateWorkingDiagnosisConceptSet() {
		ConceptService service = Context.getConceptService();
		
		if (service.getConceptByName(UCIOnchologyConstants.DIAGNOSIS_CONCEPT_SET_NAME) != null) {
			return service.getConceptByName(UCIOnchologyConstants.DIAGNOSIS_CONCEPT_SET_NAME);
		}
		ConceptName name = new ConceptName(UCIOnchologyConstants.DIAGNOSIS_CONCEPT_SET_NAME, Locale.ENGLISH);
		
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
					Concept icd = service.getConceptByMapping(code.toString(),
					    UCIOnchologyConstants.DIAGNOSIS_CONCEPT_SOURCE);
					if (icd != null) {
						concept.addSetMember(icd);
					}
				}
				catch (Exception e) {
					
				}
			}
		}
		
		return service.saveConcept(concept);
	}
	
	public static void CreateSetConcept() {
		ConceptService service = Context.getConceptService();
		
		if (service.getConceptByName(UCIOnchologyConstants.DIAGNOSIS_CONCEPT_SET_OF_SETS) != null) {} else {
			ConceptName Setname = new ConceptName(UCIOnchologyConstants.DIAGNOSIS_CONCEPT_SET_OF_SETS, Locale.ENGLISH);
			
			Concept Setconcept = new Concept();
			Setconcept.addName(Setname);
			
			ConceptClass concept_class = service.getConceptClassByName("ConvSet");
			ConceptDatatype dataType = service.getConceptDatatypeByName("N/A");
			Setconcept.setDatatype(dataType);
			Setconcept.setConceptClass(concept_class);
			
			Concept concept = service.getConceptByName(UCIOnchologyConstants.DIAGNOSIS_CONCEPT_SET_NAME);
			Setconcept.addSetMember(concept);
			service.saveConcept(Setconcept);
		}
		
	}
	
	public static Concept CreateSymptomsConcept() {
		ConceptService service = Context.getConceptService();
		
		if (service.getConceptByName(UCIOnchologyConstants.SYMPTOMS_CONCEPT_NAME) != null) {
			Concept concept = service.getConceptByName(UCIOnchologyConstants.SYMPTOMS_CONCEPT_NAME);
			for (int i = 0; i < 100; i++) {
				for (int x = 0; x < 10; x += 1) {
					String var = i + "." + x;
					StringBuffer code = new StringBuffer("R00");
					if (var.length() <= 3) {
						code.replace(2, 4, var);
					} else {
						code.replace(1, 4, var);
					}
					
					try {
						Concept icd = service.getConceptByMapping(code.toString(),
						    UCIOnchologyConstants.DIAGNOSIS_CONCEPT_SOURCE);
						if (icd != null) {
							ConceptAnswer ans = new ConceptAnswer(icd);
							concept.addAnswer(ans);
						}
					}
					catch (Exception e) {
						
					}
				}
			}
			
			return service.saveConcept(concept);
		}
		
		return new Concept();
	}
	
	public static Concept CreateWorkingDiagnosisConceptCoded() {
		ConceptService service = Context.getConceptService();
		
		if (service.getConceptByName(UCIOnchologyConstants.DIAGNOSIS_CONCEPT_NAME) != null) {
			Concept concept = service.getConceptByName(UCIOnchologyConstants.DIAGNOSIS_CONCEPT_NAME);
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
						Concept icd = service.getConceptByMapping(code.toString(),
						    UCIOnchologyConstants.DIAGNOSIS_CONCEPT_SOURCE);
						if (icd != null) {
							ConceptAnswer ans = new ConceptAnswer(icd);
							concept.addAnswer(ans);
						}
					}
					catch (Exception e) {
						
					}
				}
			}
			
			return service.saveConcept(concept);
		}
		
		return new Concept();
	}
	
	public static void ConvertMedicationConcept() {
		ConceptService service = Context.getConceptService();
		Concept concept = service.getConcept(161189);
		ConceptDatatype CodedDataType = service.getConceptDatatypeByName("Coded");
		concept.setDatatype(CodedDataType);
		service.saveConcept(concept);
	}
}
