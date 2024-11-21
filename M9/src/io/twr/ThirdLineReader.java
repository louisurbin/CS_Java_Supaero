package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ThirdLineReader {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader("./src/example.txt"))){
            String str = in.readLine(); // stores first line in str
            int i = 1;
            while(i<3) {
                str = in.readLine(); // stores next line in str
                i++;
            }
            System.out.println(str);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println("IOException");
        }
    }
}
