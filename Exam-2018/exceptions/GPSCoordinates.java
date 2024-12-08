package exceptions;

public class GPSCoordinates {

	private double lat; // in degrees
	private double lon; // in degrees
	private double alt; // in meters

	public GPSCoordinates(double lat, double lon, double alt) {
		if (lat < -90 || lat > 90) {
			throw new IllegalArgumentException("latitude error");
		}
		if (lon < -180 || lon > 180) {
			throw new IllegalArgumentException("longitude error");
		}
		if (alt < -430 || alt > 8848) {
			throw new IllegalArgumentException("altitude error");
		}
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
	}

	@Override
	public String toString() {
		return String.format("%11.6f deg %11.6f deg %4.0f m", lat, lon, alt);
	}
}
