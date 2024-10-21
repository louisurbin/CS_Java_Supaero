package persons;

import java.util.TreeMap;
//import java.util.HashMap;

public class MapMain {
    public static void main(String[] args) {
        /* 
        HashMap<Person, String> persons = new HashMap<>();  
        persons.put(new Person("Paul", 32), "Paul");
        System.out.println(persons);
        System.out.println(persons.containsKey(new Person("Paul", 32)));
        */

        TreeMap<Person, String> persons = new TreeMap<>();
        persons.put(new Person("Paul", 32), "Paul");
        persons.put(new Person("Paul", 18), "Paul");
        System.out.println(persons);
    }
}
