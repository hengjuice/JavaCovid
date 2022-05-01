package comp3111.covid;

import java.time.LocalDate;
import java.util.ArrayList;

/** Represents charts.
 */
public class Chart {
	
	/** Chart ID
	 */
	public String ID = null;
	/** Start date of the chart
	 */
	public LocalDate startDate = null;
	/** End date of the chart
	 */
	public LocalDate endDate = null;
	/** Countries selected for the chart
	 */
	public ArrayList<String> countries = null;
	
	Chart(){
		
	}
	
	Chart(String ID, LocalDate startDate, LocalDate endDate, ArrayList<String> countries) 
	{
		// Initialize variables with the user input
		this.ID = ID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.countries = countries;
	}
	
}
