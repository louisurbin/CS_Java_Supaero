package maths;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BasicStirlingTest implements WithAssertions {

   @ParameterizedTest
   @CsvSource({
      "1, 0.999, 0.001",
      "3, 5.998, 0.001",
      "6, 719.94, 0.01",
      "10, 3628685, 1"
   })
   void testStirling(int n, double expected, double tolerance) {
      assertThat(Stirling.factorial(n)).isEqualTo(expected, within(tolerance));
   }
}
