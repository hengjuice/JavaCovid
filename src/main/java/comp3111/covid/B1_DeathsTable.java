package comp3111.covid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

// Displaying table of information regarding COVID-19 Deaths

/*
Task B1: Generate data tables showing the number of confirmed COVID-19 deaths by country

Input
•	Specify the date of interest
•	Specify the countries of interest

Output
•	Label the data table with a proper title: "Number of Confirmed COVID-19 Deaths as of [Date of Interest]"
•	Present data in 3 columns with proper headings of "Country", "Total Deaths", and "Total Deaths (per 1M)"
•	Present data for the countries of interest in rows

*/

public class B1_DeathsTable {
	
	public static boolean isTableLoaded(int num) {
		
		if (num==0) return false;
		else return true;
		
	}
	
	public static boolean isDateValid(Date given_date) {
		// Date cannot be after today
		Date current_date = new Date();
		if (given_date.after(current_date)) return false;
		return true;
	}
	
	public static boolean isCountryValid(String input_country, String[] countries) {
		List<String> nameList = new ArrayList<>(Arrays.asList(countries));
		return nameList.contains(input_country);
	}
	
}
