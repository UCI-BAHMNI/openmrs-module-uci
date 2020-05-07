package org.openmrs.module.ucionchology;

import org.junit.Assert;
import org.junit.Test;
import org.openmrs.api.ConceptService;
import org.openmrs.test.BaseModuleContextSensitiveTest;
import org.openmrs.test.SkipBaseSetup;
import org.springframework.beans.factory.annotation.Autowired;

@SkipBaseSetup
public class OnchologyActivatorTest extends BaseModuleContextSensitiveTest {
	
	private UCIOnchologyActivator activator;
	
	@Autowired
	private ConceptService conceptService;
	
	@Test
	public void testEvery() throws Exception {
		
		/*initializeInMemoryDatabase();
		executeDataSet("TestDataset.xml");
		authenticate();
		// this test class is to asset the actual number of cocepts added to the meta data package
		// to run this test , comment out the Htmlformentry iinitilaizer in the Activator class 
		
		activator = new UCIOnchologyActivator();
		activator.willRefreshContext();
		activator.contextRefreshed();
		activator.willStart();
		activator.started();
		
		System.out.println(conceptService.getAllConcepts().size());
		Assert.assertEquals(conceptService.getAllConcepts().size(), 13); */
	}
	
}
