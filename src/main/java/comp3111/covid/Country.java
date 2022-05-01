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
	
	
	/** Helper function to slice ArrayList from startdate to enddate (unused)
	 */
	public void sliceArrayList()
	{
		for(Pair<LocalDate,Float> datapoint: datapoints)
		{
			LocalDate date = datapoint.getKey();
			Float v = datapoint.getValue();
			if(date.isBefore(endDate) && date.isAfter(startDate))
			{
				System.out.println("Removed:" + datapoint);
				chartdatapoints.add(datapoint);
			}
		}
	}
	
	/** Formats dates into LocalDates from strings
	 * @param  stringdate  the date as a string in the form d/m/y
	 * @return  the date as a LocalDate
     */
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
	
}
