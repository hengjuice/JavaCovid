package comp3111.covid;

import java.time.LocalDate;
import java.util.ArrayList;

/** Check and validates input for dates, and accordingly returns errors if appropriate
 */
public class InputChecker {
	
	// Error object
	ArrayList<String> error_statements = new ArrayList<String>();
	ArrayList<String> countries_selected = new ArrayList<String>();
	LocalDate startDate;
	LocalDate endDate;
	
	/** Constructor for chart tasks
	 * @param startDate start date
	 * @param endDate end date
	 */
	// Constructor
	public InputChecker(LocalDate startDate, LocalDate endDate)
	{
		this.startDate = startDate;
		this.endDate = endDate;
	}
	/** Constructor for table tasks
	 * @param startDate selected date
	 */
	public InputChecker(LocalDate startDate)
	{
		this.startDate = startDate;
	}
	
	
	
	boolean isDateValid(LocalDate startDate, LocalDate endDate) {
	    	/*
	    	LocalDate.compareTo(LocalDate)
	    	It returns 0 if both the dates are equal.
			It returns positive value if this date is greater than the otherDate.
		    It returns negative value if this date is less than the otherDate.
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
	
	void tableInputValidityCheck() {
		boolean condition_1 = false;
		boolean condition_4 = false; // if no countries are selected
		if (startDate == null) 
		{
			error_statements.add("Start Date not provided");
		}
		if (countries_selected == null) {
			error_statements.add("No Countries are Selected");
		}
		else
		{
			condition_4 = true;
		}
	}

	// CHECKS - Triggered by Generate Chart
	
	// Checking Date inputs
	void chartInputValidityCheck() {
		
		boolean condition_1 = false; // startDate exists
		boolean condition_2 = false; // endDate exists
		boolean condition_3 = false; // startDate after or equal endDate
		boolean condition_4 = false; // if no countries are selected
		
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
		
		if (countries_selected == null) {
			error_statements.add("No Countries are Selected");
		}
		else
		{
			condition_4 = true;
		}
		
	}
	
	void printErrorStatements()
	{
		for (String s: error_statements)
		{
			System.out.println(s);
		}
	}
	
	ArrayList<String> getErrorStatements()
	{
		return error_statements;
	}
	
	boolean isMonthValid(String month) {
    	if (month == "Jan"){return true;}
    	if (month == "Feb"){return true;}
    	if (month == "Mar"){return true;}
    	if (month == "Apr"){return true;}
    	if (month == "May"){return true;}
    	if (month == "Jun"){return true;}
    	if (month == "Jul"){return true;}
    	if (month == "Aug"){return true;}
    	if (month == "Sep"){return true;}
    	if (month == "Oct"){return true;}
    	if (month == "Nov"){return true;}
    	if (month == "Dec"){return true;}
    	if (month == "jan"){return true;}
    	if (month == "feb"){return true;}
    	if (month == "mar"){return true;}
    	if (month == "apr"){return true;}
    	if (month == "may"){return true;}
    	if (month == "jun"){return true;}
    	if (month == "jul"){return true;}
    	if (month == "aug"){return true;}
    	if (month == "sep"){return true;}
    	if (month == "oct"){return true;}
    	if (month == "nov"){return true;}
    	if (month == "dec"){return true;}
    	return false;
	}
	
	// Checking data availability
	void dataValidityCheck() {
		
	}
}
