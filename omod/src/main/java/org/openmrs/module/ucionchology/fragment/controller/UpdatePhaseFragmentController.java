package org.openmrs.module.ucionchology.fragment.controller;

import org.apache.commons.lang3.StringUtils;
import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.module.ucionchology.models.Phase;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

public class UpdatePhaseFragmentController {
	
	UCIOnchologyService onchlogyService;
	
	public void post(PageModel model, @RequestParam(required = false, value = "phaseName") String phaseName,
	        @RequestParam(required = true, value = "phaseId") Integer phaseId,
	        @RequestParam(required = false, value = "phase_order") Integer phase_order) {
		
		onchlogyService = Context.getService(UCIOnchologyService.class);
		Phase phase = onchlogyService.getPhaseById(phaseId);
		
		if (StringUtils.isNotBlank(phaseName)) {
			phase.setPhaseName(phaseName);
		}
		
		if (phase_order != null) {
			phase.setOrder(phase_order);
		}
		
		onchlogyService.saveOrUpdatePhase(phase);
	}
	
	public void get(PageModel model) {
	}
}
