package suite;

import static org.assertj.core.api.Assertions.catchThrowable;

import java.text.Normalizer;

import org.assertj.core.api.junit.jupiter.InjectSoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import fr.supaero.grader.annotations.GradedElement;
import fr.supaero.grader.annotations.GradingInfo;
import fr.supaero.grader.annotations.LastGradedElement;
import fr.supaero.matchers.assertions.TypeSoftAssertions;
import quiz2.Answer;

@GradedElement
@LastGradedElement(suiteName = "CPOO Exam: december 2021 second session", summaryFile = "results/grades.csv", summaryDelimiter = " ; ", gradesFile = "results/grades.txt")
@ExtendWith(SoftAssertionsExtension.class)
@DisplayName("Exercise 3 Anomalies and exceptions")
class Exercise3ExceptionsTest {

    @InjectSoftAssertions
    TypeSoftAssertions soft;

    // Anomalies and exceptions

    @Test
    @DisplayName("3a One anomaly is detected and reported as an exception")
    @GradingInfo(feedback = "One anomaly among the possible ones should be detected and reported")
    void anomalies_oneAnomalyIsCovered() throws Exception {
        Throwable exception = catchThrowable(() -> {
            new Answer(null, 42.0);
            new Answer("", 42.0);
            new Answer("Hello", -42.0);
            new Answer("Hello", 4242.0);
        });
        soft.assertThat(exception).isNotNull();
    }

    @Test
    @DisplayName("3b One anomaly is reported with an appropriate exception type")
    @GradingInfo(feedback = "IllegalArgumentException should be used")
    void anomalies_oneAnomalyIsReportedWithAnIllegalArgumentException() throws Exception {
        boolean nullTextThrowsIllegal = false;
        boolean emptyTextThrowsIllegal = false;
        boolean negativePercentThrowsIllegal = false;
        boolean largePercentThrowsIllegal = false;
        try {
            new Answer(null, 100.0);
        } catch (Throwable ex) {
            if (ex instanceof IllegalArgumentException) {
                nullTextThrowsIllegal = true;
            }
        }
        try {
            new Answer("", 100.0);
        } catch (Throwable ex) {
            if (ex instanceof IllegalArgumentException) {
                emptyTextThrowsIllegal = true;
            }
        }
        try {
            new Answer("Hello", -42.0);
        } catch (Throwable ex) {
            if (ex instanceof IllegalArgumentException) {
                negativePercentThrowsIllegal = true;
            }
        }
        try {
            new Answer("Hello", 4242.0);
        } catch (Throwable ex) {
            if (ex instanceof IllegalArgumentException) {
                largePercentThrowsIllegal = true;
            }
        }
        if (!nullTextThrowsIllegal && !emptyTextThrowsIllegal && !negativePercentThrowsIllegal
                && !largePercentThrowsIllegal) {
            soft.fail("None of the thrown exceptions throws an illegal argument exception.");
        }
    }

    @Test
    @DisplayName("3c All anomalies are detected and reported with an appropriate exception type")
    @GradingInfo(feedback = "One of the anomalies is not reported, or not with IllegalArgumentException")
    void anomalies_AllAnomaliesAreCovered() throws Exception {
        Throwable ex1 = catchThrowable(() -> {
            new Answer(null, 42.0);
        });
        Throwable ex2 = catchThrowable(() -> {
            new Answer("", 42.0);
        });
        Throwable ex3 = catchThrowable(() -> {
            new Answer("Hello", -42.0);
        });
        Throwable ex4 = catchThrowable(() -> {
            new Answer("Hello", 4242.0);
        });
        soft.assertThat(ex1)
                .as("Answer with null text creation exception")
                .isNotNull()
                .isInstanceOf(Exception.class)
                .isExactlyInstanceOf(IllegalArgumentException.class);
        soft.assertThat(ex2)
                .as("Answer with empty text creation exception")
                .isNotNull()
                .isInstanceOf(Exception.class)
                .isExactlyInstanceOf(IllegalArgumentException.class);
        soft.assertThat(ex3)
                .as("Answer with negative percentage creation exception")
                .isNotNull()
                .isInstanceOf(Exception.class)
                .isExactlyInstanceOf(IllegalArgumentException.class);
        soft.assertThat(ex4)
                .as("Answer with too large percentage creation exception")
                .isNotNull()
                .isInstanceOf(Exception.class)
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("3d One anomaly is reported with an explicit message")
    @GradingInfo(feedback = "An explicit message should be used when creating a new XxxException(...)")
    void anomalies_oneAnomalyIsExplicit() throws Exception {
        boolean textAnomalyReported = false;
        boolean percentAnomalyReported = false;
        try {
            new Answer(null, 100.0);
            new Answer("", 100.0);
        } catch (Throwable ex) {
            if (ex.getMessage() != null) {
                textAnomalyReported = containsAtLeastOneOf(ex.getMessage(), "réponse", "answer", "texte", "text", "nul",
                        "null", "vide", "empty");
            }
        }
        try {
            new Answer("Hello", -42.0);
            new Answer("Hello", 4242.0);
        } catch (Throwable ex) {
            if (ex.getMessage() != null) {
                percentAnomalyReported = containsAtLeastOneOf(ex.getMessage(), "réponse", "answer", "percent",
                        "pourcent", "négatif", "negative", "grand", "large", "big");
            }
        }
        if (!textAnomalyReported && !percentAnomalyReported) {
            soft.fail("None of the thrown exceptions contain an explicit enough text.");
        }
    }

    // helper functions for explicit message validation

    // remove accents, put in lowercase, remove leading and trailing spaces
    static private String normalize(String string) {
        return Normalizer.normalize(string, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .toLowerCase().trim();
    }

    static private boolean containsAtLeastOneOf(String content, String... elements) {
        for (String element : elements) {
            if (normalize(content).contains(normalize(element))) {
                return true;
            }
        }
        return false;
    }

}
