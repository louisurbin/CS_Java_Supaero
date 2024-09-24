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

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public void display(){
        System.out.println(super.toString());
        System.out.println(this.toString());
    }
}