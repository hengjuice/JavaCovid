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
		TableEntry tester1=new TableEntry("Hello",1,2);
		assertEquals(tester1.getName(),"Hello");
	}
}
