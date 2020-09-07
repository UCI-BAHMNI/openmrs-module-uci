package org.openmrs.module.ucionchology.page.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.openmrs.User;
import org.openmrs.api.ConceptService;
import org.openmrs.api.context.Context;
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
	        @RequestParam(required = true, value = "diagnoses") List<String> diagnoses,
	        @RequestParam(required = true, value = "numberOfPhases") Integer numberOfPhases) {
		onchlogyService = Context.getService(UCIOnchologyService.class);
		User creator = Context.getUserContext().getAuthenticatedUser();
		Protocol protocol = new Protocol();
		protocol.setProtocalName(protocalName);
		protocol.setNumberOfPhases(numberOfPhases);
		protocol.setCreator(creator);
		onchlogyService.saveOrUpdateProtocal(protocol);
		
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
