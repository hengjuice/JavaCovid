package comp3111.covid;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CasesTester extends Cases {
	Cases testcase=new Cases();
	@Before
	public void setUp() throws Exception {
		testcase.addCases(45);
		testcase.addTotal(123);
		testcase.addCPM(90);		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValues() {
		assertEquals(123, testcase.getTotal());
	}
	@Test
	public void testChange() {
		testcase.addCases(44);
		assertEquals(44, testcase.getCases());
	}
	@Test
	public void testDivison() {
		testcase.calcCPM(123456);
		assertEquals(996.30637, testcase.getCPM(), 0.01);
	}

}
