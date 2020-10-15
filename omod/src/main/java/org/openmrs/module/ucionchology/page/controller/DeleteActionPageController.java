package org.openmrs.module.ucionchology.page.controller;

import javax.servlet.http.HttpSession;

import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.module.ucionchology.models.Action;
import org.openmrs.module.uicommons.util.InfoErrorMessageUtil;
import org.springframework.web.bind.annotation.RequestParam;

public class DeleteActionPageController {
	
	UCIOnchologyService onchlogyService;
	
	public String controller(HttpSession session, @RequestParam(required = true, value = "actionId") Integer actionId) {
		
		onchlogyService = Context.getService(UCIOnchologyService.class);
		
		Action action = onchlogyService.getActionsById(actionId);
		action.setVoided(true);
		onchlogyService.saveOrUpdateAction(action);
		InfoErrorMessageUtil.flashInfoMessage(session, "Succesfuly Deleted Drug:" + action.getActionName());
		return "allProtocals";
	}
}
