package org.openmrs.module.ucionchology.page.controller;

import java.text.ParseException;

import org.json.JSONArray;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.module.ucionchology.models.PatientProtocol;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;
import org.openmrs.module.ucionchology.utils.PatientCalenderData;

public class PatientCalenderPageController {
	
	UCIOnchologyService onchlogyService;
	
	public void controller(PageModel model, @RequestParam("patientId") Patient patient) throws ParseException {
		
		onchlogyService = Context.getService(UCIOnchologyService.class);
		PatientProtocol patientProtocal = onchlogyService.getPatientProtocalByPatient(patient.getPatientId());
		model.addAttribute("innitialisedProtocal", patientProtocal);
		
		JSONArray eventsArray = new JSONArray();
		
		if (patientProtocal != null) {
			eventsArray = PatientCalenderData.generateCalenderData(patientProtocal);
			model.addAttribute("events", eventsArray);
		} else {
			model.addAttribute("events", eventsArray);
		}
		
	}
}
