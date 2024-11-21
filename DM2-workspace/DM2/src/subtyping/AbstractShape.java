package subtyping;

public abstract class AbstractShape {
    protected Position3D center;

    protected AbstractShape(Position3D center){
        this.center = center;
    }

    public abstract double volume();

    public String toString(){
        return "Center: " + center;
    }
}
