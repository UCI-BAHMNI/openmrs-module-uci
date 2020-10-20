package org.openmrs.module.ucionchology.page.controller;

import javax.servlet.http.HttpSession;

import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.module.ucionchology.models.DayDrugDosage;
import org.openmrs.module.uicommons.util.InfoErrorMessageUtil;
import org.springframework.web.bind.annotation.RequestParam;
import org.openmrs.ui.framework.page.Redirect;

public class DeleteDrugPageController {
	
	UCIOnchologyService onchlogyService;
	
	public Redirect controller(HttpSession session, @RequestParam(required = true, value = "drugId") Integer drugId,
	        @RequestParam(required = true, value = "dayId") Integer dayId) {
		
		onchlogyService = Context.getService(UCIOnchologyService.class);
		
		DayDrugDosage drug = onchlogyService.getDayDrugDosageById(drugId);
		drug.setVoided(true);
		onchlogyService.saveOrUpdateDayDrugDosage(drug);
		InfoErrorMessageUtil.flashInfoMessage(session, "Succesfuly Deleted Drug:" + drug.getDrugName());
		return new Redirect("ucionchology", "viewDay", "dayId=" + dayId);
	}
}
