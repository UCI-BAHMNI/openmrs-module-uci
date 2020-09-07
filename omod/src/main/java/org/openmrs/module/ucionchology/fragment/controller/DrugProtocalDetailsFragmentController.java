package org.openmrs.module.ucionchology.fragment.controller;

import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

public class DrugProtocalDetailsFragmentController {
	
	public void controller(PageModel model, @RequestParam(required = true, value = "phaseId") Integer phaseId) {
		UCIOnchologyService onchlogyService = Context.getService(UCIOnchologyService.class);
		model.addAttribute("day_phase", onchlogyService.getPhaseById(phaseId));
		
		model.addAttribute("actionPhaseDays", onchlogyService.getDaysByPhase(phaseId));
	}
}
