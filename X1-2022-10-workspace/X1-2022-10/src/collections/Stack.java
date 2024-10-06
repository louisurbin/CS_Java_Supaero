package collections;

import java.util.ArrayList;

public class Stack<E> {
    private ArrayList<E> elements;

    public Stack(){
        this.elements = new ArrayList<>();
    }

    public boolean isEmpty(){
        return this.elements.isEmpty();
    }

    public void push(E element){
        this.elements.add(element);
    }

    public E pop(){
        if(this.elements.isEmpty()){
            return null;
        }
        else{
            E elt = this.elements.get(this.elements.size()-1);
            this.elements.remove(this.elements.size()-1);
            return elt;
        }
    }
}
