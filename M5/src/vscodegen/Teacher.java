package vscodegen;

public class Teacher extends Person {
    private String subject;

    // constructor
    public Teacher(String subject, String name, int age) {
        super(name, age);
        this.subject = subject;
    }
    
    // methods
    public String getSubject() {
        return this.subject;
    }

    @Override
    public String toString() {
        return "Prof. " + name + ", " + this.subject;
    }

}
