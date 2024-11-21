package io.binary;

import geometry.Position;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class BinaryInputMain {
    public static void main(String[] args) {
        try(
            FileInputStream file = new FileInputStream("src/data/data.bin");
            ObjectInputStream in = new ObjectInputStream(file);
            ){
                int i = in.readInt();
                double pi = in.readDouble();
                String s = (String) in.readObject();
                String[] strings = (String[]) in.readObject();
                Position p = (Position) in.readObject();
                ArrayList<Position> positions = (ArrayList<Position>) in.readObject();
                
                System.out.println(i);
                System.out.println(pi);
                System.out.println(s);
                for(String str : strings){
                    System.out.println(str);
                }
                System.out.println(p);
                for(Position pos : positions){
                    System.out.println(pos);
                }
            } catch(IOException | ClassNotFoundException e){
                System.err.println("Error while reading file: " + e.getMessage());
            }

    }    
}
