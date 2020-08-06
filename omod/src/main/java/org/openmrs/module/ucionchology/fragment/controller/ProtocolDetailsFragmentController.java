package org.openmrs.module.ucionchology.fragment.controller;

import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.module.ucionchology.models.Protocol;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

public class ProtocolDetailsFragmentController {
	
	UCIOnchologyService onchlogyService;
	
	public void controller(PageModel model, @RequestParam(required = true, value = "id") Integer id) {
		onchlogyService = Context.getService(UCIOnchologyService.class);
		
		Protocol protocol = onchlogyService.getProtocalById(id);
		model.addAttribute("protocol", protocol);
	}
}
