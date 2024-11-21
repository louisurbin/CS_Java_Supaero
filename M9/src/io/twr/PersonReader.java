package persons;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides a static method to parse a list of persons from a CSV (comma-separated values) file.
 *
 * @author t.perennou
 *
 */
public class PersonReader {
	
	/**
	 * Reads persons from a text file. The file must be in the CSV format:
	 * <ul>
	 * <li> One person per line
	 * <li> Each line must be in the format: 
	 * <pre>
	 * name,age
	 * </pre>
	 * </ul>
	 * 
	 * Here is an example file of CSV file content:
	 * 
	 * <pre>
	 * Jean Dupont,33
	 * Pierre Martin,55
	 * </pre>
 	 * 
	 * @param filename Path of the file to read, e.g. "data/persons.txt"
	 * @return A list of persons in the text file
	 * @throws IOException when the file cannot be read or has a bad format.
	 */
	static public ArrayList<Person> read(String filename) {
		ArrayList<Person> persons = new ArrayList<Person>();
		List<String> errors = new ArrayList<String>();

		try (FileReader in = new FileReader(filename);
			BufferedReader bin = new BufferedReader(in)) {
			String line;
			int lineNumber = 0;
			
			while((line = bin.readLine()) != null) {
				lineNumber++;
				String[] tokens = line.split(",");
				if (tokens.length != 2) {
                    errors.add("Error on line " + lineNumber + ": Incorrect format, expected 'name, age'");
                    continue;
                }
				String name = tokens[0].trim();
				try{
					int age = Integer.parseInt(tokens[1].trim());
					persons.add(new Person(name, age));
				} 
				catch (NumberFormatException e) {
					errors.add("Error on line " + lineNumber + ": Age is not a valid integer");
				}
			}
		} 
		catch (IOException e) {
			System.err.println("Error while reading file: " + e.getMessage());
			return null;
		}
		
		if (!errors.isEmpty()) {
            System.err.println("Errors encountered during file reading:");
            for (String error : errors) {
                System.err.println(error);
            }
        }
		return persons;
	}
}
