package exceptions;

public class GPSCoordinates {
	
	private double lat; // in degrees
	private double lon; // in degrees
	private double alt; // in meters

	public GPSCoordinates(double lat, double lon, double alt) {
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
	}
	
	@Override
	public String toString() {
		return String.format("%11.6f deg %11.6f deg %4.0f m", lat, lon, alt);
	}
}
