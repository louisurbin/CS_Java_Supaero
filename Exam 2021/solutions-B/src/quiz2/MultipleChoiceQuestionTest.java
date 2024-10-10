package quiz2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Test;
 
@TestMethodOrder(OrderAnnotation.class)
public class MultipleChoiceQuestionTest {
    
    @Test
    @Order(1)
    void testConstructor() {
        MultipleChoiceQuestion multiple = new MultipleChoiceQuestion("Multiple");
        assertThat(multiple).isNotNull();
    }

    @Test
    @Order(1)
    void testAddAnswer() {
        MultipleChoiceQuestion multiple = new MultipleChoiceQuestion("Multiple");
        multiple.addAnswer(new Answer("A1", 25));
        multiple.addAnswer(new Answer("A2", 25));
        multiple.addAnswer(new Answer("A3", 50));
    }

    @Test
    @Order(2)
    void testAnswersPercentsSum() {
        MultipleChoiceQuestion multiple = new MultipleChoiceQuestion("Multiple");
        assertThat(multiple.answersPercentsSum()).isEqualTo(0.0);
        multiple.addAnswer(new Answer("A1", 25));
        assertThat(multiple.answersPercentsSum()).isEqualTo(25.0);
        multiple.addAnswer(new Answer("A2", 25));
        assertThat(multiple.answersPercentsSum()).isEqualTo(50.0);
        multiple.addAnswer(new Answer("A3", 50));
        assertThat(multiple.answersPercentsSum()).isEqualTo(100.0);
    }

    @Test
    @Order(3)
    void testIsValid() {
        MultipleChoiceQuestion multiple = new MultipleChoiceQuestion("Multiple");
        assertThat(multiple.isValid()).isEqualTo(false); // sum is 0%
        multiple.addAnswer(new Answer("A1", 25));
        assertThat(multiple.isValid()).isEqualTo(false); // sum is only 25%
        multiple.addAnswer(new Answer("A2", 25));
        assertThat(multiple.isValid()).isEqualTo(false); // sum is only 50%
        multiple.addAnswer(new Answer("A3", 50));
        assertThat(multiple.isValid()).isEqualTo(true); // sum is 100%
        multiple.addAnswer(new Answer("A4", 50));
        assertThat(multiple.isValid()).isEqualTo(false); // too much; sum is 150%
    }

}
