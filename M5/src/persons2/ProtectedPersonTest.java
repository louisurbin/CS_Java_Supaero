package persons2;

import fr.supaero.matchers.assertions.TypeAssertions;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import fr.supaero.matchers.utils.TypeInfo;

@TestMethodOrder(OrderAnnotation.class)
public class ProtectedPersonTest implements WithAssertions {

   private TypeInfo personInfo = TypeInfo.info(Person.class);
   private TypeInfo studentInfo = TypeInfo.info(Student.class);
   private TypeInfo teacherInfo = TypeInfo.info(Teacher.class);

   @Test
   @Order(1)
   public void attributesShouldBeAsInUML() {
      TypeAssertions.assertThat(personInfo)
            .field("name").hasVisibility("protected");
      TypeAssertions.assertThat(personInfo)
            .field("age").hasVisibility("protected");

      TypeAssertions.assertThat(studentInfo)
            .field("promo").hasVisibility("private");
      TypeAssertions.assertThat(teacherInfo)
            .field("specialty").hasVisibility("private");
   }

}
