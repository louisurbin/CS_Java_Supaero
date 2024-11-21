package subtyping;

public class Position3D {

    private double x;
    private double y;
    private double z;

    public Position3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Position3D() {
        this(0, 0, 0);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
    
}
