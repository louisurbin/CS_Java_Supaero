package quiz;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Test;
 
@TestMethodOrder(OrderAnnotation.class)
public class SingleChoiceQuestionTest {
    
    @Test
    @Order(1)
    void testConstructor() {
        SingleChoiceQuestion sq = new SingleChoiceQuestion("Single");
        assertThat(sq).isNotNull();
    }

    @Test
    @Order(2)
    void testNbRightAnswers() {
        SingleChoiceQuestion sq = new SingleChoiceQuestion("Single");
        assertThat(sq.nbRightAnswers()).isEqualTo(0);
        sq.addAnswer(new Answer("0", false));
        assertThat(sq.nbRightAnswers()).isEqualTo(0);
        sq.addAnswer(new Answer("12", true));
        assertThat(sq.nbRightAnswers()).isEqualTo(1);
        sq.addAnswer(new Answer("24", true));
        assertThat(sq.nbRightAnswers()).isEqualTo(2);
    }

    @Test
    @Order(3)
    void testIsValid() {
        SingleChoiceQuestion sq = new SingleChoiceQuestion("Single");
        assertThat(sq.isValid()).isEqualTo(false);
        sq.addAnswer(new Answer("0", false));
        assertThat(sq.isValid()).isEqualTo(false);
        sq.addAnswer(new Answer("12", true));
        assertThat(sq.isValid()).isEqualTo(true);
        sq.addAnswer(new Answer("24", true));
        assertThat(sq.isValid()).isEqualTo(false);
    }

}
