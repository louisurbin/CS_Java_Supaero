public class Segment {
    
    private Position beg;
    private Position end;

    //Constructor
    public Segment(Position pb, Position pe){
        this.beg = new Position(pb);
        this.end = new Position(pe);
    }

    //Methods
    public void moveTo(double xb, double yb, double xe, double ye){
        this.beg.moveTo(xb, yb);
        this.end.moveTo(xe, ye);
    }

    public double length(){
        return Position.distance (beg, end);
    }

    public void display() {
        System.out.println("beg = ");
        beg.display();
        System.out.println("end = ");
        end.display();
    }
    public void translate(double dx, double dy) {
        this.beg.translate(dx, dy);
        this.end.translate(dx, dy);
    }
}
