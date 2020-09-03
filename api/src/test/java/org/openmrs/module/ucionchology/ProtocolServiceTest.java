package org.openmrs.module.ucionchology;

import org.junit.Before;
import org.junit.Test;
import org.openmrs.User;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	@Test
	public void should_getDrugDosageById() throws Exception {
		DayDrugDosage drug = service.getDayDrugDosageById(1);
		//System.out.println(drug.getDoseName());
		Assert.assertEquals("", "drug1", drug.getDrugName());
	}
	
	@Test
	public void should_createDrugDosage() throws Exception {
		//createdrug
		StageDay day = service.getStageDayById(2);
		
		DayDrugDosage dose = new DayDrugDosage();
		dose.setDrugName("asplin");
		dose.setUnits("spoon");
		dose.setDosageValue(3);
		dose.setDosageRoute("Mouth");
		dose.setMaxDoseValue(3);
		dose.setDosageFrequence("OD");
		dose.setInstructions("take juice");
		
		DayDrugDosage saved_dose = service.saveOrUpdateDayDrugDosage(dose);
		//System.out.println(dose.getDoseName());
		Assert.assertEquals("", "asplin", saved_dose.getDrugName());
	}
	
	@Test
	public void should_getAllNonVoidedDrugDoses() {
		Assert.assertEquals("", 2, service.getAllDayDrugDosage().size());
	}
	
	@Test
	public void should_updateDruDose() {
		// void drug
		DayDrugDosage drug = service.getDayDrugDosageById(1);
		//System.out.println(drug.getVoided().toString());
		Assert.assertFalse(drug.getVoided());
		
		drug.setVoided(true);
		service.saveOrUpdateDayDrugDosage(drug);
		DayDrugDosage voided_drug = service.getDayDrugDosageById(1);
		//System.out.println(voided_drug.getVoided().toString());
		Assert.assertTrue(voided_drug.getVoided());
	}
	
	@Test
	public void getPatientsByProtcal() {
		Protocol protocal = service.getProtocalById(1);
		//System.out.println(service.getPatienstByProtocal(protocal).size());
		int patientSize = service.getPatienstByProtocal(protocal).size();
		Assert.assertEquals("", 3, patientSize);
	}
	
	@Test
	public void getPatientsByDate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("2020-05-10");
		int patientSize = service.getPatienstByDate(date).size();
		//System.out.println(patientSize);
		Assert.assertEquals("", 2, patientSize);
	}
	
	@Test
	public void getPatientsCurrentProtocal() throws ParseException {
		Protocol protocal = service.getPatientCurrentProtocal(2);
		int protocaolId = protocal.getId();
		//System.out.println(protocaolId);
		Assert.assertEquals("", 2, protocaolId);
	}
	
	@Test
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
	
	@Test
	public void getDaysByPhase() throws ParseException {
		List<StageDay> days = service.getDaysByPhase(1);
		//System.out.println(phases.size());
		Assert.assertEquals("", 2, days.size());
	}
	
	@Test
	public void getDaysForAdrug() throws ParseException {
		//System.out.println(phases.size());
		Assert.assertEquals("", 2, service.getDayDrugDosageById(1).getStageDays().size());
	}
	
	@Test
	public void getdrugsForAday() throws ParseException {
		//System.out.println(phases.size());
		Assert.assertEquals("", 2, service.getStageDayById(1).getDosage().size());
	}
	
	@Test
	public void addDaystoDrug() throws ParseException {
		Set<StageDay> days = new HashSet();
		
		StageDay day1 = new StageDay();
		day1.setId(10);
		day1.setPhase(service.getPhaseById(1));
		
		StageDay day2 = new StageDay();
		day2.setId(10);
		day2.setPhase(service.getPhaseById(1));
		
		days.add(day1);
		days.add(day2);
		
		//DayDrugDosage drug1 = service.getDayDrugDosageById(1);
		DayDrugDosage drug = new DayDrugDosage();
		drug.setId(2);
		drug.setDrugName("drugName");
		drug.setUnits("units");
		drug.setDosageValue(3);
		drug.setDosageRoute("oute");
		drug.setDosageFrequence("dosageFrequence");
		drug.setMaxDoseValue(8);
		drug.setCreator(new User());
		drug.setStageDays(days);
		//System.out.println("all drugs.......................");
		//System.out.println(drug.getStageDays().size());
		
		Assert.assertEquals("", 2, drug.getStageDays().size());
		
	}
	
	@Test
	public void addDaystoPersistedDrug() throws ParseException {
		Set<StageDay> days = new HashSet();
		
		StageDay day1 = new StageDay();
		day1.setId(10);
		day1.setPhase(service.getPhaseById(1));
		
		StageDay day2 = new StageDay();
		day2.setId(11);
		day2.setPhase(service.getPhaseById(1));
		
		StageDay day3 = new StageDay();
		day3.setId(12);
		day3.setPhase(service.getPhaseById(1));
		
		days.add(day1);
		days.add(day2);
		days.add(day3);
		
		DayDrugDosage drug = service.getDayDrugDosageById(1);
		
		drug.setStageDays(days);
		
		//System.out.println("before: all drugs.......................");
		//System.out.println(drug.getStageDays().size());//3
		Assert.assertEquals("", 3, drug.getStageDays().size());
		
		service.saveOrUpdateDayDrugDosage(drug);
		
		//After persisting
		Assert.assertEquals("", 3, service.getDayDrugDosageById(1).getStageDays().size());
	}
	
	@Test
	public void addMoreDaystoPersistedDrug() throws ParseException {
		Set<StageDay> days = new HashSet();
		
		StageDay day1 = new StageDay();
		day1.setId(10);
		day1.setPhase(service.getPhaseById(1));
		
		StageDay day2 = new StageDay();
		day2.setId(11);
		day2.setPhase(service.getPhaseById(1));
		
		StageDay day3 = new StageDay();
		day3.setId(12);
		day3.setPhase(service.getPhaseById(1));
		
		days.add(day1);
		days.add(day2);
		days.add(day3);
		
		DayDrugDosage drug = service.getDayDrugDosageById(1);
		//before adding days
		Assert.assertEquals("", 2, drug.getStageDays().size());
		
		//append more days
		days.addAll(drug.getStageDays());
		drug.setStageDays(days);
		
		//System.out.println("after adding days.......................");
		//System.out.println(drug.getStageDays().size());//3
		Assert.assertEquals("", 5, drug.getStageDays().size());
		
		service.saveOrUpdateDayDrugDosage(drug);
		
		//After persisting
		Assert.assertEquals("", 5, service.getDayDrugDosageById(1).getStageDays().size());
	}
	
	@Test
	public void getallActions() throws ParseException {
		System.out.println(service.getActions().size());
		//System.out.println(service.getActionsById(3).getDescription());
		Assert.assertEquals("", 3, service.getActions().size());
	}
	
	@Test
	public void getallActionForAday() throws ParseException {
		//System.out.println(service.getStageDayById(1).getDayActions().size());
		Assert.assertEquals("", 2, service.getStageDayById(1).getDayActions().size());
	}
	
	@Test
	public void getallDaysForAnAction() throws ParseException {
		//System.out.println(service.getStageDayById(1).getDayActions().size());
		Assert.assertEquals("", 2, service.getActionsById(1).getStageDays().size());
	}
	
	@Test
	public void getallDiagnosesforProtocal() throws ParseException {
		//System.out.println(service.getProtocalById(1).getDiagnoses().size());
		Assert.assertEquals("", 2, service.getProtocalById(1).getDiagnoses().size());
	}
	
	@Test
	public void getProtocalForAdiagnosis() throws ParseException {
		System.out.println(service.getDiagnosisById(1).getProtocol2().getProtocalName());
		//Assert.assertEquals("", 2, service.getProtocalById(1).getDiagnoses().size());
	}
	
}
