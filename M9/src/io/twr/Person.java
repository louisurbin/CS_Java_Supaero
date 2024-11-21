package persons;

public class Person {
   private String name;
   private int age;

   public Person(String name, int age) {
      if(age < 0){
         throw new IllegalArgumentException(String.format("age = %d must be positive",age));
      }
      if(name == null){
         throw new IllegalArgumentException("name must not be null");
      }
      this.name = name;
      this.age = age;
   }

   // @Override uncomment this leads to a compilation error
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
      // return name.equals(person.name) && age == person.age;
      return name == person.name && age == person.age;
   }

}
