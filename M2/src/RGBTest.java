import org.assertj.core.api.WithAssertions;
import org.assertj.core.api.WithAssumptions;
import org.junit.jupiter.api.Test;

public class RGBTest implements WithAssertions, WithAssumptions {

    private static final double EPSILON = 1e-9;

    @Test
    public void testConstructor() {
        RGB color = new RGB(0, 0, 0);
        assertThat(color).isNotNull();
        assertThat(color).extracting("red", "green", "blue").containsExactly(0.0, 0.0, 0.0);

        color = new RGB(0.1, 0.20, 0.3);
        assertThat(color).isNotNull();
        assertThat(color).extracting("red", "green", "blue").containsExactly(0.1, 0.2, 0.3);
    }

    @Test
    public void testGreyLevel() {
        RGB color = new RGB(0, 0, 0);
        double level = color.greyLevel();
        assertThat(level).isEqualTo(0.0);

        color = new RGB(0.1, 0.2, 0.3);
        level = color.greyLevel();
        assertThat(level).isEqualTo(0.2, withPrecision(EPSILON));
    }

    @Test
    public void testTurnToGrey() {
        RGB color = new RGB(0, 0, 0);
        color.turnToGrey();
        assertThat(color).extracting("red", "green", "blue").containsExactly(0.0, 0.0, 0.0);

        color = new RGB(0.1, 0.2, 0.3);
        color.turnToGrey();
        assertThat(color).extracting("red", "green", "blue").allSatisfy(value -> { 
            assertThat((double)value).isEqualTo(0.2, withPrecision(EPSILON)); 
        }); 

    }
    
}
