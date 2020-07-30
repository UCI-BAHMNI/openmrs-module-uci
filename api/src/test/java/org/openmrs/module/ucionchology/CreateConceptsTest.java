package org.openmrs.module.ucionchology;

import org.junit.Test;
import org.openmrs.Concept;
import org.openmrs.ConceptMap;
import org.openmrs.api.ConceptService;
import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.CreateDiagnosisConcepts;
import org.openmrs.test.BaseModuleContextSensitiveTest;

import junit.framework.Assert;

public class CreateConceptsTest extends BaseModuleContextSensitiveTest {
	
	//@Test
	public void testCode() {
		
		for (int i = 0; i < 100; i++) {
			StringBuffer code2 = new StringBuffer("C0");
			String var2 = Integer.toString(i);
			if (var2.length() <= 1) {
				code2.replace(2, 2, var2);
			} else {
				code2.replace(1, 2, var2);
			}
			
			System.out.println(code2.toString());
			for (int x = 0; x < 10; x += 1) {
				String var = i + "." + x;
				
				StringBuffer code = new StringBuffer("C00");
				
				if (var.length() <= 3) {
					code.replace(2, 4, var);
				} else {
					code.replace(1, 4, var);
				}
				System.out.println(code.toString());
				
			}
		}
	}
	
	@Test
	public void testcreateConcept() throws Exception {
		initializeInMemoryDatabase();
		executeDataSet("TestDataset.xml");
		authenticate();
		
		String name = UCIOnchologyConstants.DIAGNOSIS_CONCEPT_SET_NAME;
		CreateDiagnosisConcepts.CreateWorkingDiagnosisConceptSet();
		
		ConceptService service = Context.getConceptService();
		Concept c = service.getConceptByName(name);
		System.out.println(c.getDisplayString());
		System.out.println(c.getSetMembers().size());
		
		Assert.assertEquals(15, c.getSetMembers().size());
		Assert.assertEquals("Working Cancer Diagnosis (set)", c.getDisplayString());
		for (Concept x : c.getSetMembers()) {
			System.out.println(x.getDisplayString());
			for (ConceptMap map : x.getConceptMappings()) {
				System.out.println(map.getConceptReferenceTerm().getCode());
				System.out.println(map.getConceptReferenceTerm().getConceptSource().getName());
				System.out.println(".................");
			}
		}
		
	}
	
}
