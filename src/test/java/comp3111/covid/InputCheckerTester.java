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
	public void noenddate() {
		InputChecker tester1 = new InputChecker(LocalDate.parse("2020-09-12"));
		tester1.chartInputValidityCheck();
		assertEquals(tester1.error_statements.isEmpty(),false);
	}
	@Test
	public void tableinput() {
		InputChecker tester1 = new InputChecker(LocalDate.parse("2020-09-12"));
		tester1.tableInputValidityCheck();
		assertEquals(tester1.error_statements.isEmpty(),true);
	}
	@Test
	public void nocountry() {
		InputChecker tester1 = new InputChecker(LocalDate.parse("2020-09-12"));
		tester1.countries_selected = null;
		tester1.tableInputValidityCheck();
		assertEquals(tester1.error_statements.isEmpty(),false);
	}
}
