

import static fr.supaero.matchers.assertions.TypeAssertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import fr.supaero.matchers.utils.TypeInfo;

public class PositionPublicPrivateTest {

   private TypeInfo typeInfo = TypeInfo.info(Position.class);

   @Test
   public void classShouldBePublic() {
      assertThat(typeInfo)
            .hasVisibility("public");
   }

   @CsvSource({
         "x",
         "y"
   })
   @ParameterizedTest
   public void attributesShouldBePrivate(String name) {
      assertThat(typeInfo)
            .field(name).hasVisibility("private");
   }

   @CsvSource(delimiter = ';', value = {
         "Position()",
         "Position(double, double)",
         "Position(Position)"
   })
   @ParameterizedTest
   public void constructorsShouldBePublic(String signature) {
      assertThat(typeInfo)
            .constructor(signature).hasVisibility("public");
   }

   @CsvSource(delimiter = ';', value = {
         "moveTo(double, double)",
         "moveTo(Position)",
         "display()",
         "distanceToOrigin()",
         "distance(Position, Position)",
         "equals(Position)"
   })
   @ParameterizedTest
   public void methodsShouldBePublic(String signature) {
      assertThat(typeInfo)
            .method(signature).hasVisibility("public");
   }
}
