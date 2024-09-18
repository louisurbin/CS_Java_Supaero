package geometry;

import java.util.ArrayList;

public class PositionListMain {
    public static void main(String[] args) {
        ArrayList<Position> listOfPos = new ArrayList<>();
        listOfPos.add(new Position(1, 2));
        listOfPos.addFirst(new Position(3, 4));
        listOfPos.add(1,new Position(5, 6));
        
        for (Position p : listOfPos) {
            System.out.println(p);
        }

        System.out.println(listOfPos);
    }
}
