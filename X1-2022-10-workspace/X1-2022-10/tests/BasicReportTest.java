package summits;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@TestMethodOrder(OrderAnnotation.class)
public class BasicReportTest implements WithAssertions {

   @ParameterizedTest
   @CsvSource({
      "Text 1, 1",
      "Text 2, 2",
      "Text 3, 3",
      "Text 4, 4",
   })
   @Order(1)
   public void testReportCreation(String description, int level) {
      Report report = new Report(description, level);
      assertThat(report).isNotNull();
      assertThat(report).extracting("description").isEqualTo(description);
      assertThat(report).extracting("difficultyLevel").isEqualTo(level);
      assertThat(report.getDifficultyLevel()).isEqualTo(level);
      assertThat(report.toString()).containsSubsequence(description, Integer.toString(level), "4");
   }

   @ParameterizedTest
   @CsvSource({
      "Text 0, 0",
      "Text -100, -100",
   })
   @Order(2)
   public void testReportCreation_WithLowLevels(String description, int level) {
      Report report = new Report(description, level);
      assertThat(report).isNotNull();
      assertThat(report).extracting("description").isEqualTo(description);
      assertThat(report).extracting("difficultyLevel").isEqualTo(1);
      assertThat(report.getDifficultyLevel()).isEqualTo(1);
      assertThat(report.toString()).containsSubsequence(description, "1", "4");
   }


   @ParameterizedTest
   @CsvSource({
      "Text 5, 5",
      "Text 42, 42",
   })
   @Order(3)
   public void testReportCreation_WithHighLevels(String description, int level) {
      Report report = new Report(description, level);
      assertThat(report).isNotNull();
      assertThat(report).extracting("description").isEqualTo(description);
      assertThat(report).extracting("difficultyLevel").isEqualTo(4);
      assertThat(report.getDifficultyLevel()).isEqualTo(4);
      assertThat(report.toString()).containsSubsequence(description, "4", "4");
   }
}