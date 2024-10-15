package vscodegen;

public class Person {
    protected String name;
    protected int age;

    // constructor
    /**
     * 
     * @param name
     * @param age
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // methods
    /**
     * 
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * 
     * @return
     */
    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", age='" + getAge() + "'" +
            "}";
    }

    public void display() {
        System.out.println(this);
    } 
    
}

