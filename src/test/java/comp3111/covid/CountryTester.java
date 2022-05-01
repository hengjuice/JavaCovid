package comp3111.covid;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CountryTester {

	@Before
	public void setUp() throws Exception {
		
	}


	@Test
	public void testA2() {
		Country test1 = new Country("China", LocalDate.parse("2020-04-12"), "A2", "COVID_Dataset_v1.0.csv");
		assertEquals(test1.name,"China");
	}
	@Test
	public void testA3() {
		Country test1 = new Country("Chile", LocalDate.parse("2020-04-12"), "A3", "COVID_Dataset_v1.0.csv");
		assertEquals(test1.name,"Chile");
	}
}
