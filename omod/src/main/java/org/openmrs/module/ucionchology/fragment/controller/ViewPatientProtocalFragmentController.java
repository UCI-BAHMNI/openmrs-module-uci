package org.openmrs.module.ucionchology.fragment.controller;

import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.module.ucionchology.models.Action;
import org.openmrs.module.ucionchology.models.DayDrugDosage;
import org.openmrs.module.ucionchology.models.PatientProtocol;
import org.openmrs.module.ucionchology.models.Phase;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

import org.openmrs.module.ucionchology.models.StageDay;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Calendar;

public class ViewPatientProtocalFragmentController {
	
	UCIOnchologyService onchlogyService;
	
	public void controller(PageModel model, @RequestParam("patientId") Patient patient) throws ParseException {
		
		onchlogyService = Context.getService(UCIOnchologyService.class);
		PatientProtocol patientProtocal = onchlogyService.getPatientProtocalByPatient(patient.getPatientId());
		model.addAttribute("innitialisedProtocal", patientProtocal);
		Integer totalDays = 0;
		
		List<StageDay> daysList = new ArrayList<StageDay>();
		
		if (patientProtocal.getProtocol3().isCyclic()) {
			for (int y = 1; y <= patientProtocal.getProtocol3().getNumberOfPhases(); y++) {
				for (Phase phase : patientProtocal.getProtocol3().getSortedPhases()) {
					totalDays += phase.getNumberOfDays();
					for (StageDay day : phase.getSortedDays()) {
						daysList.add(day);
					}
				}
			}
		} else {
			for (Phase phase : patientProtocal.getProtocol3().getSortedPhases()) {
				totalDays += phase.getNumberOfDays();
				for (StageDay day : phase.getSortedDays()) {
					daysList.add(day);
				}
			}
		}
		
		Date startDate = patientProtocal.getDateStarted();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formatedStartDate = sdf.format(startDate);
		
		StageDay[] daysArray = new StageDay[daysList.size()];
		daysArray = daysList.toArray(daysArray);
		
		JSONArray eventsArray = new JSONArray();
		if (totalDays > 0) {
			for (int x = 0; x < totalDays; x++) {
				StageDay day = daysArray[x];
				
				Calendar c = Calendar.getInstance();
				c.setTime(sdf.parse(formatedStartDate));
				c.add(Calendar.DAY_OF_MONTH, x);
				
				if (day.getDosage().size() > 0) {
					JSONObject event = new JSONObject();
					for (DayDrugDosage drug : day.getDosage()) {
						event.put("title", drug.getDrugName());
						event.put("start", sdf.format(c.getTime()));
						event.put("rendering", "background");
						eventsArray.put(event);
					}
				}
				
				if (day.getDayActions().size() > 0) {
					JSONObject event = new JSONObject();
					for (Action action : day.getDayActions()) {
						event.put("title", action.getDescription());
						event.put("start", sdf.format(c.getTime()));
						event.put("rendering", "background");
						event.put("color", "#ff9f89");
						eventsArray.put(event);
					}
				}
			}
			
		}
		
		model.addAttribute("events", eventsArray);
	}
}
