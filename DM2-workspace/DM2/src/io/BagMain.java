package io;

import java.io.IOException;
import java.util.Arrays;

public class BagMain {
    public static void main(String[] args) {
        int[] data = { 2, 1, 1, 4, 3, 2, 1, 3, 2, 1 };
        System.out.println("Input data: " + Arrays.toString(data));

        // // put(E) + isEmpty() + getElements()
        // SimpleSortedBag<Integer> bag = new SimpleSortedBag<>();
        // System.out.println("is empty: " + bag.isEmpty());
        // for (int element : data) {
        //     bag.put(element);
        // }
        // System.out.println(bag.getElements()); // expect: [1, 1, 1, 1, 2, 2, 2, 3, 3, 4]
        // System.out.println("is empty: " + bag.isEmpty());

        // // count()
        // System.out.println(bag.count(1) + " occurrences of 1");
        // System.out.println(bag.count(2) + " occurrences of 2");
        // System.out.println(bag.count(3) + " occurrences of 3");
        // System.out.println(bag.count(4) + " occurrences of 4");

        // // removeXxx() + count()
        // System.out.println("removeFirst: " + bag.removeFirst());
        // System.out.println("removeLast: " + bag.removeLast());
        // System.out.println(bag.count(1) + " occurrences of 1");
        // System.out.println(bag.count(2) + " occurrences of 2");
        // System.out.println(bag.count(3) + " occurrences of 3");
        // System.out.println(bag.count(4) + " occurrences of 4");

        // // toString()
        // System.out.println(bag); // expect: [1, 1, 1, 2, 2, 2, 3, 3]

        // // simple I/O: each line is a number to put in the bag
        // IntegerBagIO io = new IntegerBagIO();
        // SimpleSortedBag<Integer> ioBag = new SimpleSortedBag<>();
        // ioBag.put(42);
        // io.updateBagFromFile(ioBag, "data/integers.csv");
        // System.out.println(ioBag); // expect: sorted numbers from input file and additional 42
        // io.writeBagToFile(ioBag, "data/integers_bag.csv"); // expect: new file with same content
    }
}
