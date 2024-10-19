package geometry;

import java.util.ArrayList;

public class DisplayableMain {
    public static void main(String[] args) {
        ArrayList<Displayable> displayables = new ArrayList<>();
        Position p1 = new Position(1, 2);
        Position p2 = new Position(3, 4);
        Circle c1 = new Circle(1, 2, 3);
        Circle c2 = new Circle(4, 5, 6);
        displayables.add(p1);
        displayables.add(p2);
        displayables.add(c1);
        displayables.add(c2);
        for (Displayable disp : displayables){
            disp.display();
        }
    }
}
