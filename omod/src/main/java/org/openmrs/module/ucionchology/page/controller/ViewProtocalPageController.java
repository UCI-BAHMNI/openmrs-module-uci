package org.openmrs.module.ucionchology.page.controller;

import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.module.ucionchology.models.Protocol;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

public class ViewProtocalPageController {
	
	UCIOnchologyService onchlogyService;
	
	public void controller(PageModel model, @RequestParam(required = true, value = "protocalId") Integer protocalId) {
		
		onchlogyService = Context.getService(UCIOnchologyService.class);
		
		Protocol protocol = onchlogyService.getProtocalById(protocalId);
		model.addAttribute("protocol", protocol);
	}
}
