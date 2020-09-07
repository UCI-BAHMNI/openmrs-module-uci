package org.openmrs.module.ucionchology.page.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.module.ucionchology.models.Action;
import org.openmrs.module.ucionchology.models.StageDay;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

public class ActionPageController {
	
	UCIOnchologyService onchlogyService;
	
	public void post(PageModel model, @RequestParam(required = true, value = "actionName") String actionName,
	        @RequestParam(required = true, value = "description") String description,
	        
	        @RequestParam(required = true, value = "days") List<Integer> allDaysId) {
		
		onchlogyService = Context.getService(UCIOnchologyService.class);
		
		Action action = new Action();
		action.setActionName(actionName);
		action.setDescription(description);
		onchlogyService.saveOrUpdateAction(action);
		for (Integer dayId : allDaysId) {
			Set<Action> actions = new HashSet();
			StageDay day = onchlogyService.getStageDayById(dayId);
			actions.addAll(day.getDayActions());
			actions.add(action);
			day.setDayActions(actions);
			onchlogyService.saveOrUpdateStageDay(day);
		}
	}
	
	public void get(PageModel model) {
	}
}
