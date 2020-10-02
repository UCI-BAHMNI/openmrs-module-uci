package org.openmrs.module.ucionchology;

import java.text.ParseException;

import org.json.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.openmrs.Patient;
import org.openmrs.api.APIException;
import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.UCIOnchologyService;
import org.openmrs.module.ucionchology.models.PatientProtocol;
import org.openmrs.module.ucionchology.utils.PatientCalenderData;
import org.openmrs.test.BaseModuleContextSensitiveTest;
import org.junit.Assert;

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
		
		PatientProtocol patientProtocal = onchlogyService.getPatientProtocalByPatient(10);
		
		JSONArray eventsArray = PatientCalenderData.generateCalenderData(patientProtocal);
		
		/* for (int x = 0; x < eventsArray.length(); x++) {
			System.out.println(eventsArray.getJSONObject(x));
		}  */
		
		//System.out.println(eventsArray.length());
		Assert.assertEquals("", 24, eventsArray.length());
		
	}
	
}
