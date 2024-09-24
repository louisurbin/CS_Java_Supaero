package persons;

import fr.supaero.matchers.assertions.TypeAssertions;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.github.stefanbirkner.systemlambda.SystemLambda;

import fr.supaero.matchers.utils.TypeInfo;

@TestMethodOrder(OrderAnnotation.class)
@DisplayName("Student as a subclass of Person")
public class StudentTest implements WithAssertions {

   private TypeInfo typeInfo = TypeInfo.info(Student.class);

   @Test
   @Order(0)
   public void superClassShouldBePerson() {
      TypeAssertions.assertThat(typeInfo)
            .extendsClass("Person");
   }

   @Test
   @Order(1)
   public void classShouldBePublic() {
      TypeAssertions.assertThat(typeInfo)
            .hasVisibility("public");
   }

   @ParameterizedTest
   @CsvSource({
         "promo"
   })
   @Order(2)
   public void attributesShouldBePrivate(String name) {
      TypeAssertions.assertThat(typeInfo)
            .field(name).hasVisibility("private");
   }

   @ParameterizedTest
   @CsvSource(delimiter = ';', value = {
         "Student(String, int, String)",
   })
   @Order(3)
   public void constructorShouldBePublic(String signature) {
      TypeAssertions.assertThat(typeInfo)
            .constructor(signature).hasVisibility("public");
   }

   @ParameterizedTest
   @CsvSource(delimiter = ';', value = {
         "getPromo()",
         "toString()"
   })
   @Order(4)
   public void methodsShouldBePublic(String signature) {
      TypeAssertions.assertThat(typeInfo)
            .method(signature).hasVisibility("public");
   }

   @Test
   @Order(5)
   public void classShouldOnlyRedefineToString() {
      TypeAssertions.assertThat(typeInfo)
            .hasMethodCount(2);
   }

   @Test
   @Order(6)
   public void creationInitializesAttributes() {
      Student kevin = new Student("Kevin", 21, "promo24");
      assertThat(kevin).extracting("name", "age", "promo").contains("Kevin", 21, "promo24");
   }

   @Test
   @Order(7)
   public void gettersShouldWork() {
      Student kevin = new Student("Kevin", 21, "promo24");
      assertThat(kevin.getPromo()).isEqualTo("promo24");
      assertThat(kevin.getAge()).isEqualTo(21);
      assertThat(kevin.getName()).isEqualTo("Kevin");
   }

   @Test
   @Order(8)
   public void toStringShouldShowNameAndSpecialtyButNotAge() {
      Student kevin = new Student("Kevin", 21, "promo24");
      assertThat(kevin.toString())
            .contains("Kevin", "21", "promo24");
   }

   @Test
   @Order(9)
   public void displayShouldShowObjectToStringAndPersonToString() throws Exception {
      Student kevin = new Student("Kevin", 21, "promo24");
      String displayedText = SystemLambda.tapSystemOutNormalized(() -> {
         kevin.display();
      });
      assertThat(displayedText).contains(kevin.toString());
      assertThat(displayedText).containsSubsequence(kevin.getClass().getName(), "@",
            Integer.toHexString(kevin.hashCode()));
   }

}
