package org.openmrs.module.ucionchology.page.controller;

import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.module.ucionchology.models.Protocol;
import org.springframework.web.bind.annotation.RequestParam;

public class DeleteProtocalPageController {
	
	UCIOnchologyService onchlogyService;
	
	public String controller(@RequestParam(required = true, value = "protocalId") Integer protocalId) {
		
		onchlogyService = Context.getService(UCIOnchologyService.class);
		
		Protocol protocal = onchlogyService.getProtocalById(protocalId);
		protocal.setVoided(true);
		onchlogyService.saveOrUpdateProtocal(protocal);
		
		return "allProtocals";
	}
}
