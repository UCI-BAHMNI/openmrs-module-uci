package org.openmrs.module.ucionchology.fragment.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.module.ucionchology.models.PatientProtocol;
import org.openmrs.module.ucionchology.models.Phase;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Calendar;
import org.openmrs.ui.framework.page.PageModel;

public class CreatePatientProtocalFragmentController {
	
	UCIOnchologyService onchlogyService;
	
	public void post(@RequestParam("patientId") Patient patient, @RequestParam("protocalId") Integer protocalId)
	        throws ParseException {
		
		onchlogyService = Context.getService(UCIOnchologyService.class);
		PatientProtocol protocal = new PatientProtocol();
		protocal.setPatientId(patient.getPatientId());
		protocal.setProtocol3(onchlogyService.getProtocalById(protocalId));
		
		Integer totalDays = 0;
		
		for (Phase phase : onchlogyService.getProtocalById(protocalId).getSortedPhases()) {
			totalDays += phase.getNumberOfDays();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String today = sdf.format(new Date());
		
		Date date = sdf.parse(today);
		
		protocal.setDateStarted(date);
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(today));
		c.add(Calendar.DAY_OF_MONTH, totalDays);
		
		String endDate = sdf.format(c.getTime());
		Date newdate = sdf.parse(endDate);
		protocal.setDateStopped(newdate);
		
		onchlogyService.saveOrUpdatePatientProtocol(protocal);
	}
	
	public void get(PageModel model) {
	}
}
