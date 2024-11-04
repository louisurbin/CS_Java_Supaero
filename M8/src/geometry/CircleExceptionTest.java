package geometry;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class CircleExceptionTest {

    @Test
    @Order(1)
    void validParametersShouldWork() throws Exception {
        assertThat(new Circle(1, new Position(2, 3))).isNotNull();
    }

    @Test
    @Order(2)
    void invalidParameterShouldThrowAnException() {
        assertThatExceptionOfType(Exception.class).isThrownBy(() -> {
            new Circle(-1, new Position(2, 3));
        });
        assertThatExceptionOfType(Exception.class).isThrownBy(() -> {
            new Circle(1, null);
        });
    }

    @Test
    @Order(3)
    void exceptionShouldBeIllegalArgumentException() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Circle(-1, new Position(2, 3));
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Circle(1, null);
        });
    }

    @Test
    @Order(4)
    void exceptionMessageShouldBeExplicit() throws Exception {
        assertThatExceptionOfType(Exception.class).isThrownBy(() -> {
            new Circle(-1, new Position(2, 3));
        }).withMessageContaining("-1")
            .withMessageContaining("negative")
            .withMessageContaining("radius");
        assertThatExceptionOfType(Exception.class).isThrownBy(() -> {
            new Circle(1, null);
        }).withMessageContaining("null")
            .withMessageContaining("center");
    }

}
