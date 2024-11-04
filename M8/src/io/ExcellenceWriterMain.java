package io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ExcellenceWriterMain {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter out = new PrintWriter("./src/isae.txt");
        out.println("Excellence with Passion");
        out.close();
    }
}
