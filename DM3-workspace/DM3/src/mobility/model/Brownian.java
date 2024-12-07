package mobility.model;

public class Brownian extends Mobile {

    public Brownian(double x0, double y0, double speed) {
        super(x0, y0, speed);
    }

    public void move(double timeStep) {
        this.theta = 2 * Math.PI * rand.nextDouble();
        double dx = speed * timeStep * Math.cos(this.theta);
        double dy = speed * timeStep * Math.sin(this.theta);
        x += dx;
        y += dy;
    }

    public String toString() {
        return "B (" + x + ", " + y + ")";
    }  
}
