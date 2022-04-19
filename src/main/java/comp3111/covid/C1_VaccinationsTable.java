package comp3111.covid;

import java.util.ArrayList;
 
import java.util.Arrays; 
import java.util.Date; 
import java.util.List; 
import java.text.ParseException; 
import java.text.SimpleDateFormat;

/*
Task C1: Generate data tables showing the rate of vaccination against COVID-19 by country

Input
•	Specify the date of interest
•	Specify the countries of interest

Output
•	Label the data table with a proper title: "Rate of Vaccination against COVID-19 as of [Date of Interest]"
•	Present data in 3 columns with proper headings of "Country", "Fully Vaccinated", and "Rate of Vaccination"
•	Present data for the countries of interest in rows

*/


public class C1_VaccinationsTable {

	

	
	/*
	public static float givePercentage(int number_of_vaccinations, int population) {
		if (population != 0) {
			float percentage = number_of_vaccinations/population;
			return percentage;
		}
		else
			return 0;
	}
	
	public static float giveDeathsPerMillion(int number_of_deaths, int population) {
		if (population != 0) {
			float deaths_per_million = number_of_deaths/population *1000000;
			return deaths_per_million;
		}
		else
			return 0;
	}
	
	public static boolean isPopulationNotZero(int population) {
		if (population != 0)
			return true;
		else
			return false;
	}
	
	*/
	
	public static boolean isCountryValid(String input_country, String[] countries) { 
		  List<String> nameList = new ArrayList<>(Arrays.asList(countries)); 
		  return nameList.contains(input_country); 
		 }
	
}

