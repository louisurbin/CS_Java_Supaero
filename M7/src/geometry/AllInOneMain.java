package geometry;

import java.util.ArrayList;

public class AllInOneMain {
    public static void main(String[] args) {
        ArrayList<AllInOne> allinone = new ArrayList<>();
        Position p1 = new Position(1, 2);
        Position p2 = new Position(3, 4);
        Circle c1 = new Circle(5, p1);
        Circle c2 = new Circle(6, p2);
        allinone.add(p1);
        allinone.add(p2);
        allinone.add(c1);
        allinone.add(c2);
        for (AllInOne m : allinone) {
            m.translate(100, 100);
        }
        System.out.println(allinone);
    }
}
