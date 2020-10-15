package org.openmrs.module.ucionchology.page.controller;

import javax.servlet.http.HttpSession;

import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.module.ucionchology.models.Phase;
import org.openmrs.module.ucionchology.models.StageDay;
import org.openmrs.module.uicommons.util.InfoErrorMessageUtil;
import org.springframework.web.bind.annotation.RequestParam;

public class DeleteDayPageController {
	
	UCIOnchologyService onchlogyService;
	
	public String controller(HttpSession session, @RequestParam(required = true, value = "dayId") Integer dayId) {
		
		onchlogyService = Context.getService(UCIOnchologyService.class);
		StageDay day = onchlogyService.getStageDayById(dayId);
		Phase phase = onchlogyService.getPhaseById(day.getPhase().getId());
		
		int dayNum = day.getDayNumber();
		for (StageDay UpdatedDay : phase.getSortedDays()) {
			if (UpdatedDay.getDayNumber() > day.getDayNumber()) {
				UpdatedDay.setDayNumber(dayNum);
				onchlogyService.saveOrUpdateStageDay(UpdatedDay);
				dayNum++;
			}
		}
		
		day.setVoided(true);
		onchlogyService.saveOrUpdateStageDay(day);
		InfoErrorMessageUtil.flashInfoMessage(session, "Succesfuly Deleted Day Day");
		return "allProtocals";
	}
}
