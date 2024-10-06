package collections;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
public class BasicStackTest implements WithAssertions {

   @Test
   @Order(1)
   public void canCreateStack() {
      Stack<String> stack = new Stack<>();
      assertThat(stack).extracting("elements")
            .isNotNull()
            .asList()
            .isEmpty();
   }

   @Test
   @Order(2)
   public void canPush() {
      Stack<String> stack = new Stack<>();
      stack.push("X");
      stack.push("Y");
      stack.push("Z");
      assertThat(stack).extracting("elements")
            .asList()
            .contains("X", "Y", "Z");
   }

   @Test
   @Order(3)
   public void popOrderIsOk() {
      Stack<String> stack = new Stack<>();
      stack.push("X");
      stack.push("Y");
      stack.push("Z");
      assertThat(stack.pop()).isEqualTo("Z");
      assertThat(stack).extracting("elements")
            .asList()
            .doesNotContain("Z");
      assertThat(stack.pop()).isEqualTo("Y");
      assertThat(stack).extracting("elements")
            .asList()
            .doesNotContain("Y");
      assertThat(stack.pop()).isEqualTo("X");
      assertThat(stack).extracting("elements")
            .asList()
            .doesNotContain("X");
   }

   @Test
   @Order(4)
   public void testIsEmpty() {
      Stack<String> stack = new Stack<>();
      assertThat(stack.isEmpty()).isTrue();

      stack.push("X");
      assertThat(stack.isEmpty()).isFalse();

      stack.pop();
      assertThat(stack.isEmpty()).isTrue();

      stack.push("Y");
      stack.push("Z");
      assertThat(stack.isEmpty()).isFalse();

      stack.pop();
      assertThat(stack.isEmpty()).isFalse();
      stack.pop();
      assertThat(stack.isEmpty()).isTrue();
   }

   @Test
   @Order(5)
   public void popEmptyStackDoesNotBreakStack() {
      Stack<String> stack = new Stack<>();
      stack.pop();
      stack.push("X");
      assertThat(stack).extracting("elements")
            .asList()
            .contains("X");
   }
}
