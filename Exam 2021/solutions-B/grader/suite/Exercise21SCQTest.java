package suite;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOutNormalized;

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
import quiz2.SingleChoiceQuestion;

@GradedElement
@ExtendWith(SoftAssertionsExtension.class)
@DisplayName("Exercise 2.1 SingleChoiceQuestion")
class Exercise21SCQTest {

    @InjectSoftAssertions
    TypeSoftAssertions soft;

    private String questionTextName;
    private String answersListName;

    @BeforeEach
    void findUsedFieldsNames() {
        // find names in SingleChoiceQuestion's superclass
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
    
    // SingleChoiceQuestion structure

    @Test
    @DisplayName("2.1a SingleChoiceQuestion class structure")
    @GradingInfo(feedback = "Some details in the UML were not taken into account")
    void single_Uml() throws Exception {
        TypeInfo info = TypeInfo.info(SingleChoiceQuestion.class);
        soft.assertThat(info)
                .isDeclaredAs("public class SingleChoiceQuestion")
                .extendsImplements("extends MultipleChoiceQuestion")
                .declaresConstructor("public SingleChoiceQuestion(String)")
                .declaresMethod("public boolean isValid()");
    }

    @Test
    @DisplayName("2.1b SingleChoiceQuestion class structure is minimal")
    @GradingInfo(feedback = "Unspecified or useless methods/fields should be removed")
    void single_UmlKeepsMinimal() throws Exception {
        TypeInfo info = TypeInfo.info(SingleChoiceQuestion.class);
        soft.assertThat(info)
                .hasFieldCount(0)
                .hasMethodCount(1);
    }

    // constructor, addAnswer(), answersPercentsSum()

    @Test
    @DisplayName("2.1c SingleChoiceQuestion constructor, addAnswer(), answersPercentsSum() still work")
    @GradingInfo(feedback = "One of these constructor/methods does not work")
    void single_constructorAndInheritedMethods() throws Exception {
        SingleChoiceQuestion question = new SingleChoiceQuestion("Single");
        soft.assertThat(question).isNotNull();
        soft.assertThat(question).hasNoNullFieldsOrProperties();

        // inherited fields content (even private)
        soft.assertThat(question).extracting(questionTextName).isEqualTo("Single");
        soft.assertThat(question).extracting(answersListName).isNotNull().asList().isEmpty();

        question = new SingleChoiceQuestion("Single");
        question.addAnswer(new Answer("AAA", 0));
        soft.assertThat(question).extracting(answersListName).isNotNull().asList().hasSize(1);
        question.addAnswer(new Answer("BBB", 100));
        soft.assertThat(question).extracting(answersListName).isNotNull().asList().hasSize(2);
        question.addAnswer(new Answer("CCC", 0));
        soft.assertThat(question).extracting(answersListName).isNotNull().asList().hasSize(3);

        question = new SingleChoiceQuestion("Single");
        soft.assertThat(question.answersPercentsSum()).isEqualTo(0);
        question.addAnswer(new Answer("AAA", 0));
        soft.assertThat(question.answersPercentsSum()).isEqualTo(0);
        question.addAnswer(new Answer("BBB", 42));
        soft.assertThat(question.answersPercentsSum()).isEqualTo(42);
        question.addAnswer(new Answer("CCC", 100));
        soft.assertThat(question.answersPercentsSum()).isEqualTo(142);
    }

    // isValid()

    @Test
    @DisplayName("2.1d SingleChoiceQuestion isValid() method redefinition")
    @GradingInfo(feedback = "isValid() should return true iff only 1 answer is non-zero and 100%")
    void single_isValid() throws Exception {
        SingleChoiceQuestion question = new SingleChoiceQuestion("Single");
        soft.assertThat(question.isValid()).isEqualTo(false);
        question.addAnswer(new Answer("AAA", 0));
        soft.assertThat(question.isValid()).isEqualTo(false);
        question.addAnswer(new Answer("BBB", 0));
        soft.assertThat(question.isValid()).isEqualTo(false);
        question.addAnswer(new Answer("CCC", 100));
        soft.assertThat(question.isValid()).isEqualTo(true);
        question.addAnswer(new Answer("DDD", 0));
        soft.assertThat(question.isValid()).isEqualTo(true);
        question.addAnswer(new Answer("EEE", 0));
        soft.assertThat(question.isValid()).isEqualTo(true);
        question.addAnswer(new Answer("FFF", 42));
        soft.assertThat(question.isValid()).isEqualTo(false);

        question = new SingleChoiceQuestion("Single");
        soft.assertThat(question.isValid()).isEqualTo(false);
        question.addAnswer(new Answer("AAA", 0));
        soft.assertThat(question.isValid()).isEqualTo(false);
        question.addAnswer(new Answer("BBB", 50));
        soft.assertThat(question.isValid()).isEqualTo(false);
        question.addAnswer(new Answer("CCC", 50));
        soft.assertThat(question.isValid()).isEqualTo(false);
        question.addAnswer(new Answer("DDD", 0));
        soft.assertThat(question.isValid()).isEqualTo(false);
        question.addAnswer(new Answer("EEE", 100));
        soft.assertThat(question.isValid()).isEqualTo(false);
    }

    // showToStudent() output

    @Test
    @DisplayName("2.1e SingleChoiceQuestion showToStudent() method")
    @GradingInfo(value = 0.5, feedback = "Console output for student lacks some important information")
    void single_showToStudent() throws Exception {
        Answer a1 = new Answer("AAA", 6);
        Answer a2 = new Answer("BBB", 7);
        Answer a3 = new Answer("CCC", 8);
        Answer a4 = new Answer("DDD", 9);

        SingleChoiceQuestion question = new SingleChoiceQuestion("Single");
        question.addAnswer(a1);
        question.addAnswer(a2);
        question.addAnswer(a3);
        question.addAnswer(a4);

        String sysOutText = tapSystemOutNormalized(() -> {
            question.showToStudent();
        });

        // must find question, numbers and answers, one per line, in the right order
        // String expectedRegex = "Single.*\n+" +
        //         "\\s*(0|1)\\s*\\D*\\s*AAA\n+" +
        //         "\\s*(1|2)\\s*\\D*\\s*BBB\n+" +
        //         "\\s*(2|3)\\s*\\D*\\s*CCC\n+" +
        //         "\\s*(3|4)\\s*\\D*\\s*DDD\n+" +
        //         "\\s*(4|5)\\s*\\D*\\s*EEE\n+";
        // soft.assertThat(sysOutText).matches(expectedRegex);
        sysOutText = sysOutText.replaceAll(",", ".");
        soft.assertThat(sysOutText).containsSubsequence("Single", "\n",
                "AAA", "\n",
                "BBB", "\n",
                "CCC", "\n",
                "DDD");
        if (!sysOutText.contains("4")) {
            soft.assertThat(sysOutText).containsSubsequence("0", "AAA", "1", "BBB", "2", "CCC", "3", "DDD");
        } else {
            soft.assertThat(sysOutText).containsSubsequence("1", "AAA", "2", "BBB", "3", "CCC", "4", "DDD");
        }
    }

    @Test
    @DisplayName("2.1f SingleChoiceQuestion showToStudent() method, strict")
    @GradingInfo(value = 0.5, feedback = "Console output for student is not exactly the same as in the subject")
    void single_showToStudent_exact() throws Exception {
        Answer a1 = new Answer("AAA", 6);
        Answer a2 = new Answer("BBB", 7);
        Answer a3 = new Answer("CCC", 8);
        Answer a4 = new Answer("DDD", 9);

        SingleChoiceQuestion question = new SingleChoiceQuestion("Single");
        question.addAnswer(a1);
        question.addAnswer(a2);
        question.addAnswer(a3);
        question.addAnswer(a4);

        String sysOutText = tapSystemOutNormalized(() -> {
            question.showToStudent();
        });

        // same as subject (spaces matter)
        String expectedText = "Single\n" +
                "   1. AAA\n" +
                "   2. BBB\n" +
                "   3. CCC\n" +
                "   4. DDD\n";
        soft.assertThat(sysOutText).isEqualTo(expectedText);
    }

    // showToTeacher() output

    @Test
    @DisplayName("2.1g SingleChoiceQuestion showToTeacher() method")
    @GradingInfo(value = 0.5, feedback = "Console output for teacher lacks some important information")
    void single_showToTeacher() throws Exception {
        Answer a1 = new Answer("AAA", 6);
        Answer a2 = new Answer("BBB", 7);
        Answer a3 = new Answer("CCC", 8);
        Answer a4 = new Answer("DDD", 9);

        SingleChoiceQuestion question = new SingleChoiceQuestion("Single");
        question.addAnswer(a1);
        question.addAnswer(a2);
        question.addAnswer(a3);
        question.addAnswer(a4);

        String sysOutText = tapSystemOutNormalized(() -> {
            question.showToTeacher();
        });

        // must find question, numbers and answers, one per line, in the
        // right order, plus an indication for each right answer
        // String expectedRegex = "Single.*\n+" +
        //         "\\s*0+[,\\.]?0*\\s+(0|1)\\D*AAA\n+" +
        //         "\\s*0+[,\\.]?0*\\s+(1|2)\\D*BBB\n+" +
        //         "\\s*0+[,\\.]?0*\\s+(2|3)\\D*CCC\n+" +
        //         "\\s*100[,\\.]?0*\\s+(3|4)\\D*DDD\n+" +
        //         "\\s*0+[,\\.]?0*\\s+(4|5)\\D*EEE\n+";
        // soft.assertThat(sysOutText).matches(expectedRegex);
        sysOutText = sysOutText.replaceAll(",", ".");
        soft.assertThat(sysOutText).containsSubsequence("Single", "\n",
                "6.0", "AAA", "\n",
                "7.0", "BBB", "\n",
                "8.0", "CCC", "\n",
                "9.0", "DDD");
        if (!sysOutText.contains("4")) {
            soft.assertThat(sysOutText).containsSubsequence("0", "AAA", "1", "BBB", "2", "CCC", "3", "DDD");
        } else {
            soft.assertThat(sysOutText).containsSubsequence("1", "AAA", "2", "BBB", "3", "CCC", "4", "DDD");
        }
    }

    @Test
    @DisplayName("2.1h MultipleChoiceQuestion showToTeacher() method, fussy")
    @GradingInfo(value = 0.5, feedback = "Console output for teacher is significantly different from subject")
    void single_showToTeacher_fussy() throws Exception {
        Answer a1 = new Answer("AAA", 6);
        Answer a2 = new Answer("BBB", 7);
        Answer a3 = new Answer("CCC", 8);
        Answer a4 = new Answer("DDD", 9);

        SingleChoiceQuestion question = new SingleChoiceQuestion("Single");
        question.addAnswer(a1);
        question.addAnswer(a2);
        question.addAnswer(a3);
        question.addAnswer(a4);

        String sysOutText = tapSystemOutNormalized(() -> {
            question.showToTeacher();
        });

        // closer to subject (spaces matter)
        sysOutText = sysOutText.replaceAll(",", ".");
        String expectedRegex = "\n?Single\n" +
        "\\s*6\\.?0*\\s+(0|1)\\. AAA\n" +
        "\\s*7\\.?0*\\s+(1|2)\\. BBB\n" +
        "\\s*8\\.?0*\\s+(2|3)\\. CCC\n" +
        "\\s*9\\.?0*\\s+(3|4)\\. DDD\n";
        soft.assertThat(sysOutText).matches(expectedRegex);
    }

}
