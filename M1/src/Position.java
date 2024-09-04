/**
 * Simplistic class representing Cartesian 2D positions.
 */
public class Position {
    
    /** Abscissa */
    private double x;
    /** Ordinate */
    private double y;

    /**
     * Initializes a newly created position to the specified coordinates
     * 
     * @param x0 Initial abscissa
     * @param y0 Initial ordinate
     */
    public Position(double x0, double y0) {
        this.x = x0;
        this.y = y0;
    }

    /**
     * Sets current position to the specified coordinates
     * 
     * @param nextX Target abscissa
     * @param nextY Target ordinate
     */
    public void moveTo(double nextX, double nextY) {
        this.x = nextX;
        this.y = nextY;
    }

    /**
     * Euclidean distance of current position to origin (0, 0)
     * 
     * @return Euclidean distance to origin
     */
    public double distanceToOrigin() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    /**
     * Displays current position on the console, with format "(x, y)"
     */
    public void display() {
        System.out.println("(" + this.x + ", " + this.y + ")");
    }

}
