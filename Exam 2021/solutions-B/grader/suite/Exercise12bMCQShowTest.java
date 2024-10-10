package suite;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOutNormalized;

import org.assertj.core.api.junit.jupiter.InjectSoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import fr.supaero.grader.annotations.GradedElement;
import fr.supaero.grader.annotations.GradingInfo;
import fr.supaero.matchers.assertions.TypeSoftAssertions;
import quiz2.Answer;
import quiz2.MultipleChoiceQuestion;

@GradedElement
@ExtendWith(SoftAssertionsExtension.class)
@DisplayName("Exercise 1.2b MultiChoiceQuestion showToXxx() methods")
class Exercise12bMCQShowTest {

    @InjectSoftAssertions
    TypeSoftAssertions soft;

    // showToStudent() output

    @Test
    @DisplayName("1.2e MultipleChoiceQuestion showToStudent() method")
    @GradingInfo(value = 0.5, feedback = "Console output for student lacks some important information")
    void multiple_showToStudent() throws Exception {
        Answer a1 = new Answer("AAA", 6);
        Answer a2 = new Answer("BBB", 7);
        Answer a3 = new Answer("CCC", 8);
        Answer a4 = new Answer("DDD", 9);

        MultipleChoiceQuestion question = new MultipleChoiceQuestion("Multiple");
        question.addAnswer(a1);
        question.addAnswer(a2);
        question.addAnswer(a3);
        question.addAnswer(a4);

        String sysOutText = tapSystemOutNormalized(() -> {
            question.showToStudent();
        });

        // must find question, numbers and answers, one per line, in the right order
        sysOutText = sysOutText.replaceAll(",", ".");
        soft.assertThat(sysOutText).containsSubsequence("Multiple", "\n",
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
    @DisplayName("1.2f MultipleChoiceQuestion showToStudent() method, strict")
    @GradingInfo(value = 0.5, feedback = "Console output for student is not exactly the same as in the subject")
    void multiple_showToStudent_exact() throws Exception {
        Answer a1 = new Answer("AAA", 6);
        Answer a2 = new Answer("BBB", 7);
        Answer a3 = new Answer("CCC", 8);
        Answer a4 = new Answer("DDD", 9);

        MultipleChoiceQuestion question = new MultipleChoiceQuestion("Multiple");
        question.addAnswer(a1);
        question.addAnswer(a2);
        question.addAnswer(a3);
        question.addAnswer(a4);

        String sysOutText = tapSystemOutNormalized(() -> {
            question.showToStudent();
        });

        // same as subject (spaces matter)
        String expectedText = "Multiple\n" +
                "   1. AAA\n" +
                "   2. BBB\n" +
                "   3. CCC\n" +
                "   4. DDD\n";
        soft.assertThat(sysOutText).isEqualTo(expectedText);
    }

    // showToTeacher() output

    @Test
    @DisplayName("1.2g MultipleChoiceQuestion showToTeacher() method")
    @GradingInfo(value = 0.5, feedback = "Console output for teacher lacks some important information")
    void multiple_showToTeacher() throws Exception {
        Answer a1 = new Answer("AAA", 6);
        Answer a2 = new Answer("BBB", 7);
        Answer a3 = new Answer("CCC", 8);
        Answer a4 = new Answer("DDD", 9);

        MultipleChoiceQuestion question = new MultipleChoiceQuestion("Multiple");
        question.addAnswer(a1);
        question.addAnswer(a2);
        question.addAnswer(a3);
        question.addAnswer(a4);

        String sysOutText = tapSystemOutNormalized(() -> {
            question.showToTeacher();
        });

        // must find question, numbers and answers, one per line, in the
        // right order, plus an indication for each right answer
        sysOutText = sysOutText.replaceAll(",", ".");
        soft.assertThat(sysOutText).containsSubsequence("Multiple", "\n",
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
    @DisplayName("1.2h MultipleChoiceQuestion showToTeacher() method, fussy")
    @GradingInfo(value = 0.5, feedback = "Console output for teacher is significantly different from subject")
    void multiple_showToTeacher_fussy() throws Exception {
        Answer a1 = new Answer("AAA", 6);
        Answer a2 = new Answer("BBB", 7);
        Answer a3 = new Answer("CCC", 8);
        Answer a4 = new Answer("DDD", 9);

        MultipleChoiceQuestion question = new MultipleChoiceQuestion("Multiple");
        question.addAnswer(a1);
        question.addAnswer(a2);
        question.addAnswer(a3);
        question.addAnswer(a4);

        String sysOutText = tapSystemOutNormalized(() -> {
            question.showToTeacher();
        });

        // closer to subject (spaces matter)
        sysOutText = sysOutText.replaceAll(",", ".");
        String expectedRegex = "\n?Multiple\n" +
                "\\s*6\\.?0*\\s+(0|1)\\. AAA\n" +
                "\\s*7\\.?0*\\s+(1|2)\\. BBB\n" +
                "\\s*8\\.?0*\\s+(2|3)\\. CCC\n" +
                "\\s*9\\.?0*\\s+(3|4)\\. DDD\n";
        soft.assertThat(sysOutText).matches(expectedRegex);
    }

}
