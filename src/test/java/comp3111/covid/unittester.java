package comp3111.covid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

//import UnitTestDemo.Library;

public class unittester {

int[] arrAscending, arrDescending;

String[] countries;

@Before 
public void setUp() throws Exception { 

    countries = new String[] {"germany","china","russia","japan","hong kong"}; 
}


	
	
		@Test 
		 public void isCountryValidTrue() { 
		  assertTrue(C1_VaccinationsTable.isCountryValid("china", countries)); 
		 }

		
	

		
		

}

