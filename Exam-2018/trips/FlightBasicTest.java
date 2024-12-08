package trips;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FlightBasicTest {

	private Airport tls;
	private Airport cdg;

	@Before
	public void setUp() throws Exception {
		tls = new Airport("Toulouse Blagnac", "TLS");
		cdg = new Airport("Roissy Charles de Gaulle", "CDG");
	}

	@Test
	public void testConstructor() {
		new Flight("AF1234", tls, cdg);
	}
	
	@Test
	public void testGetters() {
		Flight flight = new Flight("AF1234", tls, cdg);
		assertEquals("AF1234", flight.getFlightNumber());
		assertEquals(tls, flight.getDepartureAirport());
		assertEquals(cdg, flight.getArrivalAirport());
	}
	
	@Test
	public void testToString() {
		Flight flight = new Flight("AF1234", tls, cdg);
		String repr = flight.toString();
		assertTrue(repr.contains("AF1234"));
		assertTrue(repr.contains("TLS"));
		assertTrue(repr.contains("CDG"));
		assertTrue(repr.matches(".*TLS.*CDG.*")); // airport departure before arrival
	}

	
}
