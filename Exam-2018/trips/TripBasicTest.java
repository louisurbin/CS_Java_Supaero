package trips;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TripBasicTest {

	private Airport tls;
	private Airport cdg;
	private Airport rkv;
	private Flight f1;
	private Flight f2;

	@Before
	public void setUp() throws Exception {
		tls = new Airport("Toulouse Blagnac", "TLS");
		cdg = new Airport("Roissy Charles de Gaulle", "CDG");
		rkv = new Airport("Reykjavik", "RKV");
		f1 = new Flight("AF1234", tls, cdg);
		f2 = new Flight("BB1234", cdg, rkv);
	}

	@Test
	public void testConstructor() {
		new Trip();
	}
	
	@Test
	public void testAdd() {
		Trip trip = new Trip();
		trip.addFlight(f1);
		trip.addFlight(f2);
	}
	
	@Test
	public void testToString() {
		Trip trip = new Trip();
		String repr = trip.toString();
		assertTrue(repr.toLowerCase().contains("no flight yet"));

		trip.addFlight(f1);
		repr = trip.toString();
		assertTrue(repr.matches(".*TLS.*CDG.*direct.*"));
		
		trip.addFlight(f2);
		repr = trip.toString();
		assertTrue(repr.matches(".*TLS.*RKV.*2\\s*flight.*"));
	}

}
