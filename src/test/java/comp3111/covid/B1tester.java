package comp3111.covid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//import org.junit.Test;

public class B1tester {

	Date input_date;
	String[] countries;
	
	@Before
	public void setUp() throws Exception {
		String date_string = "26-09-1989";
	    //Instantiating the SimpleDateFormat class
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");      
	    //Parsing the given String to Date object
	    input_date = formatter.parse(date_string);
	    
	    
	    countries = new String[] {"germany","china","russia","japan","hong kong"};
	}
	
	@Test
	public void isTableLoadedTrue() {
		assertTrue(B1_DeathsTable.isTableLoaded(1));
	}
	
	@Test
	public void isDateValidTrue() {
		assertTrue(B1_DeathsTable.isDateValid(input_date));
	}
	
	@Test
	public void isCountryValidTrue() {
		assertTrue(B1_DeathsTable.isCountryValid("china", countries));
	}

}
