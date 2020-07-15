package org.openmrs.module.ucionchology.api;

import java.util.List;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Concept;
import org.openmrs.ConceptAnswer;
import org.openmrs.ConceptClass;
import org.openmrs.ConceptDatatype;
import org.openmrs.ConceptDescription;
import org.openmrs.ConceptName;
import org.openmrs.api.APIException;
import org.openmrs.api.ConceptService;
import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.UCIOnchologyConstants;

public class CreateDiagnosisConcepts {
	
	private Log log = LogFactory.getLog(this.getClass());
	
	public static void CreateDiagnosisSetofSetsConcept() {
		ConceptService service = Context.getConceptService();
		
		if (service.getConceptByName(UCIOnchologyConstants.DIAGNOSIS_CONCEPT_SET_OF_SETS) == null) {
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
	
	public static void CreateSymptomsConceptSet() {
		ConceptService service = Context.getConceptService();
		if (service.getConceptByName(UCIOnchologyConstants.SYMPTOMS_CONCEPT_SET_NAME) == null) {
			
			ConceptName name = new ConceptName(UCIOnchologyConstants.SYMPTOMS_CONCEPT_SET_NAME, Locale.ENGLISH);
			
			Concept concept = new Concept();
			concept.addName(name);
			concept.addDescription(new ConceptDescription("all ICD-10-WHO Symptoms  Concepts bteween R00.0 - R99.9",
			        Locale.ENGLISH));
			concept.setUuid(UCIOnchologyConstants.SYMPTOMS_SET_CONCEPT_UUID);
			ConceptClass concept_class = service.getConceptClassByName("ConvSet");
			ConceptDatatype dataType = service.getConceptDatatypeByName("N/A");
			concept.setDatatype(dataType);
			concept.setConceptClass(concept_class);
			
			for (int i = 0; i < 100; i++) {
				
				StringBuffer code2 = new StringBuffer("R0");
				String var2 = Integer.toString(i);
				if (var2.length() <= 1) {
					code2.replace(2, 2, var2);
				} else {
					code2.replace(1, 2, var2);
				}
				
				try {
					List<Concept> concepts = service.getConceptsByMapping(code2.toString(),
					    UCIOnchologyConstants.DIAGNOSIS_CONCEPT_SOURCE, false);
					for (Concept c1 : concepts) {
						if (c1 != null) {
							concept.addSetMember(c1);
						}
					}
				}
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				for (int x = 0; x < 10; x += 1) {
					String var = i + "." + x;
					StringBuffer code = new StringBuffer("R00");
					if (var.length() <= 3) {
						code.replace(2, 4, var);
					} else {
						code.replace(1, 4, var);
					}
					
					try {
						List<Concept> concepts_2 = service.getConceptsByMapping(code.toString(),
						    UCIOnchologyConstants.DIAGNOSIS_CONCEPT_SOURCE, false);
						for (Concept c2 : concepts_2) {
							if (c2 != null) {
								concept.addSetMember(c2);
							}
						}
					}
					catch (Exception e) {
						
					}
				}
			}
			
			service.saveConcept(concept);
		}
		
	}
	
	public static void CreateWorkingDiagnosisConceptSet() {
		
		ConceptService service = Context.getConceptService();
		if (service.getConceptByName(UCIOnchologyConstants.DIAGNOSIS_CONCEPT_SET_NAME) == null) {
			ConceptName name = new ConceptName(UCIOnchologyConstants.DIAGNOSIS_CONCEPT_SET_NAME, Locale.ENGLISH);
			
			Concept concept = new Concept();
			concept.addName(name);
			concept.addDescription(new ConceptDescription("all ICD-10-WHO Diagnosis  Concepts between C00.0-C99.9",
			        Locale.ENGLISH));
			concept.setUuid(UCIOnchologyConstants.DIAGNOSIS_SET_CONCEPT_UUID);
			ConceptClass concept_class = service.getConceptClassByName("ConvSet");
			ConceptDatatype dataType = service.getConceptDatatypeByName("N/A");
			concept.setDatatype(dataType);
			concept.setConceptClass(concept_class);
			
			for (int i = 0; i < 100; i++) {
				
				StringBuffer code2 = new StringBuffer("C0");
				String var2 = Integer.toString(i);
				if (var2.length() <= 1) {
					code2.replace(2, 2, var2);
				} else {
					code2.replace(1, 2, var2);
				}
				
				try {
					List<Concept> concepts = service.getConceptsByMapping(code2.toString(),
					    UCIOnchologyConstants.DIAGNOSIS_CONCEPT_SOURCE, false);
					for (Concept c1 : concepts) {
						if (c1 != null) {
							concept.addSetMember(c1);
						}
					}
				}
				catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
				for (int x = 0; x < 10; x += 1) {
					String var = i + "." + x;
					StringBuffer code = new StringBuffer("C00");
					if (var.length() <= 3) {
						code.replace(2, 4, var);
					} else {
						code.replace(1, 4, var);
					}
					
					try {
						List<Concept> concepts_2 = service.getConceptsByMapping(code.toString(),
						    UCIOnchologyConstants.DIAGNOSIS_CONCEPT_SOURCE, false);
						for (Concept c2 : concepts_2) {
							if (c2 != null) {
								concept.addSetMember(c2);
							}
						}
					}
					catch (Exception e) {
						
					}
				}
			}
			
			service.saveConcept(concept);
		}
		
	}
	
	public static void ConvertMedicationConcept() {
		ConceptService service = Context.getConceptService();
		Concept concept = service.getConcept(161189);
		ConceptDatatype CodedDataType = service.getConceptDatatypeByName("Coded");
		concept.setDatatype(CodedDataType);
		service.saveConcept(concept);
	}
}
