package counter;

import java.util.ArrayList;
import java.util.Collections;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
public class WordCounterBasicTest implements WithAssertions {

      @Test
      @Order(1)
      public void testCreation() {
            WordCounter counter = new WordCounter();
            assertThat(counter).isNotNull();
            assertThat(counter).extracting("wordCounts").isNotNull();
      }

      @Test
      @Order(1)
      public void testZeroGetCount() {
            WordCounter counter = new WordCounter();
            assertThat(counter.getCount("Hello")).isEqualTo(0);
      }

      @Test
      @Order(1)
      public void testParseOnce() {
            WordCounter counter = new WordCounter();

            ArrayList<String> wordList1 = new ArrayList<>();
            Collections.addAll(wordList1, "Foo", "Bar", "Baz", "Foo", "Bar");

            counter.parse(wordList1);
            assertThat(counter.getCount("Foo")).isEqualTo(2);
            assertThat(counter.getCount("Bar")).isEqualTo(2);
            assertThat(counter.getCount("Baz")).isEqualTo(1);
            assertThat(counter.getCount("Qux")).isEqualTo(0);
      }

      @Test
      @Order(1)
      public void testParseTwice() {
            ArrayList<String> wordList1 = new ArrayList<>();
            Collections.addAll(wordList1, "Foo", "Bar", "Baz", "Foo", "Bar");
            ArrayList<String> wordList2 = new ArrayList<>();
            Collections.addAll(wordList2, "Foo", "Foo", "Baz", "Qux");

            WordCounter counter = new WordCounter();
            counter.parse(wordList1);
            counter.parse(wordList2);
            assertThat(counter.getCount("Foo")).isEqualTo(4);
            assertThat(counter.getCount("Bar")).isEqualTo(2);
            assertThat(counter.getCount("Baz")).isEqualTo(2);
            assertThat(counter.getCount("Qux")).isEqualTo(1);
      }
}