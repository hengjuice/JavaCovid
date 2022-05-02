package comp3111.covid;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;


import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TableEntryTester {

	@Before
	public void setUp() throws Exception {
		
	}


	@Test
	public void test() {
		TableEntry tester1=new TableEntry("Hello",1.1F,2.2F);
		assertEquals(tester1.getName(),"Hello");
		TableEntry tester2=new TableEntry("Hello",LocalDate.parse("2020-04-12"),2.2F);
		assertEquals(tester2.getName(),"Hello");
	}
}
