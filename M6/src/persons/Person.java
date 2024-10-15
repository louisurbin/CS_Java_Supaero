package persons;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    //methods
    @Override
    public String toString(){
        return name + " : " + age + " ans";
    }

    final public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public void display(){
        System.out.println(super.toString());
        System.out.println(this.toString());
    }

    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }
        if(!(obj instanceof Person)){
            return false;
        }
        Person p = (Person) obj;
        return this.name.equals(p.name) && this.age == p.age;
    }
}