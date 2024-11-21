package anomalies;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class Pixel10PartialTest implements WithAssertions {

    @Test
    @Order(1)
    void validParametersShouldWork() throws Exception {
        assertThat(new Pixel10(1023, 255, 0)).isNotNull();
    }

    @Test
    @Order(2)
    void toStringShouldContainValuesInRGBOrder() throws Exception {
        Pixel10 pixel = new Pixel10(1023, 255, 127);
        String str = pixel.toString().toLowerCase();
        assertThat(str).contains("1023");
        assertThat(str).contains("255");
        assertThat(str).contains("127");
        assertThat(str).containsSubsequence("1023", "255", "127");
    }

    @Test
    @Order(2)
    void invalidParameterShouldThrowAnException() {
        assertThatExceptionOfType(Exception.class).isThrownBy(() -> {
            new Pixel10(-1, 0, 0);
        });
        assertThatExceptionOfType(Exception.class).isThrownBy(() -> {
            new Pixel10(0, 1024, 0);
        });
    }

}
