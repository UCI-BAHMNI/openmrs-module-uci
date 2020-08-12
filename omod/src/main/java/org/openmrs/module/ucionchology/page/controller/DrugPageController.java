package org.openmrs.module.ucionchology.page.controller;

import org.openmrs.User;
import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.module.ucionchology.models.DayDrugDosage;
import org.openmrs.module.ucionchology.models.Phase;
import org.openmrs.module.ucionchology.models.StageDay;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

public class DrugPageController {
	
	UCIOnchologyService onchlogyService;
	
	public void post(PageModel model, @RequestParam(required = true, value = "drugName") String drugName,
	        @RequestParam(required = true, value = "units") String units,
	        @RequestParam(required = true, value = "dosageValue") Integer dosageValue,
	        @RequestParam(required = true, value = "dosageForm") String dosageForm,
	        @RequestParam(required = true, value = "dosageFrequence") String dosageFrequence,
	        @RequestParam(required = true, value = "dayId") Integer dayId) {
		
		onchlogyService = Context.getService(UCIOnchologyService.class);
		StageDay day = onchlogyService.getStageDayById(dayId);
		
		User creator = Context.getUserContext().getAuthenticatedUser();
		
		DayDrugDosage drug = new DayDrugDosage();
		drug.setDrugName(drugName);
		drug.setUnits(units);
		drug.setDosageValue(dosageValue);
		drug.setDosageForm(dosageForm);
		drug.setDosageFrequence(dosageFrequence);
		drug.setStageDay(day);
		drug.setCreator(creator);
		onchlogyService.saveOrUpdateDayDrugDosage(drug);
	}
	
	public void get(PageModel model) {
	}
	
}
