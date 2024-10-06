package summits;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@TestMethodOrder(OrderAnnotation.class)
public class BasicSummitTest implements WithAssertions {

   @ParameterizedTest
   @CsvSource({
      "Mont Fourcat, 2001",
      "Dent d'Orlu, 2222",
   })
   @Order(1)
   public void testSummitCreation(String name, int altitude) {
      Summit summit = new Summit(name, altitude);
      assertThat(summit).isNotNull();
      assertThat(summit).extracting("name").isEqualTo(name);
      assertThat(summit).extracting("altitude").isEqualTo(altitude);
      assertThat(summit.getName()).isEqualTo(name);
      assertThat(summit.toString()).containsSubsequence(name, Integer.toString(altitude));
   }

   @Test
   @Order(2)
   public void testAddReport() {
      Summit summit = new Summit("Dent d'Orlu", 2222);
      assertThat(summit).extracting("reports").isNotNull();
      assertThat(summit).extracting("reports").asList().isEmpty();
      summit.addReport(new Report("R1", 1));
      assertThat(summit).extracting("reports").asList().hasSize(1);
      summit.addReport(new Report("R2", 2));
      assertThat(summit).extracting("reports").asList().hasSize(2);
      summit.addReport(new Report("R3", 3));
      assertThat(summit).extracting("reports").asList().hasSize(3);
   }

   @Test
   @Order(3)
   public void testMeanDifficultyLevel() {
      Summit summit = new Summit("Dent d'Orlu", 2222);
      assertThat(summit.meanDifficultyLevel()).isNaN();
      summit.addReport(new Report("R1", 3));
      assertThat(summit.meanDifficultyLevel()).isEqualTo(3.0, within(1e-3));
      summit.addReport(new Report("R2", 3));
      assertThat(summit.meanDifficultyLevel()).isEqualTo(3.0, within(1e-3));
      summit.addReport(new Report("R3", 2));
      summit.addReport(new Report("R4", 1));
      summit.addReport(new Report("R5", 1));
      assertThat(summit.meanDifficultyLevel()).isEqualTo(2.0, within(1e-3));
   }

   @Test
   @Order(4)
   public void testToString() {
      Summit summit = new Summit("Dent d'Orlu", 2222);
      assertThat(summit.toString()).containsSubsequence("Dent d'Orlu", "2222");
      summit.addReport(new Report("R1", 3));
      assertThat(summit.toString()).containsSubsequence("Dent d'Orlu", "2222", "1", "3");
      summit.addReport(new Report("R2", 3));
      assertThat(summit.toString()).containsSubsequence("Dent d'Orlu", "2222", "2", "3");
      summit.addReport(new Report("R3", 2));
      summit.addReport(new Report("R4", 1));
      summit.addReport(new Report("R5", 1));
      assertThat(summit.toString()).containsSubsequence("Dent d'Orlu", "2222", "5", "2");
   }
}