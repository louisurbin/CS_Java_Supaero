package io;

import geometry.Position;
import io.text.PositionReader;
import io.text.PositionWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class BarycenterMain {
    public static void main(String[] args) throws IOException {
        Collection<Position> positions = new ArrayList<>();
        positions = PositionReader.read("position_test.txt");
        PositionWriter.write(Position.barycenter(positions), "barycenter.txt",false);
    }
}
