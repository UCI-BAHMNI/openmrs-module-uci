package org.openmrs.module.ucionchology;

import org.junit.Before;
import org.junit.Test;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.module.ucionchology.models.DayDrugDosage;
import org.openmrs.module.ucionchology.models.Phase;
import org.openmrs.module.ucionchology.models.Protocol;
import org.openmrs.module.ucionchology.models.StageDay;
import org.openmrs.test.BaseModuleContextSensitiveTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;

public class ProtocolServiceTest extends BaseModuleContextSensitiveTest {
	
	private UCIOnchologyService service;
	
	// existing patients >>> {2,6,7,8}
	
	@Before
	public void init() throws Exception {
		initializeInMemoryDatabase();
		executeDataSet("protocolTest.xml");
		authenticate();
		service = Context.getService(UCIOnchologyService.class);
	}
	
	//@Test
	public void should_getDrugDosageById() throws Exception {
		Phase phase = new Phase();
		DayDrugDosage drug = service.getDayDrugDosageById(1);
		//System.out.println(drug.getDoseName());
		Assert.assertEquals("", "drug1", drug.getDoseName());
	}
	
	//@Test
	public void should_createDrugDosage() throws Exception {
		//createdrug
		StageDay day = service.getStageDayById(2);
		
		DayDrugDosage dose = new DayDrugDosage();
		dose.setDrugId(2);
		;
		dose.setDoseName("asplin");
		dose.setUnits("spoon");
		dose.setValue(3);
		dose.setStageDay(day);
		
		DayDrugDosage saved_dose = service.saveOrUpdateDayDrugDosage(dose);
		//System.out.println(dose.getDoseName());
		Assert.assertEquals("", "asplin", dose.getDoseName());
	}
	
	//@Test
	public void should_getAllNonVoidedDrugDoses() {
		Assert.assertEquals("", 2, service.getAllDayDrugDosage().size());
	}
	
	//@Test
	public void should_updateDruDose() {
		// void drug
		DayDrugDosage drug = service.getDayDrugDosageById(1);
		//System.out.println(drug.getVoided().toString());
		Assert.assertFalse(drug.getVoided());
		
		drug.setVoided(true);
		service.saveOrUpdateDayDrugDosage(drug);
		DayDrugDosage voided_drug = service.getDayDrugDosageById(1);
		//System.out.println(voided_drug.getVoided().toString());
		Assert.assertTrue(drug.getVoided());
	}
	
	//@Test
	public void getPatientsByProtcal() {
		Protocol protocal = service.getProtocalById(1);
		//System.out.println(service.getPatienstByProtocal(protocal).size());
		int patientSize = service.getPatienstByProtocal(protocal).size();
		Assert.assertEquals("", 3, patientSize);
	}
	
	//@Test
	public void getPatientsByDate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("2020-05-10");
		int patientSize = service.getPatienstByDate(date).size();
		//System.out.println(patientSize);
		Assert.assertEquals("", 2, patientSize);
	}
	
	//@Test
	public void getPatientsCurrentProtocal() throws ParseException {
		Protocol protocal = service.getPatientCurrentProtocal(2);
		int protocaolId = protocal.getId();
		//System.out.println(protocaolId);
		Assert.assertEquals("", 2, protocaolId);
	}
	
	//@Test
	public void getAllProtocalPhases() throws ParseException {
		Protocol protocal = service.getProtocalById(1);
		//System.out.println(protocal.getPhase().size());
		Assert.assertEquals("", 2, protocal.getPhase().size());
	}
	
	@Test
	public void getAllPhasesByProtocol() throws ParseException {
		List<Phase> phases = service.getPhasesByProtocol(1);
		//System.out.println(phases.size());
		Assert.assertEquals("", 2, phases.size());
	}
}
