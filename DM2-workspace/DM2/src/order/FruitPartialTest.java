package order;

import fr.supaero.matchers.assertions.TypeAssertions;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;


import fr.supaero.matchers.utils.TypeInfo;

@TestMethodOrder(OrderAnnotation.class)
public class FruitPartialTest implements WithAssertions {
   private TypeInfo fruitTypeInfo = TypeInfo.info(Fruit.class);

   private Fruit fruitAA = new Fruit("A", "A");
   private Fruit fruitBA = new Fruit("B", "A");
   private Fruit fruitCA = new Fruit("C", "A");
   private Fruit fruitBB = new Fruit("B", "B");
   private Fruit fruitBC = new Fruit("B", "C");

   @Test 
   @Order(1)
   public void fruitShouldImplementComparable() {
      TypeAssertions.assertThat(fruitTypeInfo)
         .subtypes("java.lang.Comparable")
         .declaresMethod("public int compareTo(Fruit)");
   }

   @Test
   @Order(2)
   public void sameNameDifferentColors() {
      assertThat(fruitBA.compareTo(fruitAA)).isPositive();
      assertThat(fruitBA.compareTo(fruitBA)).isEqualTo(0);
      assertThat(fruitBA.compareTo(fruitCA)).isNegative();
   }

   @Test
   @Order(3)
   public void sameColorDifferentNames() {
      assertThat(fruitBB.compareTo(fruitBA)).isPositive();
      assertThat(fruitBB.compareTo(fruitBB)).isEqualTo(0);
      assertThat(fruitBB.compareTo(fruitBC)).isNegative();
   }

   @Test
   @Order(4)
   public void logicalEquality() {
      assertThat(fruitBB.compareTo(new Fruit("B", "B"))).isEqualTo(0);
   }
}
