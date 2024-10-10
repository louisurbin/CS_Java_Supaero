package suite;

import org.assertj.core.api.junit.jupiter.InjectSoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import fr.supaero.grader.annotations.GradedElement;
import fr.supaero.grader.annotations.GradingInfo;
import fr.supaero.matchers.assertions.TypeSoftAssertions;
import fr.supaero.matchers.utils.TypeInfo;
import quiz2.Answer;

@GradedElement
@ExtendWith(SoftAssertionsExtension.class)
@DisplayName("Exercise 1.1 Answer")
class Exercise11AnswerTest {

    @InjectSoftAssertions
    TypeSoftAssertions soft;

    // Answer

    @Test
    @DisplayName("1.1a Answer class structure")
    @GradingInfo(feedback = "Some details in the UML were not taken into account")
    void answer_Uml() throws Exception {
        TypeInfo answerTypeInfo = TypeInfo.info(Answer.class);

        // no unwanted subtyping
        soft.assertThat(answerTypeInfo).as("class declaration")
                .isDeclaredAs("public class Answer")
                .extendsImplements("");

        // 2 private fields: String text and double percent
        soft.assertThat(answerTypeInfo).as("fields")
                .hasExactlyFields("text, percent")
                .declaresField("private String text")
                .declaresField("private double percent");

        // one public constructor with String and double
        soft.assertThat(answerTypeInfo).as("constructor")
                .hasConstructorCount(1)
                .declaresConstructor("public Answer(String, double)");

        // two public getter methods
        soft.assertThat(answerTypeInfo).as("methods")
                .hasMethodCount(2)
                .declaresMethod("public double getPercent()")
                .declaresMethod("public String getText()");
    }

    @Test
    @DisplayName("1.1b Answer constructor")
    @GradingInfo(feedback = "Constructor Answer(String, double) should initialize its fields with the passed values")
    void answer_constructor() throws Exception {
        Answer right = new Answer("Vrai", 100.0);
        soft.assertThat(right).isNotNull();
        soft.assertThat(right).extracting("text").isEqualTo("Vrai");
        soft.assertThat(right).extracting("percent").isEqualTo(100.0);
        Answer wrong = new Answer("Faux", 0.0);
        soft.assertThat(wrong).isNotNull();
        soft.assertThat(wrong).extracting("text").isEqualTo("Faux");
        soft.assertThat(wrong).extracting("percent").isEqualTo(0.0);
    }

    @Test
    @DisplayName("1.1c Answer getText() method")
    @GradingInfo(feedback = "Method getText() should return the content of the text field")
    void answer_getText() throws Exception {
        Answer right = new Answer("Vrai", 100.0);
        soft.assertThat(right.getText()).isEqualTo("Vrai");
        Answer wrong = new Answer("Faux", 0.0);
        soft.assertThat(wrong.getText()).isEqualTo("Faux");
    }

    @Test
    @DisplayName("1.1d Answer getPercent() method")
    @GradingInfo(feedback = "Method getPercent() should return the content of the percent field")
    void answer_isRight() throws Exception {
        Answer right = new Answer("Vrai", 100.0);
        soft.assertThat(right.getPercent()).isEqualTo(100.0);
        Answer mid = new Answer("Faux", 42.0);
        soft.assertThat(mid.getPercent()).isEqualTo(42.0);
        Answer wrong = new Answer("Faux", 0.0);
        soft.assertThat(wrong.getPercent()).isEqualTo(0.0);
    }
    
}
