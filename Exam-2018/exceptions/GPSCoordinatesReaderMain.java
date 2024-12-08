package exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GPSCoordinatesReaderMain {

	public static void main(String[] args) {
		try (FileReader in = new FileReader("exceptions/summits.txt");
				BufferedReader reader = new BufferedReader(in);) {
			String line = reader.readLine();
			while (line != null) {
				String[] words = line.split(",");
				double lat = Double.parseDouble(words[0]);
				double lon = Double.parseDouble(words[1]);
				double alt = Double.parseDouble(words[2]);
				GPSCoordinates coords = new GPSCoordinates(lat, lon, alt);
				System.out.println(coords);
				line = reader.readLine();
			}
		} catch (IOException e) {
			System.err.println("Error while reading file: " + e.getMessage());
		}
	}
}
