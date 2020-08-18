package org.openmrs.module.ucionchology.page.controller;

import org.openmrs.User;
import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.module.ucionchology.models.Phase;
import org.openmrs.module.ucionchology.models.Protocol;
import org.openmrs.module.ucionchology.models.StageDay;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

public class PhasePageController {
	
	UCIOnchologyService onchlogyService;
	
	public void post(PageModel model, @RequestParam(required = true, value = "phaseName") String phaseName,
	        @RequestParam(required = true, value = "protocol_id") Integer protocol_id,
	        @RequestParam(required = true, value = "numberOfDays") Integer numberOfDays,
	        @RequestParam(required = true, value = "phase_order") Integer phase_order) {
		
		onchlogyService = Context.getService(UCIOnchologyService.class);
		Protocol protocol1 = onchlogyService.getProtocalById(protocol_id);
		
		User creator = Context.getUserContext().getAuthenticatedUser();
		
		Phase phase = new Phase();
		phase.setPhaseName(phaseName);
		phase.setProtocol1(protocol1);
		phase.setOrder(phase_order);
		phase.setCreator(creator);
		phase.setNumberOfDays(numberOfDays);
		onchlogyService.saveOrUpdatePhase(phase);
		
		for (int day = 1; day <= numberOfDays; day++) {
			StageDay newDay = new StageDay();
			newDay.setDayNumber(day);
			newDay.setPhase(onchlogyService.saveOrUpdatePhase(phase));
			newDay.setCreator(creator);
			onchlogyService.saveOrUpdateStageDay(newDay);
		}
		
	}
	
	public void get(PageModel model) {
	}
	
}
