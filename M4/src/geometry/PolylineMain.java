package geometry;

public class PolylineMain {
    public static void main(String[] args) {
        Polyline line = new Polyline();
        System.out.println(line.toString());
        line.addVertex(new Position(0, 0));
        line.addVertex(new Position(4, 0));
        line.addVertex(new Position(4, 3));
        line.addVertex(new Position(0, 3));
        System.out.println(line.toString());
        line.clearVertices();
        System.out.println(line.toString());
    }
}
