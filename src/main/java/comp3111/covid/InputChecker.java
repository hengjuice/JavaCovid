package comp3111.covid;

import java.time.LocalDate;
import java.util.ArrayList;

public class InputChecker {
	
	// Error object
	ArrayList<String> error_statements = new ArrayList<String>();
	LocalDate startDate;
	LocalDate endDate;
	
	
	// Constructor
	InputChecker(LocalDate startDate, LocalDate endDate)
	{
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	boolean isDateValid(LocalDate startDate, LocalDate endDate) {
	    	/*
	    	LocalDate.compareTo(LocalDate)
	    	It returns 0 if both the dates are equal.
			It returns positive value if “this date” is greater than the otherDate.
		    It returns negative value if “this date” is less than the otherDate.
	    	*/
		
	    	int i = endDate.compareTo(startDate);
	    	if (i > 0)
	    	{
	    		// Start Date before End Date (VALID)
	    		return true;
	    	}
	    	else if (i == 0)
	    	{
	    		// Start Date equal End Date (VALID)
	    		return true;
	    	}
	    	else
	    	{
	    		// Start Date after End Date (INVALID)
	    		return false;
	    	}
	 }

	// CHECKS - Triggered by Generate Chart
	
	// Checking Date inputs
	void inputValidityCheck() {
		
		boolean condition_1 = false; // startDate exists
		boolean condition_2 = false; // endDate exists
		boolean condition_3 = false; // startDate after or equal endDate
		
		//Check if start date is provided
		if (startDate == null) 
		{
			error_statements.add("Start Date not provided");
		}
		else
		{
			condition_1 = true;
		}
		//Check if end date is provided
		if (endDate == null)
		{
			error_statements.add("End Date not provided");
		}
		else
		{
			condition_2 = true;
		}
		
		//Check if start date and end date is provided 
		//(will only reach this branch if condition 1 and condition 2 are both true)
		if (condition_1 && condition_2)
			if (!isDateValid(startDate, endDate))
			{
				condition_3 = false;
				error_statements.add("End Date cannot be before Start Date");
			}
		
	}
	
	void printErrorStatements()
	{
		for (String s: error_statements)
		{
			System.out.println(s);
		}
	}
	
	// Checking data availability
	void dataValidityCheck() {
		
	}
}
