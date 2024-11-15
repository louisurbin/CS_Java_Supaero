package geometry;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class BarycenterTest {

    private ArrayList<Position> positions;

    @BeforeEach
    void setup() {
        positions = new ArrayList<>();
        positions.add(new Position(1, 4));
        positions.add(new Position(2, 6));
        positions.add(new Position(3, 5));
    }

    @Test
    @Order(1)
    void barycenterShouldWorkWithNominalArrayList() {
        Position barry = Position.barycenter(positions);
        assertThat(barry).isNotNull();
        assertThat(barry).extracting("x").isEqualTo(2.0);
        assertThat(barry).extracting("y").isEqualTo(5.0);
    }

    @Test
    @Order(2)
    void withOneElementArrayList() {
        // first element of positions
        Position barry = Position.barycenter(positions.subList(0, 1));
        assertThat(barry).isNotNull();
        assertThat(barry).extracting("x").isEqualTo(1.0);
        assertThat(barry).extracting("y").isEqualTo(4.0);
    }

    @Test
    @Order(10)
    void withHashSet() {
        Collection<Position> coco = new HashSet<>();
        coco.addAll(positions);
        Position barry = Position.barycenter(coco);
        assertThat(barry).isNotNull();
        assertThat(barry).extracting("x").isEqualTo(2.0);
        assertThat(barry).extracting("y").isEqualTo(5.0);
    }

    @Test
    @Order(20)
    void throwExceptionForNullOrEmptyParameter() {
        assertThatThrownBy(() -> {
            Position.barycenter(null);
        }).hasMessageContaining("null").isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            Position.barycenter(new ArrayList<>());
        }).hasMessageContaining("empty").isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            Position.barycenter(new HashSet<>());
        }).hasMessageContaining("empty").isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            Position.barycenter(new TreeSet<>());
        }).hasMessageContaining("empty").isInstanceOf(IllegalArgumentException.class);
    }

}
