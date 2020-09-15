package org.openmrs.module.ucionchology.page.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.openmrs.Concept;
import org.openmrs.User;
import org.openmrs.api.ConceptService;
import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.UCIOnchologyConstants;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.module.ucionchology.models.ProtocalDiagnosis;
import org.openmrs.module.ucionchology.models.Protocol;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

public class HomePageController {
	
	UCIOnchologyService onchlogyService;
	
	ConceptService conceptService;
	
	public void post(PageModel model, HttpSession session,
	        @RequestParam(required = true, value = "protocalName") String protocalName,
	        @RequestParam(required = true, value = "diagnoses") String diagnosisCodes,
	        @RequestParam(required = true, value = "numberOfPhases") Integer numberOfPhases,
	        @RequestParam(required = true, value = "isCyclic") boolean isCyclic) {
		onchlogyService = Context.getService(UCIOnchologyService.class);
		ConceptService service = Context.getConceptService();
		User creator = Context.getUserContext().getAuthenticatedUser();
		Protocol protocol = new Protocol();
		protocol.setProtocalName(protocalName);
		protocol.setNumberOfPhases(numberOfPhases);
		protocol.setCyclic(isCyclic);
		protocol.setCreator(creator);
		onchlogyService.saveOrUpdateProtocal(protocol);
		
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
		
		for (String diagnosis : diagnoses) {
			ProtocalDiagnosis d = new ProtocalDiagnosis();
			d.setDiagnosis(diagnosis);
			d.setProtocol2(protocol);
			onchlogyService.saveOrUpdateDiagnosis(d);
		}
		
	}
	
	public void get(PageModel model) {
		
	}
	
}
