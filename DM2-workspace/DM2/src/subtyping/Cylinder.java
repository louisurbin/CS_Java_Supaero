package subtyping;

public class Cylinder extends AbstractShape{
    private double radius;
    private double height;

    public Cylinder(Position3D center, double radius, double height){
        super(center);
        this.radius = radius;
        this.height = height;
    }

    public double volume(){
        return Math.PI * Math.pow(this.radius, 2) * this.height;
    }

    @Override
    public String toString(){
        return "Cylinder radius=" + radius + ", height=" + height + ", " + super.toString();


    }
}
