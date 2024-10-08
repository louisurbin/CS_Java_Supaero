package exceptions;

import java.io.BufferedReader;
import java.io.FileReader;

public class GPSCoordinatesReaderMain {
	
	public static void main(String[] args) {
		FileReader fileReader = new FileReader("src/exceptions/summits.txt");
		BufferedReader reader = new BufferedReader(null);
		
		String ligne = reader.readLine();
		while(line != null) {
			String[] words = line.split(",");
			double lat = Double.parseDouble(words[1]);
			double lon = Double.parseDouble(words[2]);
			double alt = Double.parseDouble(words[3]);
			GPSCoordinates coords = new GPSCoordinates(lat, lat, lat);
			System.out.println(coords);
			line = reader.readLine();
		}
		
		
	}

}
