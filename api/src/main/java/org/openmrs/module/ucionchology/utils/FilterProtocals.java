package org.openmrs.module.ucionchology.utils;

import java.util.ArrayList;
import java.util.List;

import org.openmrs.Concept;
import org.openmrs.Obs;
import org.openmrs.api.ConceptService;
import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.UCIOnchologyConstants;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.module.ucionchology.models.ProtocalDiagnosis;
import org.openmrs.module.ucionchology.models.Protocol;

public class FilterProtocals {
	
	public static List<Protocol> filtererdProtocals(int PatientId) {
		
		UCIOnchologyService onchlogyService = Context.getService(UCIOnchologyService.class);
		List<Protocol> protocals = onchlogyService.getAllProtocals();
		List<Protocol> workingProtocals = new ArrayList<Protocol>();
		ConceptService conceptService = Context.getConceptService();
		
		Concept cancerDiagnosis = conceptService
		        .getConceptByUuid(UCIOnchologyConstants.WORKING_CANCER_DIAGNOSIS_CONCEPT_UUID);
		
		Obs latestObs = onchlogyService.getLastObsForPerson(PatientId, cancerDiagnosis.getConceptId());
		
		String patientDiagnosis = "XXX";
		if (latestObs != null) {
			patientDiagnosis = latestObs.getValueCoded().getName().getName();
		}
		
		for (Protocol protocal : protocals) {
			
			List<String> diagnoses = new ArrayList<String>();
			for (ProtocalDiagnosis diagnosis : protocal.getDiagnoses()) {
				diagnoses.add(diagnosis.getDiagnosis());
			}
			if (diagnoses.contains(patientDiagnosis)) {
				workingProtocals.add(protocal);
			}
		}
		return workingProtocals;
	}
}
