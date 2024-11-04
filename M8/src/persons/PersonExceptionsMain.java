package persons;

public class PersonExceptionsMain {
    public static void main(String[] args) {
        Person p1 = new Person("Obelix", 44);
        Person p2 = new Person("Kevin", 21);
        //Person p3 = new Person("Obelix", -1);
        Person p4 = new Person(null, 44);
    }
}
