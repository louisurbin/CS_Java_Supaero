package mobility.model;

public class Drunkard extends Mobile {
   
    public Drunkard(double x0, double y0, double speed) {
      super(x0, y0, speed);
      this.theta = 0;
    }    

    public void move(double timeStep) {
        this.theta = Math.PI / 12 * rand.nextGaussian();
        double dx = speed * timeStep * Math.cos(this.theta);
        double dy = speed * timeStep * Math.sin(this.theta);
        x += dx;
        y += dy;
    }

    public String toString() {
        return "D (" + x + ", " + y + ")";
    }
}
