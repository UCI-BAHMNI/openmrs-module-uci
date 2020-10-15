package org.openmrs.module.ucionchology.page.controller;

import javax.servlet.http.HttpSession;

import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.module.ucionchology.models.Phase;
import org.springframework.web.bind.annotation.RequestParam;
import org.openmrs.module.uicommons.util.InfoErrorMessageUtil;

public class DeletePhasePageController {
	
	UCIOnchologyService onchlogyService;
	
	public String controller(HttpSession session, @RequestParam(required = true, value = "phaseId") Integer phaseId) {
		
		onchlogyService = Context.getService(UCIOnchologyService.class);
		
		Phase phase = onchlogyService.getPhaseById(phaseId);
		phase.setVoided(true);
		onchlogyService.saveOrUpdatePhase(phase);
		InfoErrorMessageUtil.flashInfoMessage(session, "Succesfuly Voided Phase:" + phase.getPhaseName());
		return "allProtocals";
	}
}
