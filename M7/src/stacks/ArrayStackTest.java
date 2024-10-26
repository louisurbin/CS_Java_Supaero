package stacks;

import fr.supaero.matchers.assertions.TypeAssertions;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import fr.supaero.matchers.utils.TypeInfo;

@TestMethodOrder(OrderAnnotation.class)
public class ArrayStackTest implements WithAssertions {

   private TypeInfo typeInfo = TypeInfo.info(ArrayStack.class);
   final static private String listAttribute = "elements";

   @Test
   @Order(0)
   public void wrongStackClassContent() {
      TypeAssertions.assertThat(typeInfo)
            .isDeclaredAs("public class ArrayStack<E>")
            .extendsClass("Object")
            .implementsExactlyInterfaces("Stack<E>")
            .declaresMethod("public boolean isEmpty()")
            .declaresMethod("public void push(E)")
            .declaresMethod("public E pop()");
   }

   @Test
   @Order(1)
   public void canCreateStack() {
      ArrayStack<String> stack = new ArrayStack<>();
      assertThat(stack).extracting(listAttribute).asList()
            .isEmpty();
   }

   @Test
   @Order(2)
   public void canPush() {
      ArrayStack<String> stack = new ArrayStack<>();
      stack.push("X");
      stack.push("Y");
      stack.push("Z");
      assertThat(stack).extracting(listAttribute).asList()
            .contains("X", "Y", "Z");
   }

   @Test
   @Order(3)
   public void popOrderIsOk() {
      ArrayStack<String> stack = new ArrayStack<>();
      stack.push("X");
      stack.push("Y");
      stack.push("Z");
      assertThat(stack.pop()).isEqualTo("Z");
      assertThat(stack).extracting(listAttribute).asList()
            .doesNotContain("Z");
      assertThat(stack.pop()).isEqualTo("Y");
      assertThat(stack).extracting(listAttribute).asList()
            .doesNotContain("Y");
      assertThat(stack.pop()).isEqualTo("X");
      assertThat(stack).extracting(listAttribute).asList()
            .doesNotContain("X");
   }

   @Test
   @Order(4)
   public void testIsEmpty() {
      ArrayStack<String> stack = new ArrayStack<>();
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
      ArrayStack<String> stack = new ArrayStack<>();
      stack.pop();
      stack.push("X");
      assertThat(stack).extracting(listAttribute).asList()
            .contains("X");
   }
}
