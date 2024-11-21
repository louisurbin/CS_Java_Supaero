package io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ExcellenceWriterMain {
    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter("./src/isae.txt")) {
            out.println("Excellence with Passion");
        }
        catch (FileNotFoundException e) {
            System.err.println("Cannot write to file: " + e.getMessage());
        }
    }
}
