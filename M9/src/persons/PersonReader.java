package persons;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

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
	 * @return A TreeMap of persons in the text file
	 * @throws IOException when the file cannot be read or has a bad format.
	 */
	static public TreeMap<String, Person> read(String filename) throws IOException {
		FileReader in = new FileReader(filename);
		BufferedReader bin = new BufferedReader(in);

		TreeMap<String, Person> persons = new TreeMap<>();
		while(bin.ready()) {
			String line = bin.readLine();
			String[] tokens = line.split(",");
			String name = tokens[0].trim();
			int age = Integer.parseInt(tokens[1].trim());
			persons.put(name, new Person(name, age));
		}
		bin.close();
		
		return persons;
	}
}
