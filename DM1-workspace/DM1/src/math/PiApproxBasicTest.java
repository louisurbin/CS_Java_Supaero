package math;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

@SuppressWarnings("all")
public class PiApproxBasicTest implements WithAssertions {

   @Test
   void testMachin() {
      PiApprox piApprox = new PiApprox();
      assertThat(piApprox.machin()).isEqualTo(Math.PI, within(1e-12));
   }
}
