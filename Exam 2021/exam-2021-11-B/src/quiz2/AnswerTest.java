package quiz2;

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
        Answer right = new Answer("Vrai", 100.0);
        assertThat(right).isNotNull();
        assertThat(right).extracting("text").isEqualTo("Vrai");
        assertThat(right).extracting("percent").isEqualTo(100.0);
        Answer wrong = new Answer("Faux", 0.0);
        assertThat(wrong).isNotNull();
        assertThat(wrong).extracting("text").isEqualTo("Faux");
        assertThat(wrong).extracting("percent").isEqualTo(0.0);
    }

    @Test
    @Order(2)
    void testGetText() {
        Answer right = new Answer("Vrai", 100.0);
        assertThat(right.getText()).isEqualTo("Vrai");
        Answer wrong = new Answer("Faux", 0.0);
        assertThat(wrong.getText()).isEqualTo("Faux");
    }

    @Test
    @Order(3)
    void testGetPercent() {
        Answer right = new Answer("Vrai", 100.0);
        assertThat(right.getPercent()).isEqualTo(100.0);
        Answer wrong = new Answer("Faux", 0.0);
        assertThat(wrong.getPercent()).isEqualTo(0.0);
    }

}
