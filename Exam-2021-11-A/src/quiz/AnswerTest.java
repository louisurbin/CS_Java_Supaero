package quiz;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Test;
 
@TestMethodOrder(OrderAnnotation.class)
public class AnswerTest {
    
    @Test
    @Order(1)
    void testConstructor() {
        Answer right = new Answer("Vrai", true);
        assertThat(right).isNotNull();
        assertThat(right).extracting("text").isEqualTo("Vrai");
        assertThat(right).extracting("right").isEqualTo(true);
        Answer wrong = new Answer("Faux", false);
        assertThat(wrong).isNotNull();
        assertThat(wrong).extracting("text").isEqualTo("Faux");
        assertThat(wrong).extracting("right").isEqualTo(false);
    }

    @Test
    @Order(2)
    void testGetText() {
        Answer right = new Answer("Vrai", true);
        assertThat(right.getText()).isEqualTo("Vrai");
        Answer wrong = new Answer("Faux", false);
        assertThat(wrong.getText()).isEqualTo("Faux");
    }

    @Test
    @Order(3)
    void testIsRight() {
        Answer right = new Answer("Vrai", true);
        assertThat(right.isRight()).isEqualTo(true);
        Answer wrong = new Answer("Faux", false);
        assertThat(wrong.isRight()).isEqualTo(false);
    }

}
