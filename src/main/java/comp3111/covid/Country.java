package comp3111.covid;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javafx.util.Pair;
import org.apache.commons.csv.*;
import edu.duke.*;
/** Represents a country and stores the data points for that country
 */
public class Country {
	// Attributes
	// Data Points
	/** Constructs a CSV parser
	 * @param  dataset  the csv dataset as a string
	 * @return  the CSV parser object from the dataset
	 */
	public static CSVParser getFileParser(String dataset) {
	     FileResource fr = new FileResource("dataset/" + dataset);
	     return fr.getCSVParser(true);
	}
	
	String name;
	String task;
	String dataset;
	String called_function;
	ArrayList<Pair<LocalDate, Float>> datapoints = new ArrayList<Pair<LocalDate, Float>>();
	ArrayList<Pair<LocalDate, Float>> chartdatapoints = new ArrayList<Pair<LocalDate, Float>>();
	LocalDate startDate;
	LocalDate endDate;
	Pair<Integer, Integer> tabledatapoint = new Pair<Integer, Integer>(null, null);
	Pair<LocalDate, Integer> tableDdatapoint = new Pair<LocalDate, Integer>(null, null);
	
	Country(String name, String task, String dataset)
	{
		this.name = name;
		this.task = task;
		this.dataset = dataset;
		if (task == "D") {getWorstDay(dataset); this.called_function = "getWorstDay";}
	}
	
	Country(String name, LocalDate startDate, String task, String dataset)
	{
		this.name = name;
		this.startDate = startDate;
		this.task = task;
		this.dataset = dataset;
		
		// Call associated function based on task
		if (task == "A1") {getConfirmedCases(dataset); this.called_function = "getConfirmedCases";}
		if (task == "B1") {getConfirmedDeaths(dataset); this.called_function = "getConfirmedDeaths";}
		if (task == "C1") {getVaccinationRate(dataset); this.called_function = "getVaccinationRate";}
		if (task == "D") {getWorstDay(dataset); this.called_function = "getWorstDay";}
		
	}
	
	Country(String name, LocalDate startDate, LocalDate endDate, String task, String dataset)
	{
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.task = task;
		this.dataset = dataset;
		
		// Call associated function based on task
		if (task == "A2") {getCumulativeConfirmedCases(dataset); this.called_function = "Cumulative Confirmed COVID-19 Cases (per 1M)";}
		if (task == "B2") {getCumulativeDeaths(dataset); this.called_function = "Cumulative Confirmed COVID-19 Deaths (per 1M)";}
		if (task == "C2") {getCumulativeVaccination(dataset); this.called_function = "Cumulative Rate of Vaccination against COVID-19";}
	}
	// Three Types of Data
	
	

	public LocalDate dateFormatter(String stringdate)
	{
		if(stringdate.contains("/"))
		{
			String[] parts = stringdate.split("/");
			if (parts[0].length()<2) parts[0] = '0' + parts[0];
			if (parts[1].length()<2) parts[1] = '0' + parts[1];
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
			LocalDate formattedDate = LocalDate.parse(parts[1] + '/' + parts[0] + '/' + parts[2], formatter);
			return formattedDate;
		}
		else
		{
			LocalDate formattedDate = LocalDate.parse(stringdate);
			return formattedDate;
		}
		
		
	}

	
	// A1: Number of Confirmed COVID-19 Cases as of [Date of Interest]
	public void getConfirmedCases(String dataset)
	{
		int total_cases;
		int total_cases_pm;
		System.out.println("getConfirmedCases from " + dataset);
		for(CSVRecord rec : getFileParser(dataset)) {
			if (rec.get("location").equals(this.name))
			{
				System.out.println("String Date " +rec.get("date"));
				String stringdate = rec.get("date");
				LocalDate date = dateFormatter(stringdate);
				if(date.isEqual(startDate))
				{
					//3 columns with proper headings of "Country", "Total Cases", and "Total Cases (per 1M)"
					total_cases = Integer.parseInt(rec.get("total_cases"));
					//total_cases_pm = Integer.parseInt(rec.get("total_cases_per_million"));
					total_cases_pm = (int) Double.parseDouble(rec.get("total_cases_per_million"));
					//int i = (int) Double.parseDouble(someString)
					tabledatapoint = new Pair<Integer, Integer>(total_cases, total_cases_pm);
				}
			}
		}
	}
	// B1: Number of Confirmed COVID-19 Deaths as of [Date of Interest]
	public void getConfirmedDeaths(String dataset)
	{
		int total_deaths, total_deaths_pm;
		System.out.println("getConfirmedDeaths from " + dataset);
		for(CSVRecord rec : getFileParser(dataset)) {
			if (rec.get("location").equals(this.name))
			{
				System.out.println("String Date " +rec.get("date"));
				String stringdate = rec.get("date");
				LocalDate date = dateFormatter(stringdate);
				if(date.isEqual(startDate))
				{
					//3 columns with proper headings of "Country", "Total Deaths", and "Total Deaths (per 1M)"
					total_deaths = Integer.parseInt(rec.get("total_deaths"));
					total_deaths_pm = (int) Double.parseDouble(rec.get("total_deaths_per_million"));
					tabledatapoint = new Pair<Integer, Integer>(total_deaths, total_deaths_pm);
				}
			}
		}
	}
	// C1: Rate of Vaccination against COVID-19 as of [Date of Interest]
	public void getVaccinationRate(String dataset)
	{
		int total_vaccinated;
		int rate_of_vaccination;
		int population;
		System.out.println("getVaccinationRate from " + dataset);
		for(CSVRecord rec : getFileParser(dataset)) {
			if (rec.get("location").equals(this.name))
			{
				System.out.println("String Date " +rec.get("date"));
				String stringdate = rec.get("date");
				LocalDate date = dateFormatter(stringdate);
				if(date.isEqual(startDate))
				{
					//3 columns with proper headings of "Country", "Fully Vaccinated", and "Rate of Vaccination"
					if(rec.get("people_fully_vaccinated")!="") {
						total_vaccinated = Integer.parseInt(rec.get("people_fully_vaccinated"));
						population = Integer.parseInt(rec.get("population"));
						if(population != 0) rate_of_vaccination = (int) ((float)total_vaccinated/population * 100);
						else rate_of_vaccination=0;
						tabledatapoint = new Pair<Integer, Integer>(total_vaccinated, rate_of_vaccination);
					}
					else {
						tabledatapoint = new Pair<Integer, Integer>(0, 0);
					}
				}
			}
		}			
	}
	
	
	/** Gets the cumulative confirmed cases per 1M and adds to country's datapoints
	 * @param  dataset  the csv dataset
     */
	// A2: Cumulative Confirmed COVID-19 Cases (per 1M)
	public void getCumulativeConfirmedCases(String dataset)
	{
		System.out.println("getCumulativeConfirmedCases from " + dataset);
		for(CSVRecord rec : getFileParser(dataset)) {
			if (rec.get("location").equals(this.name))
			{
				System.out.println("String Date " +rec.get("date"));
				String stringdate = rec.get("date");
				LocalDate date = dateFormatter(stringdate);
				//System.out.println("DateFormatter "+date);
				if(date.isBefore(endDate) && date.isAfter(startDate))
				{
					Float cumulative = Float.parseFloat(rec.get("total_cases_per_million"));
					
					// Adding the tuple into datapoints for that country
					Pair<LocalDate,Float> datapoint = new Pair<LocalDate,Float>(date, cumulative);
					chartdatapoints.add(datapoint);
					System.out.println("Added:"+ datapoint);
				}
			}
		}
	}
	
	/** Gets the cumulative confirmed deaths per 1M and adds to country's datapoints
	 * @param  dataset  the csv dataset
     */
	// B2: Cumulative Confirmed COVID-19 Deaths (per 1M)
	public void getCumulativeDeaths(String dataset)
	{
		System.out.println("getCumulativeDeaths from " + dataset);
		for(CSVRecord rec : getFileParser(dataset)) {
			if (rec.get("location").equals(this.name))
			{
				System.out.println("String Date " +rec.get("date"));
				String stringdate = rec.get("date");
				LocalDate date = dateFormatter(stringdate);
				//System.out.println("DateFormatter "+date);
				if(date.isBefore(endDate) && date.isAfter(startDate))
				{
					Float cumulative = Float.parseFloat(rec.get("total_deaths_per_million"));
					
					// Adding the tuple into datapoints for that country
					Pair<LocalDate,Float> datapoint = new Pair<LocalDate,Float>(date, cumulative);
					chartdatapoints.add(datapoint);
					System.out.println("Added:"+ datapoint);
				}
			}
		}
	}
	/** Gets the cumulative vaccinations per 1M and adds to country's datapoints
	 * @param  dataset  the csv dataset
     */
	// C2: Cumulative Rate of Vaccination against COVID-19
	public void getCumulativeVaccination(String dataset)
	{
		Float cumulative=(float) 0;
		Float fullyVaccinated=(float) 0;
		Float population=(float) 0;
		System.out.println("getCumulativeDeaths from " + dataset);
		for(CSVRecord rec : getFileParser(dataset)) {
			if (rec.get("location").equals(this.name))
			{
				System.out.println("String Date " +rec.get("date"));
				String stringdate = rec.get("date");
				LocalDate date = dateFormatter(stringdate);
				//System.out.println("DateFormatter "+date);
				if(date.isBefore(endDate) && date.isAfter(startDate))
				{
					String s1 = rec.get("people_fully_vaccinated");
					String s2 = rec.get("population");
					if (!s1.equals("") && !s2.equals(""))
					{
						fullyVaccinated = Float.parseFloat(s1);
					    population = Float.parseFloat(s2);
						if (population != 0) cumulative = fullyVaccinated / population * 100;
					}

					// Adding the tuple into datapoints for that country
					Pair<LocalDate,Float> datapoint = new Pair<LocalDate,Float>(date, cumulative);
					chartdatapoints.add(datapoint);
					System.out.println("Added:"+ datapoint);
				}
			}
		}
	}
	
	// D: Get worst day in history of countries selected according to new_deaths
	public void getWorstDay(String dataset)
	{
		int maxDeaths = 0;
		LocalDate worstDay = null;
		System.out.println("getWorstDay from " + dataset);
		for(CSVRecord rec : getFileParser(dataset)) {
			if (rec.get("location").equals(this.name))
			{
				System.out.println("String Date " +rec.get("date"));
				String stringdate = rec.get("date");
				LocalDate date = dateFormatter(stringdate);
				
				// get new Deaths
				String s1 = rec.get("new_deaths");
				if(!s1.equals(""))
				{
					int d = Integer.parseInt(rec.get("new_deaths"));
					if (d >= maxDeaths) {maxDeaths = d; worstDay = date;}
				}
			}
		}
		tableDdatapoint = new Pair<LocalDate, Integer>(worstDay, (Integer) maxDeaths);
		System.out.println("Added:"+tableDdatapoint);
	}
	
}
