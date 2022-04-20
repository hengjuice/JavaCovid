package comp3111.covid;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class InputCheckerTester {

	
	@Test
	public void startAfterEnd() {
    	LocalDate startDate = LocalDate.parse("2020-09-05");
    	
    	LocalDate endDate = LocalDate.parse("2019-09-05");

    	// CHECK INPUT VALIDITY
    	
    	// Initialize InputChecker Object - will return any errors
    	InputChecker inputChecker = new InputChecker(startDate, endDate);
    	inputChecker.chartInputValidityCheck();
		assertEquals(InputChecker.error_statements.get(0), "End Date cannot be before Start Date");
	}
	public void noEnd() {
    	LocalDate startDate = LocalDate.parse("2020-09-05");

    	// CHECK INPUT VALIDITY
    	
    	// Initialize InputChecker Object - will return any errors
    	InputChecker inputChecker = new InputChecker(startDate);
    	inputChecker.chartInputValidityCheck();
		assertEquals(InputChecker.error_statements.get(0), "End Date not provided");
	}

}
