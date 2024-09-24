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
@DisplayName("Teacher as a subclass of Person")
public class TeacherTest implements WithAssertions {

   private TypeInfo typeInfo = TypeInfo.info(Teacher.class);

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
         "specialty"
   })
   @Order(2)
   public void attributesShouldBePrivate(String name) {
      TypeAssertions.assertThat(typeInfo)
            .field(name).hasVisibility("private");
   }

   @ParameterizedTest
   @CsvSource(delimiter = ';', value = {
         "Teacher(String, int, String)",
   })
   @Order(3)
   public void constructorShouldBePublic(String signature) {
      TypeAssertions.assertThat(typeInfo)
            .constructor(signature).hasVisibility("public");
   }

   @ParameterizedTest
   @CsvSource(delimiter = ';', value = {
         "getSpecialty()",
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
      Teacher nefario = new Teacher("Nefario", 99, "Evil");
      assertThat(nefario).extracting("name", "age", "specialty").contains("Nefario", 99, "Evil");
   }

   @Test
   @Order(7)
   public void gettersShouldWork() {
      Teacher nefario = new Teacher("Nefario", 99, "Evil");
      assertThat(nefario.getSpecialty()).isEqualTo("Evil");
      assertThat(nefario.getAge()).isEqualTo(99);
      assertThat(nefario.getName()).isEqualTo("Nefario");
   }

   @Test
   @Order(8)
   public void toStringShouldShowNameAndSpecialtyButNotAge() {
      Teacher nefario = new Teacher("Nefario", 99, "Evil");
      assertThat(nefario.toString())
            .contains("Nefario", "Evil")
            .doesNotContain("99");
   }

   @Test
   @Order(9)
   public void displayShouldShowObjectToStringAndPersonToString() throws Exception {
      Teacher nefario = new Teacher("Nefario", 99, "Evil");
      String displayedText = SystemLambda.tapSystemOutNormalized(() -> {
         nefario.display();
      });
      assertThat(displayedText).contains(nefario.toString());
      assertThat(displayedText).containsSubsequence(nefario.getClass().getName(), "@", Integer.toHexString(nefario.hashCode()));
   }

}
