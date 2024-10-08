package counter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

import org.assertj.core.api.Condition;
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

@GradedTest(gradesFile = "Ex-2.txt", summaryFile = "Ex-2.csv")
@ExtendWith(SoftAssertionsExtension.class)
@DisplayName("2 WordCounter class")
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class WordCounterGradingTest implements WithAssertions {

   @InjectSoftAssertions
   TypeSoftAssertions soft;

   TypeInfo info = TypeInfo.info(WordCounter.class);

   @DisplayName("2a Attribute and constructor")
   @Grade(value = 0.5, feedback = "WordCounter() should initialize the wordCounts attribute")
   @Test
   public void testCreation() {
      WordCounter counter = new WordCounter();
      assertThat(counter).isNotNull();
      assertThat(counter).extracting("wordCounts").isNotNull();
   }

   @DisplayName("2b Get count of an unparsed word")
   @Grade(value = 0.5, feedback = "getCount(word) should return 0 if word was never parsed")
   @Test
   public void testZeroGetCount() {
      WordCounter counter = new WordCounter();
      assertThat(counter.getCount("VisualBasic")).isEqualTo(0);
   }

   @DisplayName("2c Get counts after parsing")
   @Grade(value = 0.5, feedback = "after parsing x times word, getCount(word) should return x")
   @Test
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

   @DisplayName("2d Get counts after parsing twice")
   @Grade(value = 0.5, feedback = "counts should not be reset before or after parsing")
   @Test
   public void testParseTwice() {
      WordCounter counter = new WordCounter();

      ArrayList<String> wordList1 = new ArrayList<>();
      Collections.addAll(wordList1, "Foo", "Bar", "Baz", "Foo", "Bar");
      ArrayList<String> wordList2 = new ArrayList<>();
      Collections.addAll(wordList1, "Foo", "Foo", "Baz", "Qux");

      counter.parse(wordList1);
      counter.parse(wordList2);
      assertThat(counter.getCount("Foo")).isEqualTo(4);
      assertThat(counter.getCount("Bar")).isEqualTo(2);
      assertThat(counter.getCount("Baz")).isEqualTo(2);
      assertThat(counter.getCount("Qux")).isEqualTo(1);
   }

   private Condition<FieldInfo> declaredAs(String type) {
      return new Condition<>(fieldInfo -> fieldInfo.type.equals(type),
            "is declared as " + type);
   }

   @SuppressWarnings("unchecked")
   @DisplayName("2e Acceptable type for wordCounts")
   @Test
   @Grade(value = 0.5, feedback = "wordCounts attribute should be a map")
   public void occurrencesIsAMap() {
      FieldInfo fieldInfo = info.getField("wordCounts");
      soft.assertThat(fieldInfo)
            .is(anyOf(
                  declaredAs("Map<String, Integer>"),
                  declaredAs("TreeMap<String, Integer>"),
                  declaredAs("HashMap<String, Integer>"),
                  declaredAs("Hashtable<String, Integer>")));
   }

   @SuppressWarnings("unchecked")
   @DisplayName("2f Most appropriate type for wordCounts")
   @Test
   @Grade(value = 0.5, feedback = "wordCounts attribute should be a TreeMap for ordered printing")
   public void occurrencesIsATreeMap() {
      // declared type for occurrences
      FieldInfo fieldInfo = info.getField("wordCounts");
      soft.assertThat(fieldInfo)
            .is(anyOf(
                  declaredAs("Map<String, Integer>"),
                  declaredAs("NavigableMap<String, Integer>"),
                  declaredAs("TreeMap<String, Integer>")));

      // created instance type
      WordCounter counter = new WordCounter();
      assertThat(counter).extracting("wordCounts").hasSameClassAs(new TreeMap<>());

   }

   @DisplayName("2g Public and private access")
   @Grade(value = 0.5, feedback = "Non-constant attributes should be private, constructors and methods should be public")
   @Test
   public void accessControl() {
      soft.assertThat(info)
            .hasFieldCountGreaterThanOrEqualTo(1)
            .hasOnlyPrivateAttributes()
            .hasConstructorCountGreaterThanOrEqualTo(1)
            .hasOnlyPublicConstructors()
            .hasMethodCountGreaterThanOrEqualTo(1)
            .hasOnlyPublicMethods();
   }

   @DisplayName("2h Textual representation")
   @Test
   @Grade(value = 0.5, feedback = "toString() should display all counts")
   public void usesAllConstants() {
      ArrayList<String> wordList1 = new ArrayList<>();
      Collections.addAll(wordList1, "Foo", "Bar", "Baz", "Foo", "Bar");

      WordCounter counter = new WordCounter();
      counter.parse(wordList1);
      String text = counter.toString();

      soft.assertThat(text).containsIgnoringWhitespaces("Foo=2", "Bar=2", "Baz=1");
   }
}
