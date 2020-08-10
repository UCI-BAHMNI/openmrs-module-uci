package org.openmrs.module.ucionchology.fragment.controller;

import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.ui.framework.fragment.FragmentModel;
import org.springframework.web.bind.annotation.RequestParam;

public class DaysFragmentController {
	
	public void controller(FragmentModel model, @RequestParam(required = true, value = "phaseId") Integer phaseId) {
		
		UCIOnchologyService onchlogyService = Context.getService(UCIOnchologyService.class);
		model.addAttribute("days", onchlogyService.getDaysByPhase(phaseId));
	}
}
