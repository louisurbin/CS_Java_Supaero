package trips;

import static org.junit.Assert.*;

import org.junit.Test;

public class AirportBasicTest {

	@Test
	public void testConstructor() {
		new Airport("Toulouse Blagnac", "TLS");
	}

	@Test
	public void testGetters() {
		Airport tls = new Airport("Toulouse Blagnac", "TLS");
		assertEquals("TLS", tls.getIata());
		assertEquals("Toulouse Blagnac", tls.getName());
		// if something goes wrong check your parameters order in the constructor 
		// is the order of the UML diagram
	}

	@Test
	public void testToString() {
		Airport tls = new Airport("Toulouse Blagnac", "TLS");
		String repr = tls.toString();
		assertTrue(repr.contains("Toulouse Blagnac"));
		assertTrue(repr.contains("TLS"));
		//assertTrue(repr.matches("\\s*Toulouse Blagnac\\s+\\(\\s*TLS\\s*\\)\\s*"));
	}

}
