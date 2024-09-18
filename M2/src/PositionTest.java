import com.github.stefanbirkner.systemlambda.SystemLambda;
import org.assertj.core.api.WithAssertions;
import org.assertj.core.api.WithAssumptions;
import org.junit.jupiter.api.Test;

public class PositionTest implements WithAssertions, WithAssumptions {

    private static final double EPSILON = 1e-9;

    @Test
    public void testConstructorNoArgs() {
        Position position = new Position();
        assertThat(position).isNotNull();
        assertThat(position).extracting("x").isEqualTo(0.0);
        assertThat(position).extracting("y").isEqualTo(0.0);
    }

    @Test
    public void testConstructorXYArgs() {
        Position position = new Position(4, 3);
        assertThat(position).isNotNull();
        assertThat(position).extracting("x").isEqualTo(4.0);
        assertThat(position).extracting("y").isEqualTo(3.0);
    }

    @Test
    public void testConstructorCopy() {
        Position example = new Position(-4, -3);
        Position copy = new Position(example);
        assertThat(copy).isNotNull();
        assertThat(copy).extracting("x").isEqualTo(-4.0);
        assertThat(copy).extracting("y").isEqualTo(-3.0);
    }

    @Test
    public void testMoveToXYArgs() {
        Position position = new Position();
        position.moveTo(42, 314);
        assertThat(position).extracting("x").isEqualTo(42.0);
        assertThat(position).extracting("y").isEqualTo(314.0);
    }

    @Test
    public void testMoveToPosition() {
        Position example = new Position(-4, -3);
        Position position = new Position();
        position.moveTo(example);
        assertThat(position).extracting("x").isEqualTo(-4.0);
        assertThat(position).extracting("y").isEqualTo(-3.0);
    }

    @Test
    public void testDistanceToOrigin() {
        Position position = new Position(3, 4);
        double d = position.distanceToOrigin();
        assertThat(d).isEqualTo(5, withPrecision(EPSILON));
    }

    @Test
    public void testEqualsTrueCases() {
        Position position = new Position(3, 4);
        assertThat(position.equals(position)).isTrue();
        assertThat(position.equals(new Position(3, 4))).isTrue();
    }

    @Test
    public void testEqualsFalseCases() {
        Position position = new Position(3, 4);
        assertThat(position.equals(null)).isFalse();
        assertThat(position.equals(new Position(42, 4))).isFalse();
        assertThat(position.equals(new Position(3, 42))).isFalse();
        assertThat(position.equals(new Position(42, 42))).isFalse();
    }

    @Test
    public void testDisplay() throws Exception {
        Position position = new Position(3, 4);
        String displayedText = SystemLambda.tapSystemOutNormalized(() -> {
            position.display();
        });
        assertThat(displayedText).containsIgnoringWhitespaces("(3.0, 4.0)");
        assertThat(displayedText).isEqualTo("(3.0, 4.0)\n");
    }

    @Test
    public void testDistance() {
        Position p1 = new Position(1, 0);
        Position p2 = new Position(0, 1);
        double d = Position.distance(p1, p2);
        assertThat(d).isEqualTo(Math.sqrt(2), withPrecision(EPSILON));
    }
}
