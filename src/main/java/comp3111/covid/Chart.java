package comp3111.covid;

import java.time.LocalDate;
import java.util.ArrayList;


public class Chart {
	
	public String ID = null;
	public LocalDate startDate = null;
	public LocalDate endDate = null;
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
