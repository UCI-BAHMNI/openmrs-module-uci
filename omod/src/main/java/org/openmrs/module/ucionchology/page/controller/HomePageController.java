package org.openmrs.module.ucionchology.page.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.openmrs.User;
import org.openmrs.api.ConceptService;
import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.module.ucionchology.models.ProtocalDiagnosis;
import org.openmrs.module.ucionchology.models.Protocol;
import org.openmrs.module.ucionchology.utils.createDiagnosisUtil;
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
		User creator = Context.getUserContext().getAuthenticatedUser();
		Protocol protocol = new Protocol();
		protocol.setProtocalName(protocalName);
		protocol.setNumberOfPhases(numberOfPhases);
		protocol.setCyclic(isCyclic);
		protocol.setCreator(creator);
		onchlogyService.saveOrUpdateProtocal(protocol);
		
		List<String> diagnoses = createDiagnosisUtil.createDiagnosesNames(diagnosisCodes);
		
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
