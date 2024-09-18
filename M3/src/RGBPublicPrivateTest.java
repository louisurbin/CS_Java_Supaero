

import static fr.supaero.matchers.assertions.TypeAssertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import fr.supaero.matchers.utils.TypeInfo;

public class RGBPublicPrivateTest {

   private TypeInfo typeInfo = TypeInfo.info(RGB.class);

   @Test
   public void classShouldBePublic() {
      assertThat(typeInfo)
            .hasVisibility("public");
   }

   @CsvSource({
         "red",
         "green",
         "blue"
   })
   @ParameterizedTest
   public void attributesShouldBePrivate(String name) {
      assertThat(typeInfo)
            .field(name).hasVisibility("private");
   }

   @CsvSource({
      "MIN_RANGE",
      "MAX_RANGE"
   })
   @ParameterizedTest
   public void constantsShouldBePublic(String name) {
      assertThat(typeInfo)
            .field(name).hasVisibility("public")
            .hasAllModifiersOf("final static");
   }

   @CsvSource(delimiter = ';', value = {
         "RGB(double, double, double)"
   })
   @ParameterizedTest
   public void constructorsShouldBePublic(String signature) {
      assertThat(typeInfo)
            .constructor(signature).hasVisibility("public");
   }

   @CsvSource(delimiter = ';', value = {
         "set(double, double, double)",
         "set(double)",
         "display()",
         "greyLevel()",
         "turnToGrey()",
         "equals(RGB)",
         "hasValuesInRange()",
   })
   @ParameterizedTest
   public void methodsShouldBePublic(String signature) {
      assertThat(typeInfo)
            .method(signature).hasVisibility("public");
   }
}
