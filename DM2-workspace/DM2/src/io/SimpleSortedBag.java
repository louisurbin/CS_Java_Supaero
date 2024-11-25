package io;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleSortedBag<E extends Comparable<E>> implements SortedBag<E> {
    protected List<E> elements;

    public SimpleSortedBag() {
        elements = new ArrayList<>();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public String toString() {
        return elements.toString();
    }

    public void put(E element) {
        elements.add(element);
        Collections.sort(elements);
    }

    public int count(E element) {
        int count = 0;
        for(E e : elements) {
            if (e.equals(element)) {
                count++;
            }
        }
        return count;
    }

    public E removeFirst() {
        return this.elements.removeFirst();
    }

    public E removeLast() {
        return this.elements.removeLast();
    }

    public List<E> getElements() {
        return Collections.unmodifiableList(elements);
    }
}
