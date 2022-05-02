package comp3111.covid;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InputCheckerTester {

	@Before
	public void setUp() throws Exception {
		
	}


	@Test
	public void normaldate() {
		InputChecker tester1 = new InputChecker(LocalDate.parse("2020-04-12"), LocalDate.parse("2020-08-16"));
		tester1.chartInputValidityCheck();
		assertEquals(tester1.error_statements.isEmpty(),true);
	}
	@Test
	public void reverseddates() {
		InputChecker tester1 = new InputChecker(LocalDate.parse("2020-09-12"), LocalDate.parse("2020-03-16"));
		tester1.chartInputValidityCheck();
		assertEquals(tester1.error_statements.isEmpty(),false);
	}
	@Test
	public void samedates() {
		InputChecker tester1 = new InputChecker(LocalDate.parse("2020-09-12"), LocalDate.parse("2020-09-12"));
		tester1.chartInputValidityCheck();
		assertEquals(tester1.error_statements.isEmpty(),true);
	}
	@Test
	public void nostart() {
		InputChecker tester1 = new InputChecker(LocalDate.parse("2020-09-12"), LocalDate.parse("2020-09-12"));
		tester1.startDate = null;
		tester1.chartInputValidityCheck();
		assertEquals(tester1.error_statements.isEmpty(),false);
	}
	@Test
	public void noenddate() {
		InputChecker tester1 = new InputChecker(LocalDate.parse("2020-09-12"));
		tester1.chartInputValidityCheck();
		assertEquals(tester1.error_statements.isEmpty(),false);
	}
	@Test
	public void tableinput() {
		InputChecker tester1 = new InputChecker(LocalDate.parse("2020-09-12"));
		tester1.tableInputValidityCheck();
		tester1.printErrorStatements();
		assertEquals(tester1.error_statements.isEmpty(),true);
	}
	@Test
	public void tableinputnodate() {
		InputChecker tester1 = new InputChecker(LocalDate.parse("2020-09-12"));
		tester1.startDate = null;
		tester1.tableInputValidityCheck();
		assertEquals(tester1.error_statements.isEmpty(),false);
	}
	@Test
	public void nocountry() {
		InputChecker tester1 = new InputChecker(LocalDate.parse("2020-09-12"));
		tester1.countries_selected = null;
		tester1.tableInputValidityCheck();
		tester1.printErrorStatements();
		assertEquals(tester1.getErrorStatements().isEmpty(),false);
	}
	@Test
	public void nocountrychart() {
		InputChecker tester1 = new InputChecker(LocalDate.parse("2020-09-12"),LocalDate.parse("2020-09-12"));
		tester1.countries_selected = null;
		tester1.chartInputValidityCheck();
		assertEquals(tester1.getErrorStatements().isEmpty(),false);
	}
	@Test
	public void months() {
		InputChecker tester1 = new InputChecker(LocalDate.parse("2020-09-12"),LocalDate.parse("2020-09-12"));
		assertTrue(tester1.isMonthValid("Jan"));
		assertTrue(tester1.isMonthValid("Feb"));
		assertTrue(tester1.isMonthValid("Mar"));
		assertTrue(tester1.isMonthValid("Apr"));
		assertTrue(tester1.isMonthValid("May"));
		assertTrue(tester1.isMonthValid("Jun"));
		assertTrue(tester1.isMonthValid("Jul"));
		assertTrue(tester1.isMonthValid("Aug"));
		assertTrue(tester1.isMonthValid("Sep"));
		assertTrue(tester1.isMonthValid("Oct"));
		assertTrue(tester1.isMonthValid("Nov"));
		assertTrue(tester1.isMonthValid("Dec"));
		assertTrue(tester1.isMonthValid("jan"));
		assertTrue(tester1.isMonthValid("feb"));
		assertTrue(tester1.isMonthValid("mar"));
		assertTrue(tester1.isMonthValid("apr"));
		assertTrue(tester1.isMonthValid("may"));
		assertTrue(tester1.isMonthValid("jun"));
		assertTrue(tester1.isMonthValid("jul"));
		assertTrue(tester1.isMonthValid("aug"));
		assertTrue(tester1.isMonthValid("sep"));
		assertTrue(tester1.isMonthValid("oct"));
		assertTrue(tester1.isMonthValid("nov"));
		assertTrue(tester1.isMonthValid("dec"));
		assertFalse(tester1.isMonthValid("Non"));

	}
}
