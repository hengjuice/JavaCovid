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
	public void testA1() {
		Country test1 = new Country("China", LocalDate.parse("2022-04-12"), "A1", "COVID_Dataset_v1.0.csv");
		assertEquals(test1.name,"China");
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
	@Test
	public void testB1() {
		Country test1 = new Country("China", LocalDate.parse("2020-04-12"), LocalDate.parse("2020-05-12"), "B1", "COVID_Dataset_v1.0.csv");
		assertEquals(test1.name,"China");
	}
	@Test
	public void testB2() {
		Country test1 = new Country("China", LocalDate.parse("2020-04-12"), LocalDate.parse("2020-05-12"), "B2", "COVID_Dataset_v1.0.csv");
		assertEquals(test1.name,"China");
	}
	@Test
	public void testB3() {
		Country test1 = new Country("Chile", LocalDate.parse("2020-04-12"), LocalDate.parse("2020-05-12"), "B3", "COVID_Dataset_v1.0.csv");
		assertEquals(test1.name,"Chile");
	}
	@Test
	public void getconf() {
		Country test1 = new Country("Africa", LocalDate.parse("2020-04-12"), LocalDate.parse("2021-12-12"), "B3", "COVID_Dataset_v1.0.csv");
		test1.getConfirmedCases("COVID_Dataset_v1.0.csv");
		test1.getConfirmedDeaths("COVID_Dataset_v1.0.csv");
		test1.getVaccinationRate("COVID_Dataset_v1.0.csv");
		test1.getCumulativeConfirmedCases("COVID_Dataset_v1.0.csv");
		test1.getCumulativeDeaths("COVID_Dataset_v1.0.csv");
		test1.getCumulativeVaccination("COVID_Dataset_v1.0.csv");
		assertEquals(test1.name,"Africa");
	}
	public void getconf2() {
		Country test1 = new Country("Africa", LocalDate.parse("2021-06-12"), LocalDate.parse("2021-12-12"), "B3", "COVID_Dataset_v1.0.csv");
		test1.getConfirmedCases("COVID_Dataset_v1.0.csv");
		test1.getConfirmedDeaths("COVID_Dataset_v1.0.csv");
		test1.getVaccinationRate("COVID_Dataset_v1.0.csv");
		test1.getCumulativeConfirmedCases("COVID_Dataset_v1.0.csv");
		test1.getCumulativeDeaths("COVID_Dataset_v1.0.csv");
		test1.getCumulativeVaccination("COVID_Dataset_v1.0.csv");
		assertEquals(test1.name,"Africa");
	}
	public void datef() {
		Country test1 = new Country("Chile", LocalDate.parse("2020-04-12"), LocalDate.parse("2021-12-12"), "B3", "COVID_Dataset_v1.0.csv");
		assertEquals(test1.dateFormatter("2020"),LocalDate.parse("2020"));
	}
}
