package mobility.model;

import java.util.Random;

public abstract class Mobile {
	protected double x;
    protected double y;
    protected double theta;
    protected double speed;
    protected static Random rand = new Random();

    public Mobile(double x, double y, double speed) {
        this.x = x;
        this.y = y;
        
        if(speed <= 0) {
            throw new IllegalArgumentException("Speed " + speed + " should be > 0");
        }
        else {
            this.speed = speed;
        }
    }

    public abstract void move(double timeStep); 
    
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getTheta() {
        return theta;
    }

    public double getSpeed() {
        return speed;
    }
}
