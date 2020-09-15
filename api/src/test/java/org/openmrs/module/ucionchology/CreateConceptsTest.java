package org.openmrs.module.ucionchology;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openmrs.Concept;
import org.openmrs.ConceptMap;
import org.openmrs.api.ConceptService;
import org.openmrs.api.context.Context;
import org.openmrs.module.ucionchology.api.CreateDiagnosisConcepts;
import org.openmrs.test.BaseModuleContextSensitiveTest;

import org.junit.Assert;
import org.junit.Before;

public class CreateConceptsTest extends BaseModuleContextSensitiveTest {
	
	ConceptService conceptService;
	
	@Before
	public void init() throws Exception {
		initializeInMemoryDatabase();
		executeDataSet("TestDataset.xml");
		authenticate();
		conceptService = Context.getConceptService();
	}
	
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
			
			//System.out.println(code2.toString());
			for (int x = 0; x < 10; x += 1) {
				String var = i + "." + x;
				
				StringBuffer code = new StringBuffer("C00");
				
				if (var.length() <= 3) {
					code.replace(2, 4, var);
				} else {
					code.replace(1, 4, var);
				}
				//System.out.println(code.toString());
				
			}
		}
	}
	
	@Test
	public void testcreateConcept() throws Exception {
		
		String name = UCIOnchologyConstants.DIAGNOSIS_CONCEPT_SET_NAME;
		CreateDiagnosisConcepts.CreateWorkingDiagnosisConceptSet();
		
		Concept c = conceptService.getConceptByName(name);
		System.out.println(c.getDisplayString());
		System.out.println(c.getSetMembers().size());
		
		Assert.assertEquals(11, c.getSetMembers().size());
		Assert.assertEquals("Working Cancer Diagnosis (set)", c.getDisplayString());
		for (Concept x : c.getSetMembers()) {
			System.out.println(x.getDisplayString() + ">>>>>>>>>>>>>>>");
			for (ConceptMap map : x.getConceptMappings()) {
				//System.out.println(map.getConceptReferenceTerm().getCode());
				//System.out.println(map.getConceptReferenceTerm().getConceptSource().getName());
				//System.out.println(".................");
			}
		}
		
	}
	
	@Test
	public void testGetCoceptCodes() throws Exception {
		
		CreateDiagnosisConcepts.CreateWorkingDiagnosisConceptSet();
		List<Concept> concepts = conceptService.getConceptByName(UCIOnchologyConstants.DIAGNOSIS_CONCEPT_SET_NAME)
		        .getSetMembers();
		
		List<String> names = new ArrayList<String>();
		for (Concept c : concepts) {
			for (ConceptMap map : c.getConceptMappings()) {
				if (map.getConceptReferenceTerm().getConceptSource() == conceptService
				        .getConceptSourceByName("ICD-10-WHO-1")) {
					String code = map.getConceptReferenceTerm().getCode();
					names.add(code + " - " + c.getName().getName());
				}
			}
			
		}
		//System.out.println(names.toString());
		Assert.assertEquals(4, names.size());
	}
	
}
