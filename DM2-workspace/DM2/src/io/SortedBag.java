package io;

import java.util.List;

public interface SortedBag<E extends Comparable<E>> { // edit this line as needed: <E extends ...>
    // do not edit below
    void put(E element);
    E removeFirst();
    E removeLast();
    boolean isEmpty();
    int count(E element);
    List<E> getElements();
}
