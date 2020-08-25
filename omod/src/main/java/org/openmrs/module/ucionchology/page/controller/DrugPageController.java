package org.openmrs.module.ucionchology.page.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openmrs.User;
import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.module.ucionchology.models.DayDrugDosage;
import org.openmrs.module.ucionchology.models.StageDay;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

public class DrugPageController {
	
	UCIOnchologyService onchlogyService;
	
	public void post(PageModel model, @RequestParam(required = true, value = "drugName") String drugName,
	        @RequestParam(required = true, value = "units") String units,
	        @RequestParam(required = true, value = "dosageValue") Integer dosageValue,
	        @RequestParam(required = false, value = "maxDoseValue") Integer maxDoseValue,
	        @RequestParam(required = true, value = "routes") String route,
	        @RequestParam(required = true, value = "dosageFrequence") String dosageFrequence,
	        @RequestParam(required = true, value = "days") List<Integer> allDaysId) {
		
		onchlogyService = Context.getService(UCIOnchologyService.class);
		
		Set<StageDay> days = new HashSet();
		for (Integer dayId : allDaysId) {
			StageDay day = onchlogyService.getStageDayById(dayId);
			days.add(day);
		}
		User creator = Context.getUserContext().getAuthenticatedUser();
		DayDrugDosage drug = new DayDrugDosage();
		drug.setDrugName(drugName);
		drug.setUnits(units);
		drug.setDosageValue(dosageValue);
		drug.setDosageRoute(route);
		drug.setDosageFrequence(dosageFrequence);
		drug.setMaxDoseValue(maxDoseValue);
		drug.setCreator(creator);
		drug.setStageDays(days);
		onchlogyService.saveOrUpdateDayDrugDosage(drug);
	}
	
	public void get(PageModel model) {
	}
	
}
