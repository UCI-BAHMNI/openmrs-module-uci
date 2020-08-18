package org.openmrs.module.ucionchology.fragment.controller;

import java.util.List;
import java.util.Set;

import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.module.ucionchology.models.Phase;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

public class DayDetailsFragmentController {
	
	public void controller(PageModel model, @RequestParam(required = true, value = "dayId") Integer dayId) {
		
		UCIOnchologyService onchlogyService = Context.getService(UCIOnchologyService.class);
		model.addAttribute("day", onchlogyService.getStageDayById(dayId));
		
		Phase phase = onchlogyService.getStageDayById(dayId).getPhase();
		
		model.addAttribute("phaseDays", onchlogyService.getDaysByPhase(phase.getId()));
	}
}
