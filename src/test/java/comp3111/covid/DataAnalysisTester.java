package comp3111.covid;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataAnalysisTester {

	@Before
	public void setUp() throws Exception {
		
	}


	@Test
	public void in() {
		assertEquals(DataAnalysis.allCountriesArray("COVID_Dataset_v1.0.csv").contains("China"),true);
	}
	public void notin() {
		assertEquals(DataAnalysis.allCountriesArray("COVID_Dataset_v1.0.csv").contains("Covidland"),false);
	}
}
