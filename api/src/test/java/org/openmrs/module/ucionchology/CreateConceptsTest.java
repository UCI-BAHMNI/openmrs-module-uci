package org.openmrs.module.ucionchology;

import org.junit.Test;
import org.openmrs.Concept;
import org.openmrs.ConceptMap;
import org.openmrs.module.ucionchology.api.CreateDiagnosisConcepts;
import org.openmrs.test.BaseModuleContextSensitiveTest;

import junit.framework.Assert;

public class CreateConceptsTest extends BaseModuleContextSensitiveTest {
	
	@Test
	public void testCode() {
		
		for (int i = 0; i < 100; i++) {
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
		
		Concept c = CreateDiagnosisConcepts.CreateWorkingDiagnosisConceptSet();
		
		System.out.println(c.getDisplayString());
		System.out.println(c.getSetMembers().size());
		
		Assert.assertEquals(14, c.getSetMembers().size());
		Assert.assertEquals("Working Cancer Diagnosis (set)", c.getDisplayString());
		for (Concept x : c.getSetMembers()) {
			System.out.println(x.getDisplayString());
			for (ConceptMap map : x.getConceptMappings()) {
				System.out.println(map.getConceptReferenceTerm().getCode());
				System.out.println(map.getConceptReferenceTerm().getConceptSource().getName());
				System.out.println(".................>>>>>>");
			}
		}
		
	}
}
