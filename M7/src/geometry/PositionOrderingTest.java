package geometry;

import fr.supaero.matchers.assertions.TypeAssertions;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;


import fr.supaero.matchers.utils.TypeInfo;

@TestMethodOrder(OrderAnnotation.class)
public class PositionOrderingTest implements WithAssertions {
   private TypeInfo positionTypeInfo = TypeInfo.info(Position.class);

   private Position p00 = new Position(0, 0);
   private Position p10 = new Position(1, 0);
   private Position p20 = new Position(2, 0);
   private Position p11 = new Position(1, 1);
   private Position p12 = new Position(1, 2);

   @Test 
   @Order(1)
   public void positionShouldImplementComparable() {
      TypeAssertions.assertThat(positionTypeInfo)
         .subtypes("java.lang.Comparable")
         .declaresMethod("public int compareTo(Position)");
   }

   @Test
   @Order(2)
   public void differentX() {
      assertThat(p10.compareTo(p00)).isPositive();
      assertThat(p10.compareTo(p10)).isEqualTo(0);
      assertThat(p10.compareTo(p20)).isNegative();
   }

   @Test
   @Order(3)
   public void sameXdifferentY() {
      assertThat(p11.compareTo(p10)).isPositive();
      assertThat(p11.compareTo(p11)).isEqualTo(0);
      assertThat(p11.compareTo(p12)).isNegative();
   }

   @Test
   @Order(4)
   public void logicalEquality() {
      assertThat(p11.compareTo(new Position(1, 1))).isEqualTo(0);
   }
}
