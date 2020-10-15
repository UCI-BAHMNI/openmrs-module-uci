package org.openmrs.module.ucionchology.page.controller;

import java.util.ArrayList;
import java.util.List;

import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.module.ucionchology.models.Phase;
import org.openmrs.module.ucionchology.models.Protocol;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

public class EditPhasePageController {
	
	UCIOnchologyService onchlogyService;
	
	public void controller(PageModel model, @RequestParam(required = true, value = "phaseId") Integer phaseId) {
		onchlogyService = Context.getService(UCIOnchologyService.class);
		
		Phase phase = onchlogyService.getPhaseById(phaseId);
		model.addAttribute("phase", phase);
		
		Protocol protocol = onchlogyService.getProtocalById(phase.getProtocol1().getId());
		model.addAttribute("protocol", protocol);
		
		List<Integer> orders = new ArrayList<Integer>();
		for (Integer order = 1; order <= protocol.getNumberOfPhases(); order++) {
			orders.add(order);
		}
		model.addAttribute("orders", orders);
	}
}
