package order;

import java.util.Set;
import java.util.TreeSet;

public class FruitMain {

    public static void main(String[] args) {
        Set<Fruit> fruits = new TreeSet<>();
        fruits.add(new Fruit("green", "banana"));
        fruits.add(new Fruit("yellow", "banana"));
        fruits.add(new Fruit("black", "banana"));
        fruits.add(new Fruit("yellow", "apple"));
        fruits.add(new Fruit("green", "apple"));
        fruits.add(new Fruit("red", "apple"));

        for (Fruit fruit : fruits) {
            System.out.println(fruit);
        }
    }

}
