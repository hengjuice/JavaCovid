package comp3111.covid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

// Displaying table of information regarding COVID-19 Deaths

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
