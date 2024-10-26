package stacks;

import java.util.ArrayList; 

public class ArrayStack<E> implements Stack<E> {
    private ArrayList<E> elements;
    
    public ArrayStack() {
        elements = new ArrayList<>();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public void push(E element){
        if (element == null){
            System.out.println("error");
        }
        else{
            elements.add(element);
        }
    }

    public E pop(){
        if (elements.isEmpty()){
            return null;
        }
        else{
            E last = elements.get(elements.size() - 1);
            elements.remove(elements.size() - 1);
            return last;
        }
    }

    public String toString(){
        return elements.toString();
    }
}
