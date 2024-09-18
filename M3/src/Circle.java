/**
 * Simple class representing a circle
 */
public class Circle {

   /** Radius */
   private double radius;
   /** Center coordinates */
   private Position center;

   /**
    * Initialize a circle with the specified radius and center coordinates
    *
    * @param radius Initial radius
    * @param xc     Initial center abscissa
    * @param yc     Initial center ordinate
    */
   public Circle(double radius, double xc, double yc) {
      this.radius = radius;
      this.center = new Position(xc, yc);
   }

   /**
    * Initialize a circle with the specified radius and center coordinates
    * 
    * @param radius Initial radius
    * @param pos    Initial center specified as a position, is shared
    */
   public Circle(double radius, Position pos) {
      this.radius = radius;
      this.center = pos; // center shared
      // this.center = new Position(pos); // center duplicated
   }

   /**
    * Sets current circle center to the specified coordinates
    * 
    * @param xc Target center abscissa
    * @param yc Target center ordinate
    */
   public void moveTo(double xc, double yc) {
      this.center.moveTo(xc, yc); // delegate to Position's moveTo()
   }

   /**
    * Sets current circle center to the specified coordinates
    * 
    * @param pos Target center coordinates specified as a position
    */
   public void moveTo(Position pos) {
      this.center.moveTo(pos);
      // delegate to Position's moveTo() using current center
   }

   /**
    * Displays current circle on the console, with format "radius = r center = (x, y)"
    */
   public void display() {
      System.out.print("radius = " + this.radius + " center = "); // print, not println
      this.center.display(); // delegate to Position's display()
   }
}
