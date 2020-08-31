package org.openmrs.module.ucionchology.fragment.controller;

import org.openmrs.ui.framework.fragment.FragmentModel;
import org.springframework.web.bind.annotation.RequestParam;
import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;

public class DrugProtocalDetailsFragmentController {
	
	public void controller(FragmentModel model, @RequestParam(required = true, value = "phaseId") Integer phaseId) {
		UCIOnchologyService onchlogyService = Context.getService(UCIOnchologyService.class);
		model.addAttribute("day_phase", onchlogyService.getPhaseById(phaseId));
	}
}
