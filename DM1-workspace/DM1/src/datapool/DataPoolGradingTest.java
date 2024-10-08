package datapool;

import java.util.TreeMap;

import org.assertj.core.api.WithAssertions;
import org.assertj.core.api.junit.jupiter.InjectSoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;

import fr.supaero.grader.annotations.Grade;
import fr.supaero.grader.annotations.GradedTest;
import fr.supaero.matchers.assertions.TypeSoftAssertions;
import fr.supaero.matchers.utils.FieldInfo;
import fr.supaero.matchers.utils.TypeInfo;

@GradedTest(gradesFile = "Ex-4.txt", summaryFile = "Ex-4.csv")
@ExtendWith(SoftAssertionsExtension.class)
@DisplayName("4 DataPool generic class")
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class DataPoolGradingTest implements WithAssertions {

   @InjectSoftAssertions
   TypeSoftAssertions soft;

   TypeInfo info = TypeInfo.info(DataPool.class);

   @DisplayName("4a DataPool class declaration")
   @Grade(value = 1, feedback = "Class DataPool should be generic")
   @Test
   public void genericClass() {
      soft.assertThat(info.signature).matches("class DataPool<\\w+>");
   }

   @DisplayName("4b DataPool repeated add/get")
   @Grade(value = 1, feedback = "A DataPool should only store the X newest element")
   @Test
   public void repeatedAddGet() {
      DataPool<String> pool = new DataPool<>(3);

      int a = pool.add("A");
      assertThat(pool.get(a)).isEqualTo("A");

      int b = pool.add("B");
      assertThat(pool.get(a)).isEqualTo("A");
      assertThat(pool.get(b)).isEqualTo("B");

      int c = pool.add("C");
      assertThat(pool.get(a)).isEqualTo("A");
      assertThat(pool.get(b)).isEqualTo("B");
      assertThat(pool.get(c)).isEqualTo("C");

      int d = pool.add("D");
      assertThat(pool.get(a)).isNull();
      assertThat(pool.get(b)).isEqualTo("B");
      assertThat(pool.get(c)).isEqualTo("C");
      assertThat(pool.get(d)).isEqualTo("D");

      int e = pool.add("E");
      assertThat(pool.get(a)).isNull();
      assertThat(pool.get(b)).isNull();
      assertThat(pool.get(c)).isEqualTo("C");
      assertThat(pool.get(d)).isEqualTo("D");
      assertThat(pool.get(e)).isEqualTo("E");
   }

   @DisplayName("4c DataPool remove among adds")
   @Grade(value = 1, feedback = "DataPool remove should allow keeping older elements")
   @Test
   public void addGetRemove() {
      DataPool<String> pool = new DataPool<>(3);

      int a = pool.add("A");
      int b = pool.add("B");
      int c = pool.add("C");
      int d = pool.add("D");
      pool.remove(d);
      int e = pool.add("E");

      assertThat(pool.get(a)).isNull();
      assertThat(pool.get(b)).isEqualTo("B"); // B is kept
      assertThat(pool.get(c)).isEqualTo("C"); // C is kept
      assertThat(pool.get(d)).isNull();
      assertThat(pool.get(e)).isEqualTo("E");

      // get can be called twice
      assertThat(pool.get(e)).isEqualTo("E");
      assertThat(pool.get(e)).isEqualTo("E");

      // remove with unused key does nothing
      pool.remove(a);
      pool.remove(d);
      assertThat(pool.get(a)).isNull();
      assertThat(pool.get(b)).isEqualTo("B");
      assertThat(pool.get(c)).isEqualTo("C");
      assertThat(pool.get(d)).isNull();
      assertThat(pool.get(e)).isEqualTo("E");
   }

   @DisplayName("4e DataPool occupancy indicators")
   @Grade(value = 0.5, feedback = "DataPool isFull() and occupancyRate() should return appropriate values")
   @Test
   public void occupancy() {
      DataPool<String> pool = new DataPool<>(3);
      assertThat(pool.isFull()).isFalse();
      assertThat(pool.occupancyPercentage()).isEqualTo(0.0, within(1.0));

      int a = pool.add("A");
      assertThat(pool.isFull()).isFalse();
      assertThat(pool.occupancyPercentage()).isEqualTo(33.0, within(1.0));

      int b = pool.add("B");
      assertThat(pool.isFull()).isFalse();
      assertThat(pool.occupancyPercentage()).isEqualTo(66.0, within(1.0));

      pool.add("C");
      assertThat(pool.isFull()).isTrue();
      assertThat(pool.occupancyPercentage()).isEqualTo(100.0, within(1.0));

      pool.remove(b);
      assertThat(pool.isFull()).isFalse();
      assertThat(pool.occupancyPercentage()).isEqualTo(66.0, within(1.0));

      pool.remove(a);
      assertThat(pool.isFull()).isFalse();
      assertThat(pool.occupancyPercentage()).isEqualTo(33.0, within(1.0));

      pool.add("D");
      assertThat(pool.isFull()).isFalse();
      assertThat(pool.occupancyPercentage()).isEqualTo(66.0, within(1.0));
   }

   @DisplayName("4e DataPool optimal storage")
   @Grade(value = 0.5, feedback = "DataPool should only use a tree map")
   @Test
   public void storageType() {
      String mapField = null;
      for (FieldInfo field : info.getDeclaredFields().values()) {
         if (field.type.matches("(TreeMap|NavigableMap|Map)<Integer, \\w+>")) {
            mapField = field.name;
            break;
         }
      }
      assertThat(mapField).as("Has a TreeMap<Integer, E> field").isNotNull();

      DataPool<String> pool = new DataPool<>(3);
      assertThat(pool).extracting(mapField).hasSameClassAs(new TreeMap<>());
   }

}
