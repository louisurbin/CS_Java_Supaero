package geometry;

import fr.supaero.matchers.assertions.TypeAssertions;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;


import fr.supaero.matchers.utils.TypeInfo;

@TestMethodOrder(OrderAnnotation.class)
public class DisplayableTest implements WithAssertions {

   private TypeInfo displayableTypeInfo = TypeInfo.info(Displayable.class);
   private TypeInfo positionTypeInfo = TypeInfo.info(Position.class);
   private TypeInfo circleTypeInfo = TypeInfo.info(Circle.class);

   @DisplayName("interface Displayable should be very simple")
   @Test @Order(1)
   public void displayableInterfaceContent() {
      TypeAssertions.assertThat(displayableTypeInfo)
         .isDeclaredAs("public interface Displayable")
         .hasMethodCount(1)
         .declaresMethod("void display()");
   }

   @DisplayName("class Position should implement Displayable and be concrete")
   @Test @Order(2)
   public void positionShouldImplementDisplayable() {
      TypeAssertions.assertThat(positionTypeInfo)
         .hasNature("class")
         .isDeclaredAs("public class Position")
         .subtypes("geometry.Displayable")
         .declaresMethod("public void display()");
   }

   @DisplayName("class Circle should implement Displayable and be concrete")
   @Test @Order(2)
   public void circleShouldImplementDisplayable() {
      TypeAssertions.assertThat(circleTypeInfo)
         .hasNature("class")
         .isDeclaredAs("public class Circle")
         .subtypes("geometry.Displayable")
         .declaresMethod("public void display()");
   }

}
