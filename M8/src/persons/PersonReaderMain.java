package persons;

import java.util.ArrayList;

public class PersonReaderMain {
    public static void main(String[] args) {
        ArrayList<Person> persons = PersonReader.read("data/persons.txt");
        for (Person p : persons) {
            System.out.println(p);
        }
    }
}
