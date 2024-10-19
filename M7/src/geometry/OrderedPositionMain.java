package geometry;

public class OrderedPositionMain {
    public static void main(String[] args) {
        Comparable<Position> p1 = new Position(2, 2);
        Comparable<Position> p2 = new Position(2, 1);
        Comparable<Position> p3 = new Position(2, 3);
        System.out.println(p1.compareTo((Position) p2));
        System.out.println(p1.compareTo((Position) p3));
    }
}
