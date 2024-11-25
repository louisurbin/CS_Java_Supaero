package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class AbstractBagIO<E extends Comparable<E>> {
    public abstract E fromString(String text) throws ConversionException;

    public abstract String toString(E value);

    public void updateBagFromFile(SortedBag<E> bag, String filename) {
        try(FileReader in = new FileReader(filename)) {
            BufferedReader bin = new BufferedReader(in);
            String line;
            while ((line = bin.readLine()) != null) {
                E value = fromString(line);
                bag.put(value);
            }
        }
        catch (IOException e) {
			System.err.println("Error while reading file: " + e.getMessage());
        }
    }

    public void writeBagToFile(SortedBag<E> bag, String filename){
        try (PrintWriter out = new PrintWriter(filename)) {
            for (E element : bag.getElements()) {
                out.println(toString(element));
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("Cannot write to file: " + e.getMessage());
        }
    }
}
