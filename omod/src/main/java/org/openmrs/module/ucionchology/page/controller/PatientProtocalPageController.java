package org.openmrs.module.ucionchology.page.controller;

import org.openmrs.Patient;
import org.openmrs.module.ucionchology.utils.FilterProtocals;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

public class PatientProtocalPageController {
	
	public void controller(PageModel model, @RequestParam("patientId") Patient patient) {
		model.addAttribute("patient", patient);
		
		model.addAttribute("protocals", FilterProtocals.filtererdProtocals(patient.getPatientId()));
	}
}
