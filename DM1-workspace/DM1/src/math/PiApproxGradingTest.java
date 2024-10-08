package math;

import java.io.File;

import org.assertj.core.api.WithAssertions;
import org.assertj.core.api.junit.jupiter.InjectSoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;

import fr.supaero.grader.annotations.Grade;
import fr.supaero.grader.annotations.GradedTest;
import fr.supaero.matchers.assertions.TypeSoftAssertions;
import fr.supaero.matchers.utils.TypeInfo;

@GradedTest(gradesFile = "Ex-3.txt", summaryFile = "Ex-3.csv")
@ExtendWith(SoftAssertionsExtension.class)
@DisplayName("3 PiApprox class")
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class PiApproxGradingTest implements WithAssertions {

   @InjectSoftAssertions
   TypeSoftAssertions soft;

   TypeInfo info = TypeInfo.info(PiApprox.class);

   final static private double MACHIN_VALUE = 4 * (4 * Math.atan(1 / 5.0) - Math.atan(1 / 239.0));

   @DisplayName("3a machin() computes John Machin's formula")
   @Grade(value = 1, feedback = "machin() should return exactly the value from the formula")
   @Test
   @SuppressWarnings("static-access")
   void exactPi() {
      PiApprox approxPi = new PiApprox();
      soft.assertThat((double) approxPi.machin()).isEqualTo(MACHIN_VALUE);
   }

   @DisplayName("3b machin() method declaration")
   @Grade(value = 0.5, feedback = "machin() should be static")
   @Test
   public void staticMethod() {
      soft.assertThat(info.getMethod("machin()").method)
            .hasAllModifiersOf("static");
   }

   @DisplayName("3c machin() method declaration, continued")
   @Grade(value = 0.5, feedback = "machin() should be public and return double")
   @Test
   public void attributesVisibility() {
      soft.assertThat(info.getMethod("machin()").method)
            .hasVisibility("public")
            .hasReturnType("double");
   }

   @DisplayName("3d machin() calls static Math method atan()")
   @Test
   @Grade(value = 1, feedback = "machin() should call Math.atan()")
   void makesStaticCallToMathAtan() {
      File actualFile = new File("src/math/PiApprox.java");
      soft.assertThat(contentOf(actualFile)).contains("Math.atan");
   }

   @DisplayName("3e machin() uses numbers from the formula")
   @Test
   @Grade(value = 1, feedback = "machin() should use 5 and 239 as in the formula")
   void usesMathConstants() {
      File actualFile = new File("src/math/PiApprox.java");
      soft.assertThat(contentOf(actualFile)).contains("5", "239");
   }
}
