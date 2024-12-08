package io.text;

import geometry.Position;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PositionReader {
	public static List<Position> read(String filename) {
		List<Position> positions = new ArrayList<>();
		List<String> errors = new ArrayList<>();
		try (FileReader in = new FileReader(filename);
				BufferedReader bin = new BufferedReader(in);) {
			String line;
			int lineNumber = 0;
			while ((line = bin.readLine()) != null) {
				lineNumber++;
				String[] tokens = line.split(",");
				if (tokens.length != 2) {
					errors.add("Error on line " + lineNumber + ": Incorrect format, expected 'x, y'");
					continue;
				}
				try {
					double x = Double.parseDouble(tokens[0].trim());
					double y = Double.parseDouble(tokens[1].trim());
					positions.add(new Position(x, y));
				} catch (NumberFormatException e) {
					errors.add("Error on line " + lineNumber + ": Invalid number format");
				}
			}
		} catch (IOException e) {
			System.err.println("Error while reading file: " + e.getMessage());
			return null;
		}
		if (!errors.isEmpty()) {
			System.err.println("Errors encountered during file reading:");
			for (String error : errors) {
				System.err.println(error);
			}
		}
		return positions;
	}
}
