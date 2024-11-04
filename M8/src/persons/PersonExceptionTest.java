package persons;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class PersonExceptionTest {

    @Test
    @Order(1)
    void validParametersShouldWork() throws Exception {
        assertThat(new Person("Obelix", 44)).isNotNull();
        assertThat(new Person("Kevin", 21)).isNotNull();
    }

    @Test
    @Order(2)
    void invalidParameterShouldThrowAnException() {
        assertThatExceptionOfType(Exception.class).isThrownBy(() -> {
            new Person("Obelix", -1);
        });
        assertThatExceptionOfType(Exception.class).isThrownBy(() -> {
            new Person(null, 44);
        });
    }

    @Test
    @Order(3)
    void exceptionShouldBeIllegalArgumentException() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Person("Obelix", -1);
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Person(null, 44);
        });
    }

    @Test
    @Order(4)
    void exceptionMessageShouldBeExplicit() throws Exception {
        assertThatExceptionOfType(Exception.class).isThrownBy(() -> {
            new Person("Obelix", -1);
        }).withMessageContaining("-1")
                .withMessageContaining("age");
        assertThatExceptionOfType(Exception.class).isThrownBy(() -> {
            new Person(null, 44);
        }).withMessageContaining("null")
            .withMessageContaining("name");
    }

}
