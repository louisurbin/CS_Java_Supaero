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
@DisplayName("Person as a subclass of Object")
public class PersonTest implements WithAssertions {

   private TypeInfo typeInfo = TypeInfo.info(Person.class);

   @Test
   @Order(0)
   public void superClassShouldBeObject() {
      TypeAssertions.assertThat(typeInfo)
            .extendsClass("Object");
   }

   @Test
   @Order(1)
   public void classShouldBePublic() {
      TypeAssertions.assertThat(typeInfo)
            .hasVisibility("public");
   }

   @ParameterizedTest
   @CsvSource({
         "name",
         "age"
   })
   @Order(2)
   public void attributesShouldBePrivate(String name) {
      TypeAssertions.assertThat(typeInfo)
            .field(name).hasVisibility("private");
   }

   @ParameterizedTest
   @CsvSource(delimiter = ';', value = {
         "Person(String, int)",
   })
   @Order(3)
   public void constructorShouldBePublic(String signature) {
      TypeAssertions.assertThat(typeInfo)
            .constructor(signature).hasVisibility("public");
   }

   @ParameterizedTest
   @CsvSource(delimiter = ';', value = {
         "getName()",
         "getAge()",
         "display()",
         "toString()"
   })
   @Order(4)
   public void methodsShouldBePublic(String signature) {
      TypeAssertions.assertThat(typeInfo)
            .method(signature).hasVisibility("public");
   }

   @Test
   @Order(5)
   public void creationInitializesAttributes() {
      Person obe = new Person("Obelix", 44);
      assertThat(obe).extracting("name", "age").contains("Obelix", 44);
   }

   @Test
   @Order(6)
   public void gettersShouldWork() {
      Person obe = new Person("Obelix", 44);
      assertThat(obe.getName()).isEqualTo("Obelix");
      assertThat(obe.getAge()).isEqualTo(44);
   }

   @Test
   @Order(7)
   public void toStringShouldShowNameAndAge() {
      Person obe = new Person("Obelix", 44);
      assertThat(obe.toString()).contains("Obelix", "44");
   }

   @Test
   @Order(7)
   public void displayShouldShowObjectToStringAndPersonToString() throws Exception {
      Person obe = new Person("Obelix", 44);
      String displayedText = SystemLambda.tapSystemOutNormalized(() -> {
         obe.display();
      });
      assertThat(displayedText).contains(obe.toString());
      assertThat(displayedText).containsSubsequence(obe.getClass().getName(), "@", Integer.toHexString(obe.hashCode()));
   }

}
