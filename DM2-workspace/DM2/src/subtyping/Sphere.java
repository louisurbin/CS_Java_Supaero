package subtyping;

public class Sphere extends AbstractShape{
    private double radius;

    public Sphere(Position3D center, double radius){
        super(center);
        this.radius = radius;
    }

    public double volume(){
        return 4.0/3.0 * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public String toString(){
        return "Sphere radius=" + radius + ", center at " + center;
    }
}
