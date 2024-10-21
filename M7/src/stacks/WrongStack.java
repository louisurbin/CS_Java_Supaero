package stacks;

import java.util.ArrayList;

public class WrongStack<E> extends ArrayList<E> implements Stack<E> {
    
    public WrongStack() {
        super();
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

    public void push(E element){
        if (element == null){
            System.out.println("error");
        }
        else{
            super.add(element);
        }
    }

    public E pop(){
        if (super.isEmpty()){
            return null;
        }
        else{
            E last = super.get(super.size() - 1);
            super.remove(super.size() - 1);
            return last;
        }
    }
}
