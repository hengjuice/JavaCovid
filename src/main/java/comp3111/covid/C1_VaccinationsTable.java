package comp3111.covid;

import java.util.ArrayList;
 
import java.util.Arrays; 
import java.util.Date; 
import java.util.List; 
import java.text.ParseException; 
import java.text.SimpleDateFormat;



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

