package persons;

public class PersonMain {
    public static void main(String[] args){
        Person person = new Person("Asterix", 32);
        System.out.println(person);
        Object object = new Object();
        System.out.println(object);
        person.display();
    } 
}
