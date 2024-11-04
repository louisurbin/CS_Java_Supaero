package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ThirdLineReader {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("./src/example.txt"));
        String str = in.readLine(); // stores first line in str
        int i = 1;
        while(i<3) {
            str = in.readLine(); // stores next line in str
            i++;
        }
        in.close(); 
        System.out.println(str);
    }
}
