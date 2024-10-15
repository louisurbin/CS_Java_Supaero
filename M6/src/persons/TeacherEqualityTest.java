package persons;

import fr.supaero.matchers.assertions.TypeAssertions;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import fr.supaero.matchers.utils.TypeInfo;

@TestMethodOrder(OrderAnnotation.class)
public class TeacherEqualityTest implements WithAssertions {

   private TypeInfo typeInfo = TypeInfo.info(Teacher.class);

   @Test
   @Order(2)
   public void equalsShouldBeOverriddenFromObject() {
      TypeAssertions.assertThat(typeInfo)
         .hasMethod("equals(Object)");
   }

   @Test
   @Order(10)
   public void equalsShouldWorkForPhysicallyEqualObjects() {
      Teacher nefario = new Teacher("Nefario", 99, "Evil");
      assertThat(nefario.equals(nefario)).isTrue();
   }

   @Test
   @Order(11)
   public void equalsShouldWorkForLogicallyEqualObjects() {
      Teacher nefario1 = new Teacher(new String("Nefario"), 99, new String("Evil"));
      Teacher nefario2 = new Teacher(new String("Nefario"), 99, new String("Evil"));
      assertThat(nefario1.equals(nefario2)).isTrue();
      assertThat(nefario2.equals(nefario1)).isTrue(); // check for symmetry
   }

   @Test
   @Order(20)
   public void equalsShouldFailForLogicallyDifferentSpecialties() {
      Teacher t1 = new Teacher(new String("Nefario"), 99, new String("Evil"));
      Teacher t2 = new Teacher(new String("Nefario"), 99, new String("Evillain"));
      assertThat(t1.equals(t2)).isFalse();
      assertThat(t2.equals(t1)).isFalse(); // check for symmetry
   }

   @Test
   @Order(21)
   public void equalsShouldFailForLogicallyDifferentNames() {
      Teacher t1 = new Teacher(new String("Nefario"), 99, new String("Evil"));
      Teacher t2 = new Teacher(new String("Nefa"), 99, new String("Evil"));
      assertThat(t1.equals(t2)).isFalse();
      assertThat(t2.equals(t1)).isFalse(); // check for symmetry
   }

   @Test
   @Order(22)
   public void equalsShouldFailForLogicallyDifferentAges() {
      Teacher t1 = new Teacher(new String("Nefario"), 99, new String("Evil"));
      Teacher t2 = new Teacher(new String("Nefario"), 21, new String("Evil"));
      assertThat(t1.equals(t2)).isFalse();
      assertThat(t2.equals(t1)).isFalse(); // check for symmetry
   }

   @Test
   @Order(30)
   public void equalsShouldFailForNull() {
      Teacher t1 = new Teacher("Nefario", 99, "Evil");
      Teacher t2 = null;
      assertThat(t1.equals(t2)).isFalse();
   }
}
