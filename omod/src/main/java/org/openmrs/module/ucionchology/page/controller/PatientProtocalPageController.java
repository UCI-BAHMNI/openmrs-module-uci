package org.openmrs.module.ucionchology.page.controller;

import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

public class PatientProtocalPageController {
	
	UCIOnchologyService onchlogyService;
	
	public void controller(PageModel model, @RequestParam("patientId") Patient patient) {
		model.addAttribute("patient", patient);
		
		onchlogyService = Context.getService(UCIOnchologyService.class);
		
		model.addAttribute("protocals", onchlogyService.getAllProtocals());
	}
}
