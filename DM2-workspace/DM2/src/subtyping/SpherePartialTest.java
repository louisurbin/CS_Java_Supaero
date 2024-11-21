package subtyping;

import fr.supaero.matchers.assertions.TypeAssertions;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import fr.supaero.matchers.utils.TypeInfo;

@TestMethodOrder(OrderAnnotation.class)
public class SpherePartialTest implements WithAssertions {
   private TypeInfo typeInfo = TypeInfo.info(Sphere.class);

   @Test
   @Order(1)
   public void positionShouldImplementComparable() {
      TypeAssertions.assertThat(typeInfo)
            .subtypes("subtyping.AbstractShape")
            .declaresMethod("public String toString()")
            .declaresMethod("public double volume()");
   }

   @Test
   @Order(2)
   public void constructor() {
      Sphere sphere = new Sphere(new Position3D(1, 2, 3), 4);
      assertThat(sphere)
            .isNotNull()
            .extracting("radius").isEqualTo(4.0);
      assertThat(sphere)
            .extracting("center.x", "center.y", "center.z").containsExactly(1.0, 2.0, 3.0);
   }

   @Test
   @Order(3)
   public void toStringContent() {
      Sphere sphere = new Sphere(new Position3D(1, 2, 3), 4);
      assertThat(sphere.toString()).contains("1", "2", "3", "4");
   }

   @Test
   @Order(4)
   public void volumeValue() {
      Sphere sphere = new Sphere(new Position3D(1, 2, 3), 4);
      assertThat(sphere.volume()).isCloseTo((4.0 / 3.0) * Math.PI * 4 * 4 * 4, withinPercentage(1));
   }

}
