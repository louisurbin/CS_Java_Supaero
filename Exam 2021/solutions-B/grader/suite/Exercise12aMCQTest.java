package suite;

import org.assertj.core.api.junit.jupiter.InjectSoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import fr.supaero.grader.annotations.GradedElement;
import fr.supaero.grader.annotations.GradingInfo;
import fr.supaero.matchers.assertions.TypeSoftAssertions;
import fr.supaero.matchers.utils.FieldInfo;
import fr.supaero.matchers.utils.TypeInfo;
import quiz2.Answer;
import quiz2.MultipleChoiceQuestion;

@GradedElement
@ExtendWith(SoftAssertionsExtension.class)
@DisplayName("Exercise 1.2a MultiChoiceQuestion first methods")
class Exercise12aMCQTest {

    @InjectSoftAssertions
    TypeSoftAssertions soft;

    private String questionTextName;
    private String answersListName;

    @BeforeEach
    void findUsedFieldsNames() {
        TypeInfo info = TypeInfo.info(MultipleChoiceQuestion.class);

        if (info.getField("questionText") != null) {
            questionTextName = "questionText";
        } else {
            FieldInfo questionTextField = info.findFirstFieldWithType("String");
            if (questionTextField == null) {
                questionTextName = null;
            } else {
                questionTextName = questionTextField.name;
            }
        }

        if (info.getField("answers") != null) {
            answersListName = "answers";
        } else {
            FieldInfo answersListField = info.findFirstFieldWithType("ArrayList<Answer>");
            if (answersListField == null) {
                answersListName = null;
            } else {
                answersListName = answersListField.name;
            }
        }
    }

    // MultipleChoiceQuestion class structure

    @Test
    @DisplayName("1.2a MultipleChoiceQuestion class structure")
    @GradingInfo(value = 0.5, feedback = "Some details in the UML were not taken into account")
    void multiple_Uml() throws Exception {
        TypeInfo info = TypeInfo.info(MultipleChoiceQuestion.class);
        soft.assertThat(info).isDeclaredAs("public class MultipleChoiceQuestion");
        soft.assertThat(info).declaresConstructor("public MultipleChoiceQuestion(String)");
        soft.assertThat(info).hasExactlyFields("questionText, answers");
        soft.assertThat(info).declaresField("private String questionText");
        soft.assertThat(info).declaresField("protected ArrayList<Answer> answers");
        soft.assertThat(info).declaresMethod("public void addAnswer(Answer)");
        soft.assertThat(info).declaresMethod("public double answersPercentsSum()"); // typo in subject
        soft.assertThat(info).declaresMethod("public boolean isValid()");
        // soft.assertThat(info).declaresMethod("public void showToStudent()");
        // soft.assertThat(info).declaresMethod("public void showToTeacher()");

    }

    // constructor

    @Test
    @DisplayName("1.2b MultipleChoiceQuestion constructor")
    @GradingInfo(value = 0.5, feedback = "Constructor does not work initialize all fields correctly")
    void multiple_constructor() throws Exception {
        MultipleChoiceQuestion question = new MultipleChoiceQuestion("Multiple");
        soft.assertThat(question).isNotNull();

        // fields are not null
        soft.assertThat(question).hasNoNullFieldsOrProperties();

        // question text is set from
        soft.assertThat(question).extracting(questionTextName).isEqualTo("Multiple");

        // non-null but initially empty answer list
        soft.assertThat(question).extracting(answersListName).asList().as("answers list initially empty").isEmpty();
    }

    // addAnswer()

    @Test
    @DisplayName("1.2c MultipleChoiceQuestion addAnswer()")
    @GradingInfo(value = 0.5, feedback = "addAnswer() does not add answers to the answer list")
    void multiple_addAnswer() throws Exception {
        MultipleChoiceQuestion question = new MultipleChoiceQuestion("Multiple");
        question.addAnswer(new Answer("AAA", 0));
        soft.assertThat(question).extracting(answersListName).isNotNull().asList().hasSize(1);
        question.addAnswer(new Answer("BBB", 42));
        soft.assertThat(question).extracting(answersListName).isNotNull().asList().hasSize(2);
        question.addAnswer(new Answer("CCC", 100));
        soft.assertThat(question).extracting(answersListName).isNotNull().asList().hasSize(3);
    }

    // answersPercentsSum(), isValid()

    @Test
    @DisplayName("1.2d MultipleChoiceQuestion answersPercentsSum() and isValid()")
    @GradingInfo(value = 0.5, feedback = "answersPercentsSum() and/or isValid() does not work")
    void multiple_answersPercentsSum_isValid() throws Exception {
        MultipleChoiceQuestion question = new MultipleChoiceQuestion("Multiple");

        soft.assertThat(question.answersPercentsSum()).isEqualTo(0);
        question.addAnswer(new Answer("AAA", 0));
        soft.assertThat(question.answersPercentsSum()).isEqualTo(0);
        question.addAnswer(new Answer("BBB", 42));
        soft.assertThat(question.answersPercentsSum()).isEqualTo(42);
        question.addAnswer(new Answer("CCC", 100));
        soft.assertThat(question.answersPercentsSum()).isEqualTo(142);

        question = new MultipleChoiceQuestion("Single");
        soft.assertThat(question.isValid()).isEqualTo(false);
        question.addAnswer(new Answer("AAA", 100));
        soft.assertThat(question.isValid()).isEqualTo(true);
        question.addAnswer(new Answer("BBB", 0));
        soft.assertThat(question.isValid()).isEqualTo(true);
        question.addAnswer(new Answer("CCC", 0));
        soft.assertThat(question.isValid()).isEqualTo(true);
        question.addAnswer(new Answer("DDD", 1));
        soft.assertThat(question.isValid()).isEqualTo(false);
        question.addAnswer(new Answer("EEE", 0));
        soft.assertThat(question.isValid()).isEqualTo(false);

        question = new MultipleChoiceQuestion("Single");
        soft.assertThat(question.isValid()).isEqualTo(false);
        question.addAnswer(new Answer("AAA", 0));
        soft.assertThat(question.isValid()).isEqualTo(false);
        question.addAnswer(new Answer("BBB", 42));
        soft.assertThat(question.isValid()).isEqualTo(false);
        question.addAnswer(new Answer("CCC", 58));
        soft.assertThat(question.isValid()).isEqualTo(true);
        question.addAnswer(new Answer("DDD", 0));
        soft.assertThat(question.isValid()).isEqualTo(true);
        question.addAnswer(new Answer("EEE", 0.5));
        soft.assertThat(question.isValid()).isEqualTo(false);
        question.addAnswer(new Answer("FFF", 0));
        soft.assertThat(question.isValid()).isEqualTo(false);
    }

}
