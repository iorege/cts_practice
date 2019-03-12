package ro.ase.cts.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ro.ase.cts.Fiddler;
import ro.ase.cts.exceptions.InstrumentException;
import ro.ase.cts.exceptions.InvalidNameException;
import ro.ase.cts.exceptions.MinimumBribeException;
import ro.ase.cts.exceptions.MinimumConcertFeeException;

public class FiddlerTest {
	private Fiddler testFiddler;
	
	public static final int MIN_CONCERT_PAY = 200;
	public static final int MIN_BRIBE_PAY = 10;
	
	@Before
	public void setUp() {
		testFiddler = new Fiddler();
	}
	
	@After
	public void tearDown() {
		
	}
	
	@Test(expected = InstrumentException.class)
	public void testInstrumentInitialization() {
		try {
			testFiddler.sing();
		} catch (InstrumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(expected = MinimumBribeException.class)
	public void testBribeLeftBoundry(){
		try {
			testFiddler.bribe(MIN_BRIBE_PAY - 1);
		} catch (MinimumBribeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(expected = MinimumConcertFeeException.class)
	public void testConcertFeeLeftBoundry(){
		try {
			testFiddler.concert(MIN_CONCERT_PAY - 1);
		} catch (MinimumConcertFeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void checkComputationSalary(){
		testFiddler.setChargeableSalary(1000);
		testFiddler.setUnchartedSalary(3000);
		System.out.println(testFiddler.computeTotalSalary());
		assertEquals(testFiddler.computeTotalSalary(), 3810, 0.0001);
	}
	
	@Test(expected = InvalidNameException.class)
	public void checkNullName() {
		try {
			testFiddler.setName("");
		} catch (javax.naming.InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void stringContainsSuper(){
		try {
		testFiddler.setName("Tracy Super");
		fail("Name contains <Super>!");
		} catch (javax.naming.InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
