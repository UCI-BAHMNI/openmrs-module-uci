package org.openmrs.module.ucionchology.page.controller;

import org.openmrs.User;
import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.module.ucionchology.models.DayDrugDosage;
import org.openmrs.module.ucionchology.models.Phase;
import org.openmrs.module.ucionchology.models.StageDay;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

public class DayPageController {
	
	UCIOnchologyService onchlogyService;
	
	public void post(PageModel model, @RequestParam(required = true, value = "dayNumber") Integer dayNumber,
	        @RequestParam(required = true, value = "phase_id") Integer phase_id) {
		
		onchlogyService = Context.getService(UCIOnchologyService.class);
		Phase phase = onchlogyService.getPhaseById(phase_id);
		
		User creator = Context.getUserContext().getAuthenticatedUser();
		
		StageDay day = new StageDay();
		day.setDayNumber(dayNumber);
		day.setPhase(phase);
		day.setCreator(creator);
		onchlogyService.saveOrUpdateStageDay(day);
	}
	
	public void get(PageModel model) {
	}
}
