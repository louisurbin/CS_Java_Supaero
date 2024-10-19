package geometry;

import java.util.TreeSet;

public class PositionSetMain {
    public static void main(String[] args) {
        TreeSet<Position> positions = new TreeSet<>();
        positions.add(new Position(1, 2));
        positions.add(new Position(2, 1));
        positions.add(new Position(1, 3));
        positions.add(new Position(1, 1));
        System.out.println(positions);

    }
}
