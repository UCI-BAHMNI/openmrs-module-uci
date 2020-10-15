package org.openmrs.module.ucionchology.fragment.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.openmrs.api.ConceptService;
import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.module.ucionchology.models.ProtocalDiagnosis;
import org.openmrs.module.ucionchology.models.Protocol;
import org.openmrs.module.ucionchology.utils.createDiagnosisUtil;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

public class UpdateProtocalFragmentController {
	
	UCIOnchologyService onchlogyService;
	
	ConceptService conceptService;
	
	public void post(PageModel model, HttpSession session,
	        @RequestParam(required = true, value = "protocalId") Integer protocalId,
	        @RequestParam(required = false, value = "protocalName") String protocalName,
	        @RequestParam(required = false, value = "diagnoses") String diagnosisCodes,
	        @RequestParam(required = false, value = "numberOfPhases") Integer numberOfPhases,
	        @RequestParam(required = false, value = "isCyclic") Boolean isCyclic) {
		onchlogyService = Context.getService(UCIOnchologyService.class);
		Protocol protocol = onchlogyService.getProtocalById(protocalId);
		if (StringUtils.isNotBlank(protocalName)) {
			protocol.setProtocalName(protocalName);
		}
		
		if (numberOfPhases != null) {
			protocol.setNumberOfPhases(numberOfPhases);
		}
		if (isCyclic != null) {
			protocol.setCyclic(isCyclic);
		}
		onchlogyService.saveOrUpdateProtocal(protocol);
		
		if (StringUtils.isNotBlank(diagnosisCodes)) {
			Set<ProtocalDiagnosis> oldDiagnoses = protocol.getDiagnoses();
			for (ProtocalDiagnosis diagnosis : oldDiagnoses) {
				onchlogyService.deleteDiagnosis(diagnosis);
			}
			
			List<String> diagnoses = createDiagnosisUtil.createDiagnosesNames(diagnosisCodes);
			for (String diagnosis : diagnoses) {
				ProtocalDiagnosis d = new ProtocalDiagnosis();
				d.setDiagnosis(diagnosis);
				d.setProtocol2(protocol);
				onchlogyService.saveOrUpdateDiagnosis(d);
			}
		}
		
	}
	
	public void get(PageModel model) {
		
	}
}
