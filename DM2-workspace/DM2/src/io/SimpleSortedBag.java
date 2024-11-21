package io;

import java.util.TreeMap;

public class SimpleSortedBag<E> implements SortedBag<E> {
    protected TreeMap<E, Integer> elements;

    public SimpleSortedBag() {
        this.elements = new TreeMap<>();
    }

    public String toString() {
        return elements.toString();
    }

    public void put(E element) {
        if (elements.containsKey(element)) {
            elements.put(element, elements.get(element) + 1);
        } else {
            elements.put(element, 1);
        }
    }

    public void removeFirst() {
        if (elements.isEmpty()) {
            return;
        }
        else {
            E first
        }
    }
}
