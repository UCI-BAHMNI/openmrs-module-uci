package org.openmrs.module.ucionchology.page.controller;

import javax.servlet.http.HttpSession;

import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.module.ucionchology.models.Phase;
import org.springframework.web.bind.annotation.RequestParam;
import org.openmrs.module.uicommons.util.InfoErrorMessageUtil;
import org.openmrs.ui.framework.page.Redirect;

public class DeletePhasePageController {
	
	UCIOnchologyService onchlogyService;
	
	public Redirect controller(HttpSession session, @RequestParam(required = true, value = "phaseId") Integer phaseId) {
		
		onchlogyService = Context.getService(UCIOnchologyService.class);
		
		Phase phase = onchlogyService.getPhaseById(phaseId);
		phase.setVoided(true);
		int protocalId = phase.getProtocol1().getId();
		onchlogyService.saveOrUpdatePhase(phase);
		InfoErrorMessageUtil.flashInfoMessage(session, "Succesfuly Voided Phase:" + phase.getPhaseName());
		return new Redirect("ucionchology", "viewProtocal", "protocalId=" + protocalId);
	}
}
