package org.openmrs.module.ucionchology.fragment.controller;

import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

public class ViewPatientProtocalFragmentController {
	
	UCIOnchologyService onchlogyService;
	
	public void controller(PageModel model, @RequestParam("patientId") Patient patient) {
		
		onchlogyService = Context.getService(UCIOnchologyService.class);
		model.addAttribute("innitialisedProtocal", onchlogyService.getPatientProtocalByPatient(patient.getPatientId()));
	}
}
