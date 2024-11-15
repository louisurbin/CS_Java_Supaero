package io.text;

import geometry.Position;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class PositionWriter {
    public static void write(Position p, String filename, boolean append) throws IOException {
        FileWriter writer = new FileWriter(filename, append);
        writer.write(p.getX() + "," + p.getY() + "\n");
        writer.close();
    } 

    public static void write(Collection<Position> positions, String filename, boolean append) throws IOException {
        FileWriter writer = new FileWriter(filename, append);
        for (Position p : positions) {
            writer.write(p.getX() + "," + p.getY() + "\n");
        }
        writer.close();
    }
}
