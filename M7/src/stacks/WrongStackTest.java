package stacks;

import fr.supaero.matchers.assertions.TypeAssertions;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import fr.supaero.matchers.utils.TypeInfo;

@TestMethodOrder(OrderAnnotation.class)
public class WrongStackTest implements WithAssertions {

   private TypeInfo typeInfo = TypeInfo.info(WrongStack.class);

   @Test
   @Order(0)
   public void wrongStackClassContent() {
      TypeAssertions.assertThat(typeInfo)
         .isDeclaredAs("public class WrongStack<E>")
         .extendsImplements("extends ArrayList<E>")
         .hasMethodCountBetween(2, 3)
         .declaresMethod("public void push(E)")
         .declaresMethod("public E pop()");
   }

   @Test
   @Order(1)
   public void canCreateStack() {
      WrongStack<String> stack = new WrongStack<>();
      assertThat(stack).extracting("elementData")
            .isNotNull()
            .asList()
            .isEmpty();
   }

   @Test
   @Order(2)
   public void canPush() {
      WrongStack<String> stack = new WrongStack<>();
      stack.push("X");
      stack.push("Y");
      stack.push("Z");
      assertThat(stack).contains("X", "Y", "Z");
   }

   @Test
   @Order(3)
   public void popOrderIsOk() {
      WrongStack<String> stack = new WrongStack<>();
      stack.push("X");
      stack.push("Y");
      stack.push("Z");
      assertThat(stack.pop()).isEqualTo("Z");
      assertThat(stack).doesNotContain("Z");
      assertThat(stack.pop()).isEqualTo("Y");
      assertThat(stack).doesNotContain("Y");
      assertThat(stack.pop()).isEqualTo("X");
      assertThat(stack).doesNotContain("X");
   }

   @Test
   @Order(4)
   public void testIsEmpty() {
      WrongStack<String> stack = new WrongStack<>();
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
      WrongStack<String> stack = new WrongStack<>();
      stack.pop();
      stack.push("X");
      assertThat(stack).contains("X");
   }
}
