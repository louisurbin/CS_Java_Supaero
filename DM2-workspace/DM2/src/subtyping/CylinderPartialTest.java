package subtyping;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class CylinderPartialTest implements WithAssertions {

   @Test
   @Order(1)
   public void constructor() {
      Cylinder cylinder = new Cylinder(new Position3D(1, 2, 3), 4, 5);
      assertThat(cylinder)
            .isNotNull()
            .extracting("radius", "height").containsExactly(4.0, 5.0);
      assertThat(cylinder)
            .extracting("center.x", "center.y", "center.z").containsExactly(1.0, 2.0, 3.0);
   }

   @Test
   @Order(2)
   public void toStringContent() {
      Cylinder cylinder = new Cylinder(new Position3D(1, 2, 3), 4, 5);
      assertThat(cylinder.toString()).contains("1", "2", "3", "4", "5");
   }

   @Test
   @Order(3)
   public void volumeValue() {
      Cylinder cylinder = new Cylinder(new Position3D(1, 2, 3), 4, 5);
      assertThat(cylinder.volume()).isCloseTo(Math.PI * 4 * 4 * 5, withinPercentage(1));
   }

}
