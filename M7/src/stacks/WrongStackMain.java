package stacks;

public class WrongStackMain {
    public static void main(String[] args) {
        Stack<String> stack_old = new WrongStack<>();
        WrongStack<String> stack = (WrongStack<String>) stack_old;
        stack.push("X");
        stack.push("Y");
        stack.push("Z");
        stack.remove(1);
        System.out.println(stack);
        stack.add(1, "A");
        stack.set(2, "B");
        System.out.println(stack);
    }
}
