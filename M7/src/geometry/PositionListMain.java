package geometry;

import java.util.ArrayList;
import java.util.Collections;

public class PositionListMain {
    public static void main(String[] args) {
        ArrayList<Position> positions = new ArrayList<>();
        positions.add(new Position(1, 2));
        positions.add(new Position(2, 1));
        positions.add(new Position(1, 3));
        positions.add(new Position(1, 1));
        Collections.sort(positions);
        System.out.println(positions);
    }
}
