package org.openmrs.module.ucionchology;

import org.junit.Test;
import org.openmrs.api.ConceptService;
import org.openmrs.test.BaseModuleContextSensitiveTest;
import org.openmrs.test.SkipBaseSetup;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.assertThat;

//@SkipBaseSetup 
public class OnchologyActivatorTest {
	
	private UCIOnchologyActivator activator;

    @Autowired
   private ConceptService conceptService;
    

    @Test
   public void testEvery() throws Exception {
    	 
         //initializeInMemoryDatabase();
        //executeDataSet("TestDataset.xml");
        //authenticate();
       
       
//         UCIOnchologyActivator activator = new UCIOnchologyActivator();
//         activator.willRefreshContext();
//         activator.contextRefreshed();
//         activator.willStart();
//         activator.started();
//         
//      
//        //verifySentinelData();
//        System.out.print(conceptService.getAllConcepts().size());
//     
    }
        
    
    
    private void verifySentinelData() {
       // assertThat(conceptService.getAllConcepts().size(), is(706));
    }
    
}
