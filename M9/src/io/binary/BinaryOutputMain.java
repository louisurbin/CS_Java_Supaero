package io.binary;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import geometry.Position;
import java.util.ArrayList;

public class BinaryOutputMain {
    public static void main(String[] args) {
        String[] strings = new String[3];
        strings[0] = "toto";
        strings[1] = "titi";
        strings[2] = "tata";

        ArrayList<Position> positions = new ArrayList<>();
        positions.add(new Position(0,0));
        positions.add(new Position(1,0));
        positions.add(new Position(0,1));

        try(
            FileOutputStream file = new FileOutputStream("src/data/data.bin");
            ObjectOutputStream out = new ObjectOutputStream(file);
            ){
            out.writeInt(42);
            out.writeDouble(Math.PI);
            out.writeObject("toto");
            out.writeObject(strings);
            out.writeObject(new Position(0,0));
            out.writeObject(positions);
        }
        catch(IOException e){
            System.err.println("Error while writing file: " + e.getMessage());
        }
    }
}
