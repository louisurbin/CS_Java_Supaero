package geometry;

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
    * @param pos    Initial center specified as a position, is shared
    */
   public Circle(double radius, Position pos) {
      if (radius < 0) {
         throw new IllegalArgumentException(String.format("radius = %f must non-negative",radius));
      }
      if (pos == null) {
         throw new IllegalArgumentException("center must be non-null");
      }

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

   @Override
   public String toString() {
      return "radius = " + this.radius + " center = " + this.center.toString();
   }
}
