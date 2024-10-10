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
import quiz2.AbstractQuestion;
import quiz2.MultipleChoiceQuestion;
import quiz2.SingleChoiceQuestion;

@GradedElement
@ExtendWith(SoftAssertionsExtension.class)
@DisplayName("Exercise 2.2 AbstractQuestion")
class Exercise22AbstractQuestionTest {

    @InjectSoftAssertions
    TypeSoftAssertions soft;

    // Question

    @Test
    @DisplayName("2.2a AbstractQuestion class structure")
    @GradingInfo(feedback = "Some details in the UML were not taken into account or useless elements were added")
    void abstractQuestion_Uml() throws Exception {
        TypeInfo info = TypeInfo.info(AbstractQuestion.class);
        soft.assertThat(info).isDeclaredAs("abstract public class AbstractQuestion")
                .declaresMethod("abstract public boolean isValid()")
                .declaresMethod("abstract public void showToStudent()")
                .declaresMethod("abstract public void showToTeacher()")
                .hasFieldCount(0)
                .hasMethodCount(3);
    }

    @Test
    @DisplayName("2.2b Class(es) extending AbstractQuestion")
    @GradingInfo(feedback = "Only MultipleChoiceQuestion should extend AbstractQuestion")
    void abstractQuestion_implementedBy() throws Exception {
        TypeInfo info = TypeInfo.info(MultipleChoiceQuestion.class);
        soft.assertThat(info).extendsImplements("extends AbstractQuestion");
        soft.assertThat(info).implementsNoInterface();

        info = TypeInfo.info(SingleChoiceQuestion.class);
        soft.assertThat(info).implementsNoInterface();
    }

}
