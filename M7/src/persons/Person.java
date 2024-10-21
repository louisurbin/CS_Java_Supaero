package persons;

import java.util.Objects;

public class Person implements Comparable<Person> {
   private String name;
   private int age;

   public Person(String name, int age) {
      this.name = name;
      this.age = age;
   }

   // @Override uncommenting this leads to a compilation error
   public String getName() {
      return name;
   }

   public int getAge() {
      return age;
   }

   public void display() {
      System.out.println(super.toString());
      System.out.println(this.toString());
   }

   @Override
   public String toString() {
      return name + " : " + age + " ans";
   }

   @Override
   public boolean equals(Object o) {
      if (o == this)
         return true;
      if (!(o instanceof Person)) {
         return false;
      }
      Person person = (Person) o;
      return this.name.equals(person.name) && this.age == person.age;
   }

   @Override
   public int hashCode() {
      return Objects.hash(this.name, this.age);
   }

   @Override
   public int compareTo(Person person) {
      if (this.equals(person)){
         return 0;
      }
      if (this.name.equals(person.name)) {
         return Integer.compare(this.age, person.age);
      }
      return this.name.compareTo(person.name);
   }
}
