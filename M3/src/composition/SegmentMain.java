package composition;

public class SegmentMain {
    public static void main(String[] args) {
        Position beg = new Position(1, 2);
        Position end = new Position(3, 4);
        
        Segment s = new Segment(beg, end);
        s.moveTo(11, 12, 13, 14);

        s.display();
        beg.display();
        end.display();
    }
}
