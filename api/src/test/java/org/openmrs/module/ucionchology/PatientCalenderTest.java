package org.openmrs.module.ucionchology;

import java.text.ParseException;

import org.json.JSONArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.module.ucionchology.models.PatientProtocol;
import org.openmrs.module.ucionchology.utils.FilterProtocals;
import org.openmrs.module.ucionchology.utils.PatientCalenderData;
import org.openmrs.test.BaseModuleContextSensitiveTest;

public class PatientCalenderTest extends BaseModuleContextSensitiveTest {
	
	private UCIOnchologyService onchlogyService;
	
	@Before
	public void init() throws Exception {
		initializeInMemoryDatabase();
		executeDataSet("protocolTest.xml");
		authenticate();
		onchlogyService = Context.getService(UCIOnchologyService.class);
	}
	
	@Test
	public void testCalenderData() throws ParseException {
		
		PatientProtocol patientProtocal = onchlogyService.getPatientProtocalByPatient(8);
		
		JSONArray eventsArray = PatientCalenderData.generateCalenderData(patientProtocal);
		
		/* for (int x = 0; x < eventsArray.length(); x++) {
			System.out.println(eventsArray.getJSONObject(x));
		} */
		
		Assert.assertEquals("", 24, eventsArray.length());
	}
	
	@Test
	public void testfilterProtocals() throws ParseException {
		//System.out.println(FilterProtocals.filtererdProtocals(8).size());
		Assert.assertEquals("", 2, FilterProtocals.filtererdProtocals(8).size());
	}
	
}
