package geometry;

import java.util.ArrayList;

public class ManipulableMain {
    public static void main(String[] args) {
        ArrayList<Manipulable> manipulables = new ArrayList<>();
        Position p1 = new Position(1, 2);
        Position p2 = new Position(3, 4);
        Circle c1 = new Circle(5, p1);
        Circle c2 = new Circle(6, p2);
        manipulables.add(p1);
        manipulables.add(p2);
        manipulables.add(c1);
        manipulables.add(c2);
        for (Manipulable m : manipulables) {
            m.translate(100, 100);
        }
        System.out.println(manipulables);
    }
}
