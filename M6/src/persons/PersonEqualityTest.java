package persons;

import fr.supaero.matchers.assertions.TypeAssertions;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import fr.supaero.matchers.utils.TypeInfo;

@TestMethodOrder(OrderAnnotation.class)
public class PersonEqualityTest implements WithAssertions {

   private TypeInfo typeInfo = TypeInfo.info(Person.class);

   @ParameterizedTest
   @CsvSource({
         "name",
         "age"
   })
   @Order(1)
   public void attributesShouldBePrivate(String name) {
      TypeAssertions.assertThat(typeInfo)
            .field(name).hasVisibility("private");
   }

   @Test
   @Order(2)
   public void equalsShouldBeOverriddenFromObject() {
      TypeAssertions.assertThat(typeInfo)
         .hasMethod("equals(Object)");
   }

   @Test
   @Order(10)
   public void equalsShouldWorkForPhysicallyEqualObjects() {
      Person p = new Person("Obelix", 44);
      assertThat(p.equals(p)).isTrue();
   }

   @Test
   @Order(11)
   public void equalsShouldWorkForLogicallyEqualObjects() {
      Person p1 = new Person("Obelix", 44);
      Person p2 = new Person("Obelix", 44);
      assertThat(p1.equals(p2)).isTrue();
      assertThat(p2.equals(p1)).isTrue(); // check for symmetry
   }

   @Test
   @Order(12)
   public void equalsShouldWorkForLogicallyEqualButPhysicallyDifferentNames() {
      String name1 = new String("Obelix");
      String name2 = "Obelix";
      assertThat(name1).isEqualTo(name2); // names are logically equal
      assertThat(name1).isNotSameAs(name2); // not physically

      Person p1 = new Person(name1, 44);
      Person p2 = new Person(name2, 44);
      // if this fails: do you test _logical_ equality for person names?
      assertThat(p1.equals(p2)).isTrue();
      assertThat(p2.equals(p1)).isTrue();
   }

   @Test
   @Order(20)
   public void equalsShouldFailForLogicallyDifferentNames() {
      Person p1 = new Person("Obelix", 44);
      Person p2 = new Person("Asterix", 44);
      assertThat(p1.equals(p2)).isFalse();
      assertThat(p2.equals(p1)).isFalse();
   }

   @Test
   @Order(21)
   public void equalsShouldFailForDifferentAges() {
      Person p1 = new Person("Obelix", 44);
      Person p2 = new Person("Obelix", 21);
      assertThat(p1.equals(p2)).isFalse();
      assertThat(p2.equals(p1)).isFalse();
   }

   @Test
   @Order(30)
   public void equalsShouldFailForNull() {
      Person p1 = new Person("Obelix", 44);
      Person p2 = null;
      assertThat(p1.equals(p2)).isFalse();
   }
}
