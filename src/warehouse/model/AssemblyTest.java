package warehouse.model;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import warehouse.model.visitor.CheckDuplicateVisitor;
import warehouse.model.visitor.CostVisitor;
import warehouse.model.visitor.NumPartsVisitor;

public class AssemblyTest {

	CatalogueEntry entry1;
	CatalogueEntry entry2;
	CatalogueEntry entry3;

	Part prt1;
	Part prt2;
	Part prt3;
	Part prt4;
	Part prt5;

	Assembly asmbl1;
	Assembly asmbl2;
	Assembly asmbl3;
	Assembly asmbl4;
	Assembly asmbl5;

	@Before
	public void setUp() throws Exception {

		String nail = "10 cm galvanised nail";
		long number1 = 123456555;
		int cost1 = 12; //cents

		String bolt = "8 cm bolt";
		long number2 = 43566;
		int cost2 = 6; //cents

		String screw = "2 cm outdoor screw";
		long number3 = 1234;
		int  cost3 = 5; // cents

		entry1 = new CatalogueEntry(nail,number1,cost1);
		entry2 = new CatalogueEntry(bolt,number2,cost2);
		entry3 = new CatalogueEntry(screw,number3,cost3);

		asmbl1 = new Assembly("asmbl1");
		asmbl2 = new Assembly("asmbl2");
		asmbl3 = new Assembly("asmbl3");
		asmbl4 = new Assembly("asmbl4");
		asmbl5 = new Assembly("asmbl5");

		prt1 = new Part(entry1);
		prt2 = new Part(entry2);
		prt3 = new Part(entry3);
		prt4 = new Part(entry3);
		prt5 = new Part(entry1);

		asmbl3.addComponent(prt1);
		asmbl3.addComponent(prt2);
		asmbl3.addComponent(prt3);
		asmbl3.addComponent(prt4);
		asmbl3.addComponent(prt5);

		
		asmbl2.addComponent(prt1);
		asmbl2.addComponent(prt2);
		asmbl2.addComponent(prt3);
		asmbl2.addComponent(asmbl3);

		
		asmbl1.addComponent(prt1);
		asmbl1.addComponent(prt2);
		asmbl1.addComponent(asmbl2);

		
		asmbl4.addComponent(prt1);
		asmbl4.addComponent(prt3);
		asmbl4.addComponent(asmbl1);
		asmbl5.addComponent(asmbl4);	
	
	}

	@Test
	public void testVisitorDuplicateDetect() {
	
		CheckDuplicateVisitor visitor = new CheckDuplicateVisitor(prt3) ;
		asmbl5.accept(visitor) ;
		assertTrue(visitor.duplicateFound());
	}
	
	@Test
	public void testVisitorDuplicateDetect2() {
	
		Part prt6  = new Part(entry1); // not in the stack
		CheckDuplicateVisitor visitor = new CheckDuplicateVisitor(prt6) ;
		asmbl5.accept(visitor) ;
		assertTrue(!visitor.duplicateFound());
	}
	
	
	@Test
	public void testVisitorCost() {
		int expected = 98;
		CostVisitor visitor = new CostVisitor() ;
		asmbl5.accept(visitor) ;
		int cost = visitor.getTotal() ;
		assertEquals(expected, cost,0);
	}
	
	
	@Test
	public void testGetNumParts() {
		int expected = 12;
		NumPartsVisitor visitor = new NumPartsVisitor() ;
		asmbl5.accept(visitor) ;
		int result = visitor.getNumParts();
		assertEquals("expected: "+ expected + "; result: "+ result, expected,result,0);
	}
	
	

}
