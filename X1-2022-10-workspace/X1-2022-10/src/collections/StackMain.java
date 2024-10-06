package collections;

public class StackMain {
    public static void main(String[] args) {
        Stack stack = new Stack<String>();
        
        stack.push("a");
        stack.push("b");
        stack.push("c");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
