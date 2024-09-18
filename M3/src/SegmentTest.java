
import com.github.stefanbirkner.systemlambda.SystemLambda;
import org.assertj.core.api.WithAssertions;
import org.assertj.core.api.WithAssumptions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SegmentTest implements WithAssertions, WithAssumptions {

   private static final double EPSILON = 1e-9;

   @Test
   public void testConstructor() {
      Position p1 = new Position(10, 20);
      Position p2 = new Position(30, 40);
      Segment seg = new Segment(p1, p2);
      assertThat(seg).extracting("beg.x").isEqualTo(10.0);
      assertThat(seg).extracting("beg.y").isEqualTo(20.0);
      assertThat(seg).extracting("end.x").isEqualTo(30.0);
      assertThat(seg).extracting("end.y").isEqualTo(40.0);
   }

   @Test
   public void testMoveTo() {
      Position p1 = new Position(10, 20);
      Position p2 = new Position(30, 40);
      Segment seg = new Segment(p1, p2);
      seg.moveTo(6, 7, 8, 9);
      assertThat(seg).extracting("beg.x").isEqualTo(6.0);
      assertThat(seg).extracting("beg.y").isEqualTo(7.0);
      assertThat(seg).extracting("end.x").isEqualTo(8.0);
      assertThat(seg).extracting("end.y").isEqualTo(9.0);
   }

   @Test
   public void testLength() {
      Position p1 = new Position(0, 3);
      Position p2 = new Position(4, 0);
      Segment seg = new Segment(p1, p2);
      double l = seg.length();
      assertThat(l).isEqualTo(5.0, withPrecision(EPSILON));
   }

   @Test
   public void testDisplay() throws Exception {
      Position p1 = new Position(10, 20);
      Position p2 = new Position(30, 40);
      Segment seg = new Segment(p1, p2);
      seg.moveTo(6, 7, 8, 9);
      String displayedText = SystemLambda.tapSystemOutNormalized(() -> {
         seg.display();
      });
      assertThat(displayedText).containsIgnoringWhitespaces("beg = (6.0, 7.0)");
      assertThat(displayedText).containsIgnoringWhitespaces("end = (8.0, 9.0)");
   }

   
   @Disabled // comment this line and uncomment line 64 to test the translate methods
   @Test 
   public void testTranslate() {
      Position p1 = new Position(10, 20);
      Position p2 = new Position(30, 40);
      Segment seg = new Segment(p1, p2);
      // seg.translate(100, 200);
      assertThat(seg).extracting("beg.x").isEqualTo(110.0);
      assertThat(seg).extracting("beg.y").isEqualTo(220.0);
      assertThat(seg).extracting("end.x").isEqualTo(130.0);
      assertThat(seg).extracting("end.y").isEqualTo(240.0);
   }

}
